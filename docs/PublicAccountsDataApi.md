# PublicAccountsDataApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**buyingCommittee**](PublicAccountsDataApi.md#buyingCommittee) | **POST** /api/v2/companies/buying-committee | Buying Committee |
| [**listMeetings**](PublicAccountsDataApi.md#listMeetings) | **GET** /api/v2/meetings | List Meetings |
| [**orgStructure**](PublicAccountsDataApi.md#orgStructure) | **GET** /api/v2/companies/org-structure | Org Structure |
| [**readMeeting**](PublicAccountsDataApi.md#readMeeting) | **GET** /api/v2/meetings/{meeting_id} | Read Meeting |


<a id="buyingCommittee"></a>
# **buyingCommittee**
> Object buyingCommittee(buyingCommitteeBody)

Buying Committee

The people in each role group at one company, marked when the connected CRM has them. Not saved; one search on metered plans.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicAccountsDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicAccountsDataApi apiInstance = new PublicAccountsDataApi(defaultClient);
    BuyingCommitteeBody buyingCommitteeBody = new BuyingCommitteeBody(); // BuyingCommitteeBody | 
    try {
      Object result = apiInstance.buyingCommittee(buyingCommitteeBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicAccountsDataApi#buyingCommittee");
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
| **buyingCommitteeBody** | [**BuyingCommitteeBody**](BuyingCommitteeBody.md)|  | |

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

<a id="listMeetings"></a>
# **listMeetings**
> Object listMeetings(since, accountDomain, personEmail, limit)

List Meetings

Synced calls newest first (default: the last 30 days).

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicAccountsDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicAccountsDataApi apiInstance = new PublicAccountsDataApi(defaultClient);
    String since = "since_example"; // String | 
    String accountDomain = "accountDomain_example"; // String | 
    String personEmail = "personEmail_example"; // String | 
    Integer limit = 25; // Integer | 
    try {
      Object result = apiInstance.listMeetings(since, accountDomain, personEmail, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicAccountsDataApi#listMeetings");
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
| **since** | **String**|  | [optional] |
| **accountDomain** | **String**|  | [optional] |
| **personEmail** | **String**|  | [optional] |
| **limit** | **Integer**|  | [optional] [default to 25] |

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

<a id="orgStructure"></a>
# **orgStructure**
> Object orgStructure(company)

Org Structure

A company&#39;s leaders, Owner / Partner down to Manager, by tier and department (up to 25 people). One search on metered plans.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicAccountsDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicAccountsDataApi apiInstance = new PublicAccountsDataApi(defaultClient);
    String company = "company_example"; // String | 
    try {
      Object result = apiInstance.orgStructure(company);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicAccountsDataApi#orgStructure");
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
| **company** | **String**|  | |

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

<a id="readMeeting"></a>
# **readMeeting**
> Object readMeeting(meetingId, transcript)

Read Meeting

One call&#39;s summary, action items and attendees; the transcript too with &#x60;&#x60;transcript&#x3D;true&#x60;&#x60; (Fireflies and Fathom).

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicAccountsDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicAccountsDataApi apiInstance = new PublicAccountsDataApi(defaultClient);
    String meetingId = "meetingId_example"; // String | 
    Boolean transcript = false; // Boolean | 
    try {
      Object result = apiInstance.readMeeting(meetingId, transcript);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicAccountsDataApi#readMeeting");
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
| **meetingId** | **String**|  | |
| **transcript** | **Boolean**|  | [optional] [default to false] |

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

