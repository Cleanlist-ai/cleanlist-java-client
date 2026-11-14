# PublicGtmAgentsApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createGtmAgent**](PublicGtmAgentsApi.md#createGtmAgent) | **POST** /api/v2/gtm-agents | Create Gtm Agent |
| [**getGtmAgent**](PublicGtmAgentsApi.md#getGtmAgent) | **GET** /api/v2/gtm-agents/{agent_id} | Get Gtm Agent |
| [**getGtmRun**](PublicGtmAgentsApi.md#getGtmRun) | **GET** /api/v2/gtm-runs/{run_id} | Get Gtm Run |
| [**listGtmAgentRuns**](PublicGtmAgentsApi.md#listGtmAgentRuns) | **GET** /api/v2/gtm-agents/{agent_id}/runs | List Gtm Agent Runs |
| [**listGtmAgents**](PublicGtmAgentsApi.md#listGtmAgents) | **GET** /api/v2/gtm-agents | List Gtm Agents |
| [**listGtmRunRecords**](PublicGtmAgentsApi.md#listGtmRunRecords) | **GET** /api/v2/gtm-runs/{run_id}/records | List Gtm Run Records |
| [**patchGtmAgent**](PublicGtmAgentsApi.md#patchGtmAgent) | **PATCH** /api/v2/gtm-agents/{agent_id} | Patch Gtm Agent |
| [**runGtmAgent**](PublicGtmAgentsApi.md#runGtmAgent) | **POST** /api/v2/gtm-agents/{agent_id}/runs | Run Gtm Agent |
| [**setGtmAgentStatus**](PublicGtmAgentsApi.md#setGtmAgentStatus) | **POST** /api/v2/gtm-agents/{agent_id}/status | Set Gtm Agent Status |


<a id="createGtmAgent"></a>
# **createGtmAgent**
> AgentDto createGtmAgent(createGtmAgentBody)

Create Gtm Agent

A draft agent, off, with no play, owned by the caller, with any settings.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    CreateGtmAgentBody createGtmAgentBody = new CreateGtmAgentBody(); // CreateGtmAgentBody | 
    try {
      AgentDto result = apiInstance.createGtmAgent(createGtmAgentBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#createGtmAgent");
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
| **createGtmAgentBody** | [**CreateGtmAgentBody**](CreateGtmAgentBody.md)|  | |

### Return type

[**AgentDto**](AgentDto.md)

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

<a id="getGtmAgent"></a>
# **getGtmAgent**
> AgentDto getGtmAgent(agentId)

Get Gtm Agent

One agent, with its plays and status.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    String agentId = "agentId_example"; // String | 
    try {
      AgentDto result = apiInstance.getGtmAgent(agentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#getGtmAgent");
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
| **agentId** | **String**|  | |

### Return type

[**AgentDto**](AgentDto.md)

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

<a id="getGtmRun"></a>
# **getGtmRun**
> RunDetailDto getGtmRun(runId)

Get Gtm Run

One run: its status, counts and per-step stats.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    String runId = "runId_example"; // String | 
    try {
      RunDetailDto result = apiInstance.getGtmRun(runId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#getGtmRun");
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
| **runId** | **String**|  | |

### Return type

[**RunDetailDto**](RunDetailDto.md)

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

<a id="listGtmAgentRuns"></a>
# **listGtmAgentRuns**
> List&lt;RunSummaryDto&gt; listGtmAgentRuns(agentId)

List Gtm Agent Runs

The agent&#39;s runs, newest first.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    String agentId = "agentId_example"; // String | 
    try {
      List<RunSummaryDto> result = apiInstance.listGtmAgentRuns(agentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#listGtmAgentRuns");
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
| **agentId** | **String**|  | |

### Return type

[**List&lt;RunSummaryDto&gt;**](RunSummaryDto.md)

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

<a id="listGtmAgents"></a>
# **listGtmAgents**
> List&lt;AgentDto&gt; listGtmAgents()

List Gtm Agents

This organization&#39;s agents, newest first.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    try {
      List<AgentDto> result = apiInstance.listGtmAgents();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#listGtmAgents");
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

[**List&lt;AgentDto&gt;**](AgentDto.md)

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

<a id="listGtmRunRecords"></a>
# **listGtmRunRecords**
> RecordsPageDto listGtmRunRecords(runId, nodeId, status, cursor, limit, include)

List Gtm Run Records

A page of the run&#39;s records, and with &#x60;&#x60;include&#x3D;outputs&#x60;&#x60; what each step wrote for them.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    String runId = "runId_example"; // String | 
    String nodeId = "nodeId_example"; // String | 
    String status = "status_example"; // String | 
    String cursor = "cursor_example"; // String | 
    Integer limit = 100; // Integer | 
    String include = "outputs"; // String | `outputs` adds each record's step outputs.
    try {
      RecordsPageDto result = apiInstance.listGtmRunRecords(runId, nodeId, status, cursor, limit, include);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#listGtmRunRecords");
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
| **runId** | **String**|  | |
| **nodeId** | **String**|  | [optional] |
| **status** | **String**|  | [optional] |
| **cursor** | **String**|  | [optional] |
| **limit** | **Integer**|  | [optional] [default to 100] |
| **include** | **String**| &#x60;outputs&#x60; adds each record&#39;s step outputs. | [optional] [enum: outputs] |

### Return type

[**RecordsPageDto**](RecordsPageDto.md)

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

<a id="patchGtmAgent"></a>
# **patchGtmAgent**
> AgentDto patchGtmAgent(agentId, patchGtmAgentBody)

Patch Gtm Agent

Change the name, settings or schedule, by the portal&#39;s PATCH rules. An agent that is on changes only its name, description and favorite.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    String agentId = "agentId_example"; // String | 
    PatchGtmAgentBody patchGtmAgentBody = new PatchGtmAgentBody(); // PatchGtmAgentBody | 
    try {
      AgentDto result = apiInstance.patchGtmAgent(agentId, patchGtmAgentBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#patchGtmAgent");
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
| **agentId** | **String**|  | |
| **patchGtmAgentBody** | [**PatchGtmAgentBody**](PatchGtmAgentBody.md)|  | |

### Return type

[**AgentDto**](AgentDto.md)

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

<a id="runGtmAgent"></a>
# **runGtmAgent**
> ResponseRunGtmAgentApiV2GtmAgentsAgentIdRunsPost runGtmAgent(agentId, runGtmAgentBody, xConfirmChannel)

Run Gtm Agent

Start one live run of the agent&#39;s play now: a preview without &#x60;&#x60;commit&#x60;&#x60;, and with it a quote and the approval its play needs. Answers &#x60;&#x60;{run_id, agent_id, status, message}&#x60;&#x60;, or &#x60;&#x60;queued&#x60;&#x60; with no run yet when a CRM cleanup play waits for its scan.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    String agentId = "agentId_example"; // String | 
    RunGtmAgentBody runGtmAgentBody = new RunGtmAgentBody(); // RunGtmAgentBody | 
    String xConfirmChannel = "xConfirmChannel_example"; // String | 
    try {
      ResponseRunGtmAgentApiV2GtmAgentsAgentIdRunsPost result = apiInstance.runGtmAgent(agentId, runGtmAgentBody, xConfirmChannel);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#runGtmAgent");
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
| **agentId** | **String**|  | |
| **runGtmAgentBody** | [**RunGtmAgentBody**](RunGtmAgentBody.md)|  | |
| **xConfirmChannel** | **String**|  | [optional] |

### Return type

[**ResponseRunGtmAgentApiV2GtmAgentsAgentIdRunsPost**](ResponseRunGtmAgentApiV2GtmAgentsAgentIdRunsPost.md)

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

<a id="setGtmAgentStatus"></a>
# **setGtmAgentStatus**
> ResponseSetGtmAgentStatusApiV2GtmAgentsAgentIdStatusPost setGtmAgentStatus(agentId, gtmAgentStatusBody, xConfirmChannel)

Set Gtm Agent Status

Turn an agent off, or on with the On toggle&#39;s checks: a preview without &#x60;&#x60;commit&#x60;&#x60;, and with it a quote and the approval its plays need (see the module note).

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmAgentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmAgentsApi apiInstance = new PublicGtmAgentsApi(defaultClient);
    String agentId = "agentId_example"; // String | 
    GtmAgentStatusBody gtmAgentStatusBody = new GtmAgentStatusBody(); // GtmAgentStatusBody | 
    String xConfirmChannel = "xConfirmChannel_example"; // String | 
    try {
      ResponseSetGtmAgentStatusApiV2GtmAgentsAgentIdStatusPost result = apiInstance.setGtmAgentStatus(agentId, gtmAgentStatusBody, xConfirmChannel);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmAgentsApi#setGtmAgentStatus");
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
| **agentId** | **String**|  | |
| **gtmAgentStatusBody** | [**GtmAgentStatusBody**](GtmAgentStatusBody.md)|  | |
| **xConfirmChannel** | **String**|  | [optional] |

### Return type

[**ResponseSetGtmAgentStatusApiV2GtmAgentsAgentIdStatusPost**](ResponseSetGtmAgentStatusApiV2GtmAgentsAgentIdStatusPost.md)

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

