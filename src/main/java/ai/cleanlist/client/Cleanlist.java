/*
 * High-level convenience client for the Cleanlist API.
 *
 * Hand-authored (not generated) and re-applied on every regeneration by
 * scripts/generate.sh. It wires an authenticated ApiClient to every resource
 * group so you can write:
 *
 * <pre>{@code
 * Cleanlist cl = new Cleanlist("clapi_live_...");
 * WhoamiResponse me = cl.workspace.whoami();
 * ListDetailResponse list = cl.leadLists.createList(new CreateListRequest().name("Q3 outbound"));
 * }</pre>
 *
 * Prefer the generated API classes directly? They're all available too
 * (e.g. {@code new PublicWorkspaceApi(apiClient)}); this is just sugar.
 */
package ai.cleanlist.client;

import ai.cleanlist.client.api.PublicAccountsDataApi;
import ai.cleanlist.client.api.PublicActionsApi;
import ai.cleanlist.client.api.PublicEnrichmentApi;
import ai.cleanlist.client.api.PublicExportApi;
import ai.cleanlist.client.api.PublicGtmAgentsApi;
import ai.cleanlist.client.api.PublicGtmTasksApi;
import ai.cleanlist.client.api.PublicInboxApi;
import ai.cleanlist.client.api.PublicLeadListsApi;
import ai.cleanlist.client.api.PublicPeopleFinderApi;
import ai.cleanlist.client.api.PublicPlaysApi;
import ai.cleanlist.client.api.PublicSignalsApi;
import ai.cleanlist.client.api.PublicSmartAgentsApi;
import ai.cleanlist.client.api.PublicWebhooksApi;
import ai.cleanlist.client.api.PublicWorkspaceApi;

/**
 * Authenticated entry point exposing every Cleanlist API resource group:
 * {@link #workspace}, {@link #leadLists}, {@link #peopleFinder}, {@link #enrichment},
 * {@link #smartAgents}, {@link #export}, {@link #actions}, {@link #gtmAgents}, {@link #plays},
 * {@link #gtmTasks}, {@link #inbox}, {@link #signals}, {@link #accountsData} and {@link #webhooks}.
 */
public class Cleanlist {

    /** Production API base URL. */
    public static final String DEFAULT_BASE_PATH = "https://api.cleanlist.ai";

    /** Environment variable read when no access token is passed explicitly. */
    public static final String API_KEY_ENV_VAR = "CLEANLIST_API_KEY";

    private final ApiClient apiClient;
    private final RetryInterceptor retries;
    private final String keyMode;

    /** Identity, credits, API keys, usage. */
    public final PublicWorkspaceApi workspace;
    /** Create/manage lists and their leads. */
    public final PublicLeadListsApi leadLists;
    /** Search people by filters, find people at companies. */
    public final PublicPeopleFinderApi peopleFinder;
    /** Person/company/bulk enrichment + status polling. */
    public final PublicEnrichmentApi enrichment;
    /** Run smart agents and fetch results. */
    public final PublicSmartAgentsApi smartAgents;
    /** CSV (signed URL) and JSON export. */
    public final PublicExportApi export;
    /** Every action this key may use, run by name; spend and send actions take a signed quote. */
    public final PublicActionsApi actions;
    /** GTM agents: create, read, turn on or off, start live runs, read runs and records. */
    public final PublicGtmAgentsApi gtmAgents;
    /** Plays: list, run, read run events. */
    public final PublicPlaysApi plays;
    /** Agent tasks and the updates feed. */
    public final PublicGtmTasksApi gtmTasks;
    /** Inbox threads: list, read, update, reply. */
    public final PublicInboxApi inbox;
    /** Job postings, job changes, LinkedIn posts and engagers, tech adoption, company signals. */
    public final PublicSignalsApi signals;
    /** Buying committee, org structure, meetings. */
    public final PublicAccountsDataApi accountsData;
    /** Webhook subscriptions and their deliveries. */
    public final PublicWebhooksApi webhooks;

    /**
     * @param accessToken your Cleanlist API key (sent as {@code Authorization: Bearer <key>}).
     *     If {@code null}/empty, falls back to the {@code CLEANLIST_API_KEY} env var.
     */
    public Cleanlist(String accessToken) {
        this(accessToken, DEFAULT_BASE_PATH);
    }

