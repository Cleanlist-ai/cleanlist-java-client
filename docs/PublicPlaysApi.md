# PublicPlaysApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getPlayEvent**](PublicPlaysApi.md#getPlayEvent) | **GET** /api/v2/plays/{playbook_id}/events/{event_id} | Get Play Event |
| [**listPlays**](PublicPlaysApi.md#listPlays) | **GET** /api/v2/plays | List Plays |
| [**runPlay**](PublicPlaysApi.md#runPlay) | **POST** /api/v2/plays/{playbook_id}/runs | Run Play |


<a id="getPlayEvent"></a>
# **getPlayEvent**
> PlayEventDto getPlayEvent(playbookId, eventId)

Get Play Event

A record a play run admitted: whether a run took it yet, and which.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPlaysApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPlaysApi apiInstance = new PublicPlaysApi(defaultClient);
    String playbookId = "playbookId_example"; // String | 
    String eventId = "eventId_example"; // String | 
    try {
      PlayEventDto result = apiInstance.getPlayEvent(playbookId, eventId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPlaysApi#getPlayEvent");
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
| **playbookId** | **String**|  | |
| **eventId** | **String**|  | |

### Return type

[**PlayEventDto**](PlayEventDto.md)

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

<a id="listPlays"></a>
# **listPlays**
> List&lt;PlayDto&gt; listPlays()

List Plays

This organization&#39;s agent plays, each with the inputs its webhook trigger reads. A play without one has no inputs.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPlaysApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPlaysApi apiInstance = new PublicPlaysApi(defaultClient);
    try {
      List<PlayDto> result = apiInstance.listPlays();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPlaysApi#listPlays");
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

[**List&lt;PlayDto&gt;**](PlayDto.md)

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

<a id="runPlay"></a>
# **runPlay**
> ResponseRunPlayApiV2PlaysPlaybookIdRunsPost runPlay(playbookId, runPlayBody, xConfirmChannel)

Run Play

Run the play on one record made of &#x60;&#x60;inputs&#x60;&#x60;, as its webhook would: a preview without &#x60;&#x60;commit&#x60;&#x60;, and with it a quote and the approval the play needs.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPlaysApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPlaysApi apiInstance = new PublicPlaysApi(defaultClient);
    String playbookId = "playbookId_example"; // String | 
    RunPlayBody runPlayBody = new RunPlayBody(); // RunPlayBody | 
    String xConfirmChannel = "xConfirmChannel_example"; // String | 
    try {
      ResponseRunPlayApiV2PlaysPlaybookIdRunsPost result = apiInstance.runPlay(playbookId, runPlayBody, xConfirmChannel);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPlaysApi#runPlay");
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
| **playbookId** | **String**|  | |
| **runPlayBody** | [**RunPlayBody**](RunPlayBody.md)|  | |
| **xConfirmChannel** | **String**|  | [optional] |

### Return type

[**ResponseRunPlayApiV2PlaysPlaybookIdRunsPost**](ResponseRunPlayApiV2PlaysPlaybookIdRunsPost.md)

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

