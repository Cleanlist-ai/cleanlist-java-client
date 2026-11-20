# PublicGtmTasksApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createGtmTask**](PublicGtmTasksApi.md#createGtmTask) | **POST** /api/v2/gtm-tasks | Create Gtm Task |
| [**getGtmTask**](PublicGtmTasksApi.md#getGtmTask) | **GET** /api/v2/gtm-tasks/{task_id} | Get Gtm Task |
| [**listGtmTasks**](PublicGtmTasksApi.md#listGtmTasks) | **GET** /api/v2/gtm-tasks | List Gtm Tasks |
| [**listUpdates**](PublicGtmTasksApi.md#listUpdates) | **GET** /api/v2/updates | List Updates |
| [**updateGtmTask**](PublicGtmTasksApi.md#updateGtmTask) | **PATCH** /api/v2/gtm-tasks/{task_id} | Update Gtm Task |


<a id="createGtmTask"></a>
# **createGtmTask**
> Object createGtmTask(createTaskBody)

Create Gtm Task

A task for the caller on a lead in one of the organization&#39;s sequences.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmTasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmTasksApi apiInstance = new PublicGtmTasksApi(defaultClient);
    CreateTaskBody createTaskBody = new CreateTaskBody(); // CreateTaskBody | 
    try {
      Object result = apiInstance.createGtmTask(createTaskBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmTasksApi#createGtmTask");
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
| **createTaskBody** | [**CreateTaskBody**](CreateTaskBody.md)|  | |

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
| **201** | Successful Response |  -  |
| **422** | Request failed validation. |  -  |
| **400** | Bad request. |  -  |
| **401** | Authentication required or invalid. |  -  |
| **403** | Permission denied or feature not enabled. |  -  |
| **404** | Resource not found. |  -  |
| **409** | Resource conflict. |  -  |
| **429** | Rate limited. |  -  |
| **500** | Internal error. |  -  |
| **502** | Upstream provider error. |  -  |

<a id="getGtmTask"></a>
# **getGtmTask**
> Object getGtmTask(taskId)

Get Gtm Task

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmTasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmTasksApi apiInstance = new PublicGtmTasksApi(defaultClient);
    UUID taskId = UUID.randomUUID(); // UUID | 
    try {
      Object result = apiInstance.getGtmTask(taskId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmTasksApi#getGtmTask");
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
| **taskId** | **UUID**|  | |

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

<a id="listGtmTasks"></a>
# **listGtmTasks**
> Map&lt;String, List&lt;Map&lt;String, Object&gt;&gt;&gt; listGtmTasks(status, taskType, limit)

List Gtm Tasks

The caller&#39;s tasks, as the Tasks page lists them.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmTasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmTasksApi apiInstance = new PublicGtmTasksApi(defaultClient);
    String status = "open"; // String | 
    String taskType = ""; // String | 
    Integer limit = 50; // Integer | 
    try {
      Map<String, List<Map<String, Object>>> result = apiInstance.listGtmTasks(status, taskType, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmTasksApi#listGtmTasks");
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
| **status** | **String**|  | [optional] [default to open] [enum: open, due, overdue, done, all] |
| **taskType** | **String**|  | [optional] [default to ] [enum: , Call, Manual, Reply] |
| **limit** | **Integer**|  | [optional] [default to 50] |

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

<a id="listUpdates"></a>
# **listUpdates**
> Object listUpdates(since, limit)

List Updates

Everything new since &#x60;&#x60;since&#x60;&#x60; (up to 30 days back).

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmTasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmTasksApi apiInstance = new PublicGtmTasksApi(defaultClient);
    String since = "since_example"; // String | An ISO time or a day; default 24 hours ago.
    Integer limit = 10; // Integer | 
    try {
      Object result = apiInstance.listUpdates(since, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmTasksApi#listUpdates");
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
| **since** | **String**| An ISO time or a day; default 24 hours ago. | [optional] |
| **limit** | **Integer**|  | [optional] [default to 10] |

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

<a id="updateGtmTask"></a>
# **updateGtmTask**
> Object updateGtmTask(taskId, updateTaskBody)

Update Gtm Task

&#x60;&#x60;done&#x60;&#x60; completes the task as the Tasks page does (a call task needs &#x60;&#x60;outcome&#x60;&#x60;); &#x60;&#x60;skipped&#x60;&#x60; brings it back on its sequence&#39;s next sending day.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicGtmTasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicGtmTasksApi apiInstance = new PublicGtmTasksApi(defaultClient);
    UUID taskId = UUID.randomUUID(); // UUID | 
    UpdateTaskBody updateTaskBody = new UpdateTaskBody(); // UpdateTaskBody | 
    try {
      Object result = apiInstance.updateGtmTask(taskId, updateTaskBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicGtmTasksApi#updateGtmTask");
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
| **taskId** | **UUID**|  | |
| **updateTaskBody** | [**UpdateTaskBody**](UpdateTaskBody.md)|  | |

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

