# PublicWorkspaceApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**creditsBalance**](PublicWorkspaceApi.md#creditsBalance) | **GET** /api/v2/credits/balance | Get credit balance |
| [**creditsEstimate**](PublicWorkspaceApi.md#creditsEstimate) | **POST** /api/v2/credits/estimate | Estimate cost &amp; get a signed quote |
| [**listApiKeys**](PublicWorkspaceApi.md#listApiKeys) | **GET** /api/v2/api-keys | List API keys |
| [**usageReport**](PublicWorkspaceApi.md#usageReport) | **GET** /api/v2/usage | Get usage report |
| [**whoami**](PublicWorkspaceApi.md#whoami) | **GET** /api/v2/whoami | Get current identity &amp; entitlements |


<a id="creditsBalance"></a>
# **creditsBalance**
> CreditsBalanceResponse creditsBalance()

Get credit balance

Return the current spendable credit balance for the caller&#39;s organization. Reads the authoritative &#x60;organizations.credits_count&#x60; and returns it with a short &#x60;agent_instructions&#x60; nudge summarizing remaining credits. Requires the &#x60;credits:read&#x60; scope and deducts no credits itself. Use this before large operations, and pair it with &#x60;POST /credits/estimate&#x60; to confirm a specific action is affordable before spending.  **📖 Docs:** https://docs.cleanlist.ai/api-reference/credits

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWorkspaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWorkspaceApi apiInstance = new PublicWorkspaceApi(defaultClient);
    try {
      CreditsBalanceResponse result = apiInstance.creditsBalance();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWorkspaceApi#creditsBalance");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CreditsBalanceResponse**](CreditsBalanceResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **400** | Bad request. |  -  |
| **401** | Authentication required or invalid. |  -  |
| **403** | Permission denied or feature not enabled. |  -  |
| **404** | Resource not found. |  -  |
| **409** | Resource conflict. |  -  |
| **429** | Rate limited. |  -  |
| **500** | Internal error. |  -  |
| **502** | Upstream provider error. |  -  |
| **422** | Request failed validation. |  -  |

<a id="creditsEstimate"></a>
# **creditsEstimate**
> EstimateCostResponse creditsEstimate(estimateCostRequest)

Estimate cost &amp; get a signed quote

Pre-flight a paid operation and mint a signed, single-use &#x60;quote_id&#x60;. The quote binds the canonical request (tool, list_id|filters|cohort, scope, row_count, org) via HMAC and must be presented at execution time by every paid bulk tool (&#x60;enrich_list&#x60;, &#x60;run_smart_agent&#x60;, &#x60;sync_to_crm&#x60;, &#x60;sync_to_sequencer&#x60;, cohort enrichments). Row count is derived authoritatively from the list or cohort — never trusted from the caller — so a small quote can&#39;t be replayed against a large job. Requires the &#x60;credits:read&#x60; scope; estimating itself is free, and the response reports whether the org has &#x60;sufficient&#x60; credits to proceed.  **📖 Docs:** https://docs.cleanlist.ai/api-reference/credits

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWorkspaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWorkspaceApi apiInstance = new PublicWorkspaceApi(defaultClient);
    EstimateCostRequest estimateCostRequest = new EstimateCostRequest(); // EstimateCostRequest | 
    try {
      EstimateCostResponse result = apiInstance.creditsEstimate(estimateCostRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWorkspaceApi#creditsEstimate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **estimateCostRequest** | [**EstimateCostRequest**](EstimateCostRequest.md)|  | |

### Return type

[**EstimateCostResponse**](EstimateCostResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Request failed validation. |  -  |
| **400** | Bad request. |  -  |
| **401** | Authentication required or invalid. |  -  |
| **403** | Permission denied or feature not enabled. |  -  |
| **404** | Resource not found. |  -  |
| **409** | Resource conflict. |  -  |
| **429** | Rate limited. |  -  |
| **500** | Internal error. |  -  |
| **502** | Upstream provider error. |  -  |

<a id="listApiKeys"></a>
# **listApiKeys**
> ApiKeysResponse listApiKeys()

List API keys

List the caller&#39;s API keys, showing only the prefix and last 4 characters — full secret values are never returned. Results are user-scoped and further filtered to the calling token&#39;s organization (defense in depth), so a Clerk user in multiple orgs only sees keys belonging to the active org. Requires the &#x60;admin:api_keys&#x60; scope and deducts no credits. Scopes are granted per-user today, so each key reports the caller&#39;s own scopes.  **📖 Docs:** https://docs.cleanlist.ai/api-reference/authentication

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWorkspaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWorkspaceApi apiInstance = new PublicWorkspaceApi(defaultClient);
    try {
      ApiKeysResponse result = apiInstance.listApiKeys();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWorkspaceApi#listApiKeys");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ApiKeysResponse**](ApiKeysResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **400** | Bad request. |  -  |
| **401** | Authentication required or invalid. |  -  |
| **403** | Permission denied or feature not enabled. |  -  |
| **404** | Resource not found. |  -  |
| **409** | Resource conflict. |  -  |
| **429** | Rate limited. |  -  |
| **500** | Internal error. |  -  |
| **502** | Upstream provider error. |  -  |
| **422** | Request failed validation. |  -  |

<a id="usageReport"></a>
# **usageReport**
> UsageReportResponse usageReport(days, groupBy)

Get usage report

Aggregate this organization&#39;s public-API request log over the last &#x60;days&#x60; (1-365, default 7), grouped by &#x60;tool&#x60;, &#x60;key&#x60;, &#x60;day&#x60;, or &#x60;error&#x60;. Returns per-bucket call counts and error counts plus window totals, so admins can audit traffic and spot failing integrations. Requires the &#x60;admin:api_keys&#x60; scope and deducts no credits. Note: until the request log gains cost/ tool-name columns, &#x60;group_by&#x3D;\&quot;tool\&quot;&#x60; buckets by request path and &#x60;credits_spent&#x60; is always 0.0.  **📖 Docs:** https://docs.cleanlist.ai/api-reference/credits

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWorkspaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWorkspaceApi apiInstance = new PublicWorkspaceApi(defaultClient);
    Integer days = 7; // Integer | 
    String groupBy = "tool"; // String | 
    try {
      UsageReportResponse result = apiInstance.usageReport(days, groupBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWorkspaceApi#usageReport");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **days** | **Integer**|  | [optional] [default to 7] |
| **groupBy** | **String**|  | [optional] [default to tool] [enum: tool, key, day, error] |

### Return type

[**UsageReportResponse**](UsageReportResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Request failed validation. |  -  |
| **400** | Bad request. |  -  |
| **401** | Authentication required or invalid. |  -  |
| **403** | Permission denied or feature not enabled. |  -  |
| **404** | Resource not found. |  -  |
| **409** | Resource conflict. |  -  |
| **429** | Rate limited. |  -  |
| **500** | Internal error. |  -  |
| **502** | Upstream provider error. |  -  |

<a id="whoami"></a>
# **whoami**
> WhoamiResponse whoami()

Get current identity &amp; entitlements

Introspect the authenticated principal and its effective entitlements. Returns the caller&#39;s identity (user, org, auth type, scopes) plus the resolved plan &#x60;tier&#x60;, any &#x60;appsumo_tier&#x60;, and the merged &#x60;features&#x60; list the server-side gates actually enforce — letting clients (and the MCP) tier-filter their advertised tools before hitting a gated route. This endpoint is free and deducts no credits; for API-key auth the returned &#x60;user_email&#x60; is masked so a leaked key can&#39;t reveal the creator&#39;s address, and display-name lookups are best-effort (null on a transient miss).  **📖 Docs:** https://docs.cleanlist.ai/api-reference/authentication

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWorkspaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWorkspaceApi apiInstance = new PublicWorkspaceApi(defaultClient);
    try {
      WhoamiResponse result = apiInstance.whoami();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWorkspaceApi#whoami");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**WhoamiResponse**](WhoamiResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **400** | Bad request. |  -  |
| **401** | Authentication required or invalid. |  -  |
| **403** | Permission denied or feature not enabled. |  -  |
| **404** | Resource not found. |  -  |
| **409** | Resource conflict. |  -  |
| **429** | Rate limited. |  -  |
| **500** | Internal error. |  -  |
| **502** | Upstream provider error. |  -  |
| **422** | Request failed validation. |  -  |

