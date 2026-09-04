# PublicSmartAgentsApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getSmartAgentResults**](PublicSmartAgentsApi.md#getSmartAgentResults) | **GET** /api/v2/smart-agents/{smart_agent_task_id} | Get smart agent results |
| [**listSmartAgents**](PublicSmartAgentsApi.md#listSmartAgents) | **GET** /api/v2/smart-agents | List smart agent runs |
| [**runSmartAgent**](PublicSmartAgentsApi.md#runSmartAgent) | **POST** /api/v2/smart-agents/run | Run a smart agent |


<a id="getSmartAgentResults"></a>
# **getSmartAgentResults**
> SmartAgentResultsResponse getSmartAgentResults(smartAgentTaskId)

Get smart agent results

Poll a smart-agent run for status, progress, and per-lead output.  Returns the run&#39;s lifecycle &#x60;status&#x60;, a &#x60;progress&#x60; percentage, and succeeded / failed / total counters, along with a &#x60;results&#x60; array holding each lead&#39;s agent output (or its error). Poll this after POST /smart-agents/run until &#x60;status&#x60; is &#x60;completed&#x60; (or &#x60;failed&#x60;) — the &#x60;results&#x60; array grows as leads finish, so a still-running run returns a partial set. Access is checked via the run&#39;s list, and unknown or inaccessible run ids return 404. This endpoint is free and does not consume credits.  **📖 Docs:** https://docs.cleanlist.ai/guides/using-ai-agents

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSmartAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSmartAgentsApi apiInstance = new PublicSmartAgentsApi(defaultClient);
    String smartAgentTaskId = "smartAgentTaskId_example"; // String | Canonical id from /smart-agents/run's `smart_agent_task_id` field
    try {
      SmartAgentResultsResponse result = apiInstance.getSmartAgentResults(smartAgentTaskId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSmartAgentsApi#getSmartAgentResults");
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
| **smartAgentTaskId** | **String**| Canonical id from /smart-agents/run&#39;s &#x60;smart_agent_task_id&#x60; field | |

### Return type

[**SmartAgentResultsResponse**](SmartAgentResultsResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

<a id="listSmartAgents"></a>
# **listSmartAgents**
> ListSmartAgentsResponse listSmartAgents(listId, limit)

List smart agent runs

List recent smart-agent runs with live progress counters.  Returns each run&#39;s id, target list, agent type, status, and processed / failed / total counts so you can track in-flight and completed runs. Pass &#x60;list_id&#x60; to scope to a single list (access-checked so a known id can&#39;t enumerate another workspace&#39;s history); omit it for a caller-scoped rollup across every list you can see. This endpoint is free and does not consume credits. To read the per-lead output of any run, call GET /smart-agents/{smart_agent_task_id}.  **📖 Docs:** https://docs.cleanlist.ai/guides/using-ai-agents

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSmartAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSmartAgentsApi apiInstance = new PublicSmartAgentsApi(defaultClient);
    String listId = "listId_example"; // String | Optional lead-list UUID. When set, returns only runs for that list (access-checked). When omitted, returns a rollup of recent runs across every list the caller can see.
    Integer limit = 20; // Integer | Maximum number of runs to return, most recent first.
    try {
      ListSmartAgentsResponse result = apiInstance.listSmartAgents(listId, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSmartAgentsApi#listSmartAgents");
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
| **listId** | **String**| Optional lead-list UUID. When set, returns only runs for that list (access-checked). When omitted, returns a rollup of recent runs across every list the caller can see. | [optional] |
| **limit** | **Integer**| Maximum number of runs to return, most recent first. | [optional] [default to 20] |

### Return type

[**ListSmartAgentsResponse**](ListSmartAgentsResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

<a id="runSmartAgent"></a>
# **runSmartAgent**
> RunSmartAgentResponse runSmartAgent(runSmartAgentRequest)

Run a smart agent

Launch an AI smart agent over the leads in a list and return a run id.  Pick an &#x60;agent_type&#x60; — &#x60;custom_ai&#x60; (your own &#x60;prompt&#x60;), &#x60;cold_intro_email&#x60; (personalized opener), or a preset research agent — and the run executes asynchronously as a smart column, one AI call per lead. Runs are metered per lead by agent type (e.g. &#x60;custom_ai&#x60; ≈ 1 credit/lead, &#x60;cold_intro_email&#x60; ≈ 3 credits/lead) and require a single-use &#x60;quote_id&#x60; from POST /credits/estimate; credits are debited as rows complete. Scope with &#x60;lead_scope&#x3D;\&quot;subset\&quot;&#x60; + &#x60;max_rows&#x60; for speed and cost control — a &#x60;lead_scope&#x3D;\&quot;all\&quot;&#x60; run above the approval threshold (default 500 leads) is blocked with a 400 &#x60;approval_required&#x60; until you narrow it or route a human approval. The response returns immediately with &#x60;status&#x3D;\&quot;pending\&quot;&#x60;; poll GET /smart-agents/{smart_agent_task_id} for progress and per-lead results.  **📖 Docs:** https://docs.cleanlist.ai/guides/using-ai-agents

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSmartAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSmartAgentsApi apiInstance = new PublicSmartAgentsApi(defaultClient);
    RunSmartAgentRequest runSmartAgentRequest = new RunSmartAgentRequest(); // RunSmartAgentRequest | 
    try {
      RunSmartAgentResponse result = apiInstance.runSmartAgent(runSmartAgentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSmartAgentsApi#runSmartAgent");
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
| **runSmartAgentRequest** | [**RunSmartAgentRequest**](RunSmartAgentRequest.md)|  | |

### Return type

[**RunSmartAgentResponse**](RunSmartAgentResponse.md)

### Authorization

[HTTPBearer](../README.md#HTTPBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **422** | Validation Error |  -  |

