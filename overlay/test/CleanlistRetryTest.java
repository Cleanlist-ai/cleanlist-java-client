package ai.cleanlist.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.cleanlist.client.model.ActionCall;
import ai.cleanlist.client.model.ConfirmCall;
import ai.cleanlist.client.model.CreateListRequest;
import ai.cleanlist.client.model.ListDetailResponse;
import ai.cleanlist.client.model.ReplyBody;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

class CleanlistRetryTest {

    private static final String LIST =
            "{\"list_id\":\"l1\",\"name\":\"Q3\",\"lead_count\":0,\"enriched_count\":0}";
    private static final String UNAVAILABLE = "{\"error\":{\"code\":\"idempotency_unavailable\"}}";

    /** Answers from a script instead of the network and records every request. */
    static final class Fake implements Interceptor {
        final List<Request> requests = new ArrayList<>();
        final List<String[]> script;

        Fake(String[]... script) {
            this.script = Arrays.asList(script);
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            requests.add(chain.request());
            String[] next = script.get(Math.min(requests.size() - 1, script.size() - 1));
            if ("IO".equals(next[0])) {
                throw new IOException("connection reset");
            }
            Response.Builder b = new Response.Builder()
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_1)
                    .code(Integer.parseInt(next[0]))
                    .message("x")
                    .body(ResponseBody.create(next[1], MediaType.get("application/json")));
            for (int i = 2; i + 1 < next.length; i += 2) {
                b.header(next[i], next[i + 1]);
            }
            return b.build();
        }
    }

    private static Fake install(Cleanlist cl, String[]... script) {
        Fake fake = new Fake(script);
        ApiClient api = cl.getApiClient();
        api.setHttpClient(api.getHttpClient().newBuilder().addInterceptor(fake).build());
        return fake;
    }

    @Test
    void retries429And5xxWithOneIdempotencyKey() throws Exception {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake fake = install(cl,
                new String[] {"429", "{}", "Retry-After", "0"},
                new String[] {"503", UNAVAILABLE, "Retry-After", "0"},
                new String[] {"200", LIST, "X-RateLimit-Limit", "600", "X-RateLimit-Remaining", "599",
                    "X-RateLimit-Reset", "1762790400"});
        ListDetailResponse list = cl.leadLists.createList(new CreateListRequest().name("Q3"));
        assertEquals("l1", list.getListId());
        assertEquals(3, fake.requests.size());
        String key = fake.requests.get(0).header("Idempotency-Key");
        assertNotNull(key);
        for (Request r : fake.requests) {
            assertEquals(key, r.header("Idempotency-Key"));
        }
        assertEquals("Bearer clapi_live_abc", fake.requests.get(2).header("Authorization"));
        assertEquals(599, cl.getLastResponse().getRateLimit().getRemaining());
        assertEquals(1762790400L, cl.getLastResponse().getRateLimit().getReset());
        assertEquals("live", cl.getMode());
    }

    @Test
    void callerKeyWinsAndReadsGetNone() throws Exception {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake fake = install(cl, new String[] {"200", LIST});
        cl.withIdempotencyKey("order-1", () -> cl.leadLists.createList(new CreateListRequest().name("Q3")));
        cl.leadLists.createList(new CreateListRequest().name("Q3"));
        assertThrows(Exception.class, () -> cl.workspace.whoami()); // body isn't a whoami; headers are what matter
        assertEquals("order-1", fake.requests.get(0).header("Idempotency-Key"));
        assertNotEquals("order-1", fake.requests.get(1).header("Idempotency-Key"));
        assertNotNull(fake.requests.get(1).header("Idempotency-Key"));
        assertNull(fake.requests.get(2).header("Idempotency-Key"));
        assertThrows(IllegalArgumentException.class, () -> cl.withIdempotencyKey("", () -> null));
        assertThrows(IllegalArgumentException.class,
                () -> cl.withIdempotencyKey(new String(new char[256]).replace('\0', 'k'), () -> null));
    }

    @Test
    void givesUpAfterMaxAttemptsAndThrows() {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x", 2);
        Fake fake = install(cl, new String[] {"500", "{}", "Retry-After", "0"});
        ApiException err = assertThrows(ApiException.class, () -> cl.workspace.whoami());
        assertEquals(500, err.getCode());
        assertEquals(2, fake.requests.size());
        assertEquals(500, ResponseMeta.from(err.getCode(), err.getResponseHeaders()).getStatus());
    }

    @Test
    void noRetryOn4xxOrLongRetryAfter() {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake bad = install(cl, new String[] {"422", "{}"});
        assertThrows(ApiException.class, () -> cl.workspace.whoami());
        assertEquals(1, bad.requests.size());
        Cleanlist daily = new Cleanlist("clapi_live_abc", "https://x");
        Fake limited = install(daily, new String[] {"429", "{}", "Retry-After", "3600"});
        assertThrows(ApiException.class, () -> daily.workspace.whoami());
        assertEquals(1, limited.requests.size());
    }

    @Test
    void modeFromKeyThenFromServer() throws Exception {
        assertEquals("test", new Cleanlist("clapi_test_abc", "https://x").getMode());
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        install(cl, new String[] {"200", LIST, "Cleanlist-Mode", "test", "Idempotent-Replayed", "true"});
        cl.leadLists.createList(new CreateListRequest().name("Q3"));
        assertEquals("test", cl.getMode());
        assertTrue(cl.getLastResponse().isIdempotentReplayed());
        assertNull(cl.getLastResponse().getRateLimit());
    }

    @Test
    void backoffAndRetryAfterParsing() {
        long first = RetryInterceptor.retryDelayMs(503, null, 1, 3);
        assertTrue(first >= 500 && first < 750, "first backoff " + first);
        long second = RetryInterceptor.retryDelayMs(503, null, 2, 3);
        assertTrue(second >= 1000 && second < 1250, "second backoff " + second);
        assertEquals(-1, RetryInterceptor.retryDelayMs(503, null, 3, 3));
        assertEquals(-1, RetryInterceptor.retryDelayMs(400, "1", 1, 3));
        assertEquals(2000, RetryInterceptor.retryDelayMs(429, "2", 1, 3));
        assertEquals(0, RetryInterceptor.retryDelayMs(429, "Wed, 21 Oct 2015 07:28:00 GMT", 1, 3));
        long junk = RetryInterceptor.retryDelayMs(429, "soon", 1, 3);
        assertTrue(junk >= 500 && junk < 750);
    }

    @Test
    void retriesNetworkFailuresOnReadsAndKeyedWrites() throws Exception {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake fake = install(cl, new String[] {"IO", ""}, new String[] {"200", "[]"});
        assertEquals(0, cl.gtmAgents.listGtmAgents().size());
        assertEquals(2, fake.requests.size());

        Cleanlist once = new Cleanlist("clapi_live_abc", "https://x", 2);
        Fake down = install(once, new String[] {"IO", ""});
        ApiException err = assertThrows(ApiException.class, () -> once.workspace.whoami());
        assertTrue(err.getCause() instanceof IOException);
        assertEquals(2, down.requests.size());
    }

    @Test
    void a500Or502OnAPostIsNotRetried() {
        for (String status : new String[] {"500", "502"}) {
            Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
            Fake fake = install(cl, new String[] {status, "{}"}, new String[] {"200", LIST});
            ApiException err = assertThrows(ApiException.class,
                    () -> cl.leadLists.createList(new CreateListRequest().name("Q3")));
            assertEquals(Integer.parseInt(status), err.getCode());
            assertEquals(1, fake.requests.size());
        }
    }

    @Test
    void a503IdempotencyUnavailableOnAPostIsRetriedWithTheSameKey() throws Exception {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake fake = install(cl, new String[] {"503", UNAVAILABLE}, new String[] {"200", LIST});
        cl.withIdempotencyKey("run-7", () -> cl.leadLists.createList(new CreateListRequest().name("Q3")));
        assertEquals(2, fake.requests.size());
        assertEquals("run-7", fake.requests.get(0).header("Idempotency-Key"));
        assertEquals("run-7", fake.requests.get(1).header("Idempotency-Key"));

        Cleanlist bare = new Cleanlist("clapi_live_abc", "https://x");
        Fake other = install(bare, new String[] {"503", "{\"error\":{\"code\":\"service_unavailable\"}}"});
        assertThrows(ApiException.class, () -> bare.leadLists.createList(new CreateListRequest().name("Q3")));
        assertEquals(1, other.requests.size());
    }

    @Test
    void a429OnAPostIsRetried() throws Exception {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake fake = install(cl, new String[] {"429", "{}"}, new String[] {"200", LIST});
        assertEquals("l1", cl.leadLists.createList(new CreateListRequest().name("Q3")).getListId());
        assertEquals(2, fake.requests.size());
    }

    @Test
    void aGet500IsStillRetried() throws Exception {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake fake = install(cl, new String[] {"500", "{}"}, new String[] {"200", "[]"});
        assertEquals(0, cl.gtmAgents.listGtmAgents().size());
        assertEquals(2, fake.requests.size());
    }

    @Test
    void inboxReplyIsNeverRetried() {
        for (String[] first : new String[][] {
            {"502", "{\"error\":{\"code\":\"send_unconfirmed\"}}"}, {"429", "{}"}, {"503", UNAVAILABLE}, {"IO", ""}}) {
            Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
            Fake fake = install(cl, first, new String[] {"200", "{}"});
            assertThrows(ApiException.class,
                    () -> cl.inbox.replyInInboxThread(UUID.randomUUID(), new ReplyBody().body("hi")));
            assertEquals(1, fake.requests.size(), first[0]);
            assertTrue(fake.requests.get(0).url().encodedPath().endsWith("/reply"));
        }
    }

    @Test
    void confirmIsNeverRetried() {
        for (String[] first : new String[][] {{"500", "{}"}, {"429", "{}"}, {"503", UNAVAILABLE}, {"IO", ""}}) {
            Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
            Fake fake = install(cl, first, new String[] {"200", "{}"});
            assertThrows(ApiException.class, () -> cl.actions.confirmCard(
                    new ConfirmCall().cardId("c1").sessionId(UUID.randomUUID())));
            assertEquals(1, fake.requests.size(), first[0]);
            assertEquals("/api/v2/actions/confirm", fake.requests.get(0).url().encodedPath());
        }
    }

    @Test
    void aConflictOnAWriteIsNotRetried() {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        Fake conflict = install(cl,
                new String[] {"409", "{\"error\":{\"code\":\"idempotency_in_progress\"}}", "Retry-After", "0"});
        assertThrows(ApiException.class, () -> cl.actions.callAction("lists.get", new ActionCall()));
        assertEquals(1, conflict.requests.size());
    }

    @Test
    void retryInterceptorTurnsOffOkHttpReconnects() {
        Cleanlist cl = new Cleanlist("clapi_live_abc", "https://x");
        assertFalse(cl.getApiClient().getHttpClient().retryOnConnectionFailure());
    }
}
