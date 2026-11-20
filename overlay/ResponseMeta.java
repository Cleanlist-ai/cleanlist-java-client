/*
 * Rate-limit, mode and replay headers of a Cleanlist API response.
 *
 * Hand-authored (not generated) and re-applied on every regeneration by
 * scripts/generate.sh.
 */
package ai.cleanlist.client;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/** Rate-limit, mode and replay headers of one response. */
public final class ResponseMeta {

    /** {@code X-RateLimit-*} of the tightest bucket that applied. */
    public static final class RateLimit {
        private final long limit;
        private final long remaining;
        private final long reset;

        public RateLimit(long limit, long remaining, long reset) {
            this.limit = limit;
            this.remaining = remaining;
            this.reset = reset;
        }

        /** Requests allowed in the bucket. */
        public long getLimit() {
            return limit;
        }

        /** Requests left in the bucket. */
        public long getRemaining() {
            return remaining;
        }

        /** Unix seconds when the bucket refills. */
        public long getReset() {
            return reset;
        }
    }

    private final int status;
    private final RateLimit rateLimit;
    private final String mode;
    private final boolean idempotentReplayed;

    private ResponseMeta(int status, RateLimit rateLimit, String mode, boolean idempotentReplayed) {
        this.status = status;
        this.rateLimit = rateLimit;
        this.mode = mode;
        this.idempotentReplayed = idempotentReplayed;
    }

    /**
     * Reads the headers of any response, e.g. {@code ApiException.getResponseHeaders()} or
     * {@code ApiResponse.getHeaders()}.
     */
    public static ResponseMeta from(int status, Map<String, List<String>> headers) {
        Long limit = longHeader(headers, "X-RateLimit-Limit");
        Long remaining = longHeader(headers, "X-RateLimit-Remaining");
        Long reset = longHeader(headers, "X-RateLimit-Reset");
        String mode = header(headers, "Cleanlist-Mode");
        if (mode == null) {
            mode = header(headers, "X-Cleanlist-Mode");
        }
        mode = mode == null ? null : mode.toLowerCase(Locale.ROOT);
        if (!"test".equals(mode) && !"live".equals(mode)) {
            mode = null;
        }
        return new ResponseMeta(
                status,
                limit != null && remaining != null && reset != null
                        ? new RateLimit(limit, remaining, reset)
                        : null,
                mode,
                "true".equalsIgnoreCase(header(headers, "Idempotent-Replayed")));
    }

    static String header(Map<String, List<String>> headers, String name) {
        if (headers == null) {
            return null;
        }
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            if (entry.getKey() != null
                    && entry.getKey().equalsIgnoreCase(name)
                    && entry.getValue() != null
                    && !entry.getValue().isEmpty()
                    && entry.getValue().get(0) != null) {
                return entry.getValue().get(0).trim();
            }
        }
        return null;
    }

    private static Long longHeader(Map<String, List<String>> headers, String name) {
        String raw = header(headers, name);
        if (raw == null || raw.isEmpty()) {
            return null;
        }
        try {
            return (long) Double.parseDouble(raw);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int getStatus() {
        return status;
    }

    /** {@code null} when the response carried no rate-limit headers. */
    public RateLimit getRateLimit() {
        return rateLimit;
    }

    /** {@code "test"} for a test key's sandbox workspace, from {@code Cleanlist-Mode}; else {@code "live"} or {@code null}. */
    public String getMode() {
        return mode;
    }

    /** True when the server replayed a stored response for a repeated {@code Idempotency-Key}. */
    public boolean isIdempotentReplayed() {
        return idempotentReplayed;
    }
}
