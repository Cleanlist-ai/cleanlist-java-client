/*
 * Retries and idempotency keys for the Cleanlist API.
 *
 * Hand-authored (not generated) and re-applied on every regeneration by
 * scripts/generate.sh. Cleanlist installs it on the ApiClient's OkHttpClient.
 */
package ai.cleanlist.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Gives each write one {@code Idempotency-Key} that stays the same across its retries (a key
 * already on the request wins) and retries what the server can't have run, with backoff that
 * honors {@code Retry-After}. Reads retry on network failures, 429s and 5xx. Writes retry on
 * 429s, a 503 {@code idempotency_unavailable}, and a network failure with no response when they
 * carry a key; never on any other 5xx, which may have run the route. {@code POST
 * /api/v2/actions/confirm} and inbox replies are never retried. A {@code Retry-After} over a
 * minute returns the response instead of waiting.
 */
public class RetryInterceptor implements Interceptor {

    /** Total tries per request, the first one included. */
    public static final int DEFAULT_MAX_ATTEMPTS = 3;
    /** A {@code Retry-After} longer than this is returned to the caller instead of waited out. */
    public static final long MAX_RETRY_DELAY_MS = 60_000L;
    public static final String IDEMPOTENCY_HEADER = "Idempotency-Key";

    private static final Set<String> WRITE_METHODS =
            new HashSet<>(Arrays.asList("POST", "PUT", "PATCH", "DELETE"));

    /** Key for the next write on this thread; set by {@link Cleanlist#withIdempotencyKey}. */
    static final ThreadLocal<String> NEXT_KEY = new ThreadLocal<>();

    /** Single-use writes: a second try after a lost response can't be told apart from a repeat. */
    private static final Pattern NEVER_RETRY_PATH =
            Pattern.compile("/api/v2/(actions/confirm|inbox/threads/[^/]+/reply)/?$");

    /** Sleeps between tries; replaceable in tests. */
    interface Sleeper {
        void sleep(long millis) throws InterruptedException;
    }

    private final int maxAttempts;
    private final Sleeper sleeper;
    private volatile ResponseMeta lastResponse;

    public RetryInterceptor(int maxAttempts) {
        this(maxAttempts, Thread::sleep);
    }

    RetryInterceptor(int maxAttempts, Sleeper sleeper) {
        this.maxAttempts = Math.max(1, maxAttempts);
        this.sleeper = sleeper;
    }

    /** Rate-limit, mode and replay headers of the most recent response. */
    public ResponseMeta getLastResponse() {
        return lastResponse;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (WRITE_METHODS.contains(request.method()) && request.header(IDEMPOTENCY_HEADER) == null) {
            String key = NEXT_KEY.get();
            request = request.newBuilder()
                    .header(IDEMPOTENCY_HEADER, key != null ? key : UUID.randomUUID().toString())
                    .build();
        }
        boolean write = WRITE_METHODS.contains(request.method());
        int tries = write && NEVER_RETRY_PATH.matcher(request.url().encodedPath()).find() ? 1 : maxAttempts;
        boolean retryNetworkFailure = !write || request.header(IDEMPOTENCY_HEADER) != null;
        for (int attempt = 1; ; attempt++) {
            Response response;
            try {
                response = chain.proceed(request);
            } catch (IOException e) {
                if (!retryNetworkFailure || attempt >= tries || chain.call().isCanceled()) {
                    throw e;
                }
                pause(retryDelayMs(503, null, attempt, tries));
                continue;
            }
            long delay = canRetryStatus(write, response)
                    ? retryDelayMs(response.code(), response.header("Retry-After"), attempt, tries)
                    : -1;
            if (delay < 0) {
                lastResponse = ResponseMeta.from(response.code(), response.headers().toMultimap());
                return response;
            }
            response.close();
            pause(delay);
        }
    }

    private void pause(long millis) throws IOException {
        try {
            sleeper.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("Interrupted while waiting to retry");
        }
    }

    /**
     * Reads retry on 429 and 5xx. Writes retry on 429 and a 503 {@code idempotency_unavailable}
     * (refused before the route ran); the server doesn't store a 5xx under the key, so retrying
     * any other 5xx would run the route again.
     */
    static boolean canRetryStatus(boolean write, Response response) {
        int status = response.code();
        if (status == 429) {
            return true;
        }
        if (!write) {
            return status >= 500;
        }
        return status == 503 && "idempotency_unavailable".equals(errorCode(response));
    }

    /** The error envelope's {@code code}, read without consuming the body. */
    private static String errorCode(Response response) {
        try {
            JsonElement root = JsonParser.parseString(response.peekBody(65_536).string());
            if (!root.isJsonObject()) {
                return null;
            }
            JsonObject holder = root.getAsJsonObject();
            JsonElement error = holder.get("error");
            if (error != null && error.isJsonObject()) {
                holder = error.getAsJsonObject();
            }
            JsonElement code = holder.get("code");
            return code != null && code.isJsonPrimitive() ? code.getAsString() : null;
        } catch (IOException | RuntimeException e) {
            return null;
        }
    }

    /** Milliseconds to wait before try {@code attempt + 1}, or -1 to stop and return the response. */
    static long retryDelayMs(int status, String retryAfter, int attempt, int maxAttempts) {
        if (attempt >= maxAttempts || !(status == 429 || status >= 500)) {
            return -1;
        }
        long delay = parseRetryAfterMs(retryAfter);
        if (delay < 0) {
            delay = Math.min(8_000L, 500L << Math.min(attempt - 1, 10))
                    + ThreadLocalRandom.current().nextLong(250);
        }
        return delay > MAX_RETRY_DELAY_MS ? -1 : delay;
    }

    private static long parseRetryAfterMs(String value) {
        if (value == null || value.trim().isEmpty()) {
            return -1;
        }
        String trimmed = value.trim();
        try {
            return Math.max(0L, (long) (Double.parseDouble(trimmed) * 1000));
        } catch (NumberFormatException ignored) {
            // Not seconds; try an HTTP date.
        }
        try {
            long when = ZonedDateTime.parse(trimmed, DateTimeFormatter.RFC_1123_DATE_TIME).toInstant().toEpochMilli();
            return Math.max(0L, when - System.currentTimeMillis());
        } catch (DateTimeParseException e) {
            return -1;
        }
    }
}
