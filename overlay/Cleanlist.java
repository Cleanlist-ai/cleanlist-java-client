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

import ai.cleanlist.client.api.PublicEnrichmentApi;
import ai.cleanlist.client.api.PublicExportApi;
import ai.cleanlist.client.api.PublicLeadListsApi;
import ai.cleanlist.client.api.PublicPeopleFinderApi;
import ai.cleanlist.client.api.PublicSmartAgentsApi;
import ai.cleanlist.client.api.PublicWorkspaceApi;

/**
 * Authenticated entry point exposing every Cleanlist API resource group:
 * {@link #workspace}, {@link #leadLists}, {@link #peopleFinder}, {@link #enrichment},
 * {@link #smartAgents}, and {@link #export}.
 */
public class Cleanlist {

    /** Production API base URL. */
    public static final String DEFAULT_BASE_PATH = "https://api.cleanlist.ai";

    /** Environment variable read when no access token is passed explicitly. */
    public static final String API_KEY_ENV_VAR = "CLEANLIST_API_KEY";

    private final ApiClient apiClient;

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

        this.workspace = new PublicWorkspaceApi(apiClient);
        this.leadLists = new PublicLeadListsApi(apiClient);
        this.peopleFinder = new PublicPeopleFinderApi(apiClient);
        this.enrichment = new PublicEnrichmentApi(apiClient);
        this.smartAgents = new PublicSmartAgentsApi(apiClient);
        this.export = new PublicExportApi(apiClient);
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
}
