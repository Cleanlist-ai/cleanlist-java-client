# PublicInboxApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listInboxThreads**](PublicInboxApi.md#listInboxThreads) | **GET** /api/v2/inbox/threads | List Inbox Threads |
| [**readInboxThread**](PublicInboxApi.md#readInboxThread) | **GET** /api/v2/inbox/threads/{thread_id} | Read Inbox Thread |
| [**replyInInboxThread**](PublicInboxApi.md#replyInInboxThread) | **POST** /api/v2/inbox/threads/{thread_id}/reply | Reply In Inbox Thread |
| [**updateInboxThread**](PublicInboxApi.md#updateInboxThread) | **PATCH** /api/v2/inbox/threads/{thread_id} | Update Inbox Thread |


<a id="listInboxThreads"></a>
# **listInboxThreads**
> Map&lt;String, List&lt;Map&lt;String, Object&gt;&gt;&gt; listInboxThreads(status, since, q, limit, offset)

List Inbox Threads

Inbox conversations newest first, as the Inbox lists them. &#x60;&#x60;done&#x60;&#x60; is the archived ones; &#x60;&#x60;since&#x60;&#x60; keeps those with a message on or after that day (UTC).

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicInboxApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicInboxApi apiInstance = new PublicInboxApi(defaultClient);
    String status = "open"; // String | 
    String since = "since_example"; // String | YYYY-MM-DD
    String q = "q_example"; // String | 
    Integer limit = 50; // Integer | 
    Integer offset = 0; // Integer | 
    try {
      Map<String, List<Map<String, Object>>> result = apiInstance.listInboxThreads(status, since, q, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicInboxApi#listInboxThreads");
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
| **status** | **String**|  | [optional] [default to open] [enum: open, needs_reply, snoozed, done] |
| **since** | **String**| YYYY-MM-DD | [optional] |
| **q** | **String**|  | [optional] |
| **limit** | **Integer**|  | [optional] [default to 50] |
| **offset** | **Integer**|  | [optional] [default to 0] |

### Return type

[**Map&lt;String, List&lt;Map&lt;String, Object&gt;&gt;&gt;**](List.md)

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

<a id="readInboxThread"></a>
# **readInboxThread**
> Object readInboxThread(threadId)

Read Inbox Thread

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicInboxApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicInboxApi apiInstance = new PublicInboxApi(defaultClient);
    UUID threadId = UUID.randomUUID(); // UUID | 
    try {
      Object result = apiInstance.readInboxThread(threadId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicInboxApi#readInboxThread");
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
| **threadId** | **UUID**|  | |

### Return type

**Object**

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

<a id="replyInInboxThread"></a>
# **replyInInboxThread**
> Object replyInInboxThread(threadId, replyBody)

Reply In Inbox Thread

Reply to the lead from the address the Inbox replies from. Needs &#x60;&#x60;commit: true&#x60;&#x60;; without it the answer names who would get it.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicInboxApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicInboxApi apiInstance = new PublicInboxApi(defaultClient);
    UUID threadId = UUID.randomUUID(); // UUID | 
    ReplyBody replyBody = new ReplyBody(); // ReplyBody | 
    try {
      Object result = apiInstance.replyInInboxThread(threadId, replyBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicInboxApi#replyInInboxThread");
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
| **threadId** | **UUID**|  | |
| **replyBody** | [**ReplyBody**](ReplyBody.md)|  | |

### Return type

**Object**

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

<a id="updateInboxThread"></a>
# **updateInboxThread**
> Object updateInboxThread(threadId, updateThreadBody)

Update Inbox Thread

&#x60;&#x60;done&#x60;&#x60; archives the conversation and closes its Reply task; &#x60;&#x60;open&#x60;&#x60; brings it back.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicInboxApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicInboxApi apiInstance = new PublicInboxApi(defaultClient);
    UUID threadId = UUID.randomUUID(); // UUID | 
    UpdateThreadBody updateThreadBody = new UpdateThreadBody(); // UpdateThreadBody | 
    try {
      Object result = apiInstance.updateInboxThread(threadId, updateThreadBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicInboxApi#updateInboxThread");
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
| **threadId** | **UUID**|  | |
| **updateThreadBody** | [**UpdateThreadBody**](UpdateThreadBody.md)|  | |

### Return type

**Object**

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