    /**
     * @param accessToken your Cleanlist API key. Falls back to {@code CLEANLIST_API_KEY}.
     * @param basePath API base URL (e.g. {@code http://localhost:8000} for local dev).
     */
    public Cleanlist(String accessToken, String basePath) {
        this(accessToken, basePath, RetryInterceptor.DEFAULT_MAX_ATTEMPTS);
    }

    /**
     * @param accessToken your Cleanlist API key. Falls back to {@code CLEANLIST_API_KEY}.
     * @param basePath API base URL (e.g. {@code http://localhost:8000} for local dev).
     * @param maxAttempts tries per request, the first included (default 3). 429s and 5xx are
     *     retried with backoff, honoring {@code Retry-After}; writes carry an {@code Idempotency-Key}
     *     that stays the same across retries. {@code 1} turns retries off.
     */
    public Cleanlist(String accessToken, String basePath, int maxAttempts) {
        if (accessToken == null || accessToken.isEmpty()) {
            accessToken = System.getenv(API_KEY_ENV_VAR);
        }
        if (accessToken == null || accessToken.isEmpty()) {
            throw new IllegalArgumentException(
                    "A Cleanlist API key is required. Pass it to the constructor or set the "
                            + API_KEY_ENV_VAR + " environment variable.");
        }

        this.apiClient = new ApiClient();
        this.apiClient.setBasePath(
                (basePath == null || basePath.isEmpty()) ? DEFAULT_BASE_PATH : basePath);
        this.apiClient.setBearerToken(accessToken);
        this.retries = new RetryInterceptor(maxAttempts);
        this.apiClient.setHttpClient(
                this.apiClient.getHttpClient().newBuilder().addInterceptor(retries).build());
        this.keyMode = accessToken.startsWith("clapi_test_") ? "test" : "live";

        this.workspace = new PublicWorkspaceApi(apiClient);
        this.leadLists = new PublicLeadListsApi(apiClient);
        this.peopleFinder = new PublicPeopleFinderApi(apiClient);
        this.enrichment = new PublicEnrichmentApi(apiClient);
        this.smartAgents = new PublicSmartAgentsApi(apiClient);
        this.export = new PublicExportApi(apiClient);
        this.actions = new PublicActionsApi(apiClient);
        this.gtmAgents = new PublicGtmAgentsApi(apiClient);
        this.plays = new PublicPlaysApi(apiClient);
        this.gtmTasks = new PublicGtmTasksApi(apiClient);
        this.inbox = new PublicInboxApi(apiClient);
        this.signals = new PublicSignalsApi(apiClient);
        this.accountsData = new PublicAccountsDataApi(apiClient);
        this.webhooks = new PublicWebhooksApi(apiClient);
    }

    /**
     * Build a client from the environment: the key from {@code CLEANLIST_API_KEY} and an optional
     * base URL from {@code CLEANLIST_HOST} (defaults to production).
     */
    public static Cleanlist fromEnv() {
        return new Cleanlist(null, System.getenv("CLEANLIST_HOST"));
    }

    /** The underlying generated client (timeouts, interceptors, custom base path, …). */
    public ApiClient getApiClient() {
        return apiClient;
    }

    /** Rate-limit, mode and replay headers of the most recent response, or {@code null} before the first. */
    public ResponseMeta getLastResponse() {
        return retries.getLastResponse();
    }

    /** {@code "test"} when the server says so ({@code Cleanlist-Mode: test}), else what the key prefix implies. */
    public String getMode() {
        ResponseMeta last = retries.getLastResponse();
        return last != null && last.getMode() != null ? last.getMode() : keyMode;
    }

    /** One API call, run on the calling thread. */
    @FunctionalInterface
    public interface ApiCall<T> {
        T call() throws ApiException;
    }

    /**
     * Runs one synchronous call with your own {@code Idempotency-Key} instead of a generated one:
     * <pre>{@code
     * cl.withIdempotencyKey("order-1234", () -> cl.leadLists.createList(request));
     * }</pre>
     *
     * @param key 1 to 255 characters
     */
    public <T> T withIdempotencyKey(String key, ApiCall<T> call) throws ApiException {
        if (key == null || key.isEmpty() || key.length() > 255) {
            throw new IllegalArgumentException("An Idempotency-Key must be 1 to 255 characters.");
        }
        String previous = RetryInterceptor.NEXT_KEY.get();
        RetryInterceptor.NEXT_KEY.set(key);
        try {
            return call.call();
        } finally {
            if (previous == null) {
                RetryInterceptor.NEXT_KEY.remove();
            } else {
                RetryInterceptor.NEXT_KEY.set(previous);
            }
        }
    }
}
