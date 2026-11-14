# PublicWebhooksApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createWebhook**](PublicWebhooksApi.md#createWebhook) | **POST** /api/v2/webhooks | Subscribe a URL to events |
| [**deleteWebhook**](PublicWebhooksApi.md#deleteWebhook) | **DELETE** /api/v2/webhooks/{webhook_id} | Remove a webhook |
| [**listWebhookDeliveries**](PublicWebhooksApi.md#listWebhookDeliveries) | **GET** /api/v2/webhooks/deliveries | List webhook deliveries |
| [**listWebhooks**](PublicWebhooksApi.md#listWebhooks) | **GET** /api/v2/webhooks | List webhooks |


<a id="createWebhook"></a>
# **createWebhook**
> CreatedWebhook createWebhook(createWebhookRequest)

Subscribe a URL to events

Subscribe a public HTTPS URL to event types. Returns the signing secret once: verify each delivery&#39;s &#x60;Cleanlist-Signature&#x60; header (&#x60;t&#x3D;&lt;unix&gt;,v1&#x3D;&lt;hex HMAC-SHA256 of \&quot;&lt;t&gt;.&lt;raw body&gt;\&quot;&gt;&#x60;) with it.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWebhooksApi apiInstance = new PublicWebhooksApi(defaultClient);
    CreateWebhookRequest createWebhookRequest = new CreateWebhookRequest(); // CreateWebhookRequest | 
    try {
      CreatedWebhook result = apiInstance.createWebhook(createWebhookRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWebhooksApi#createWebhook");
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
| **createWebhookRequest** | [**CreateWebhookRequest**](CreateWebhookRequest.md)|  | |

### Return type

[**CreatedWebhook**](CreatedWebhook.md)

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

<a id="deleteWebhook"></a>
# **deleteWebhook**
> DeletedWebhook deleteWebhook(webhookId)

Remove a webhook

Stop sending events to a subscription. Its delivery log stays.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWebhooksApi apiInstance = new PublicWebhooksApi(defaultClient);
    UUID webhookId = UUID.randomUUID(); // UUID | 
    try {
      DeletedWebhook result = apiInstance.deleteWebhook(webhookId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWebhooksApi#deleteWebhook");
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
| **webhookId** | **UUID**|  | |

### Return type

[**DeletedWebhook**](DeletedWebhook.md)

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

<a id="listWebhookDeliveries"></a>
# **listWebhookDeliveries**
> Object listWebhookDeliveries(workflowId, limit)

List webhook deliveries

Delivery attempts for a &#x60;workflow_id&#x60;, newest first: the v1 route. For a subscription&#39;s event, pass the event id (&#x60;evt_...&#x60;); the log&#39;s &#x60;webhook_id&#x60; is the subscription&#39;s id.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWebhooksApi apiInstance = new PublicWebhooksApi(defaultClient);
    String workflowId = "workflowId_example"; // String | 
    Integer limit = 50; // Integer | 
    try {
      Object result = apiInstance.listWebhookDeliveries(workflowId, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWebhooksApi#listWebhookDeliveries");
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
| **workflowId** | **String**|  | |
| **limit** | **Integer**|  | [optional] [default to 50] |

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

<a id="listWebhooks"></a>
# **listWebhooks**
> WebhooksResponse listWebhooks()

List webhooks

List this organization&#39;s active webhook subscriptions. Secrets are never returned after creation.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicWebhooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicWebhooksApi apiInstance = new PublicWebhooksApi(defaultClient);
    try {
      WebhooksResponse result = apiInstance.listWebhooks();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicWebhooksApi#listWebhooks");
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

[**WebhooksResponse**](WebhooksResponse.md)

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

