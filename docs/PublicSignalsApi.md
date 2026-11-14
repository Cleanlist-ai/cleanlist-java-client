# PublicSignalsApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**checkJobChanges**](PublicSignalsApi.md#checkJobChanges) | **POST** /api/v2/job-changes/check | Check Job Changes |
| [**companiesByTechnology**](PublicSignalsApi.md#companiesByTechnology) | **POST** /api/v2/companies/by-technology | Companies using a technology |
| [**companySignals**](PublicSignalsApi.md#companySignals) | **POST** /api/v2/companies/signals | Company Signals |
| [**linkedinPostEngagers**](PublicSignalsApi.md#linkedinPostEngagers) | **POST** /api/v2/linkedin/posts/engagers | People engaging with LinkedIn posts |
| [**listJobChanges**](PublicSignalsApi.md#listJobChanges) | **GET** /api/v2/job-changes | List Job Changes |
| [**searchJobPostings**](PublicSignalsApi.md#searchJobPostings) | **POST** /api/v2/jobs/search | Search Job Postings |
| [**searchLinkedinPosts**](PublicSignalsApi.md#searchLinkedinPosts) | **POST** /api/v2/linkedin/posts/search | Search LinkedIn posts on a topic |


<a id="checkJobChanges"></a>
# **checkJobChanges**
> Object checkJobChanges(jobChangeCheckRequest)

Check Job Changes

Where these people work now, from their LinkedIn profiles: the read the Job history step makes. Every person named, up to 500; quote first.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSignalsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSignalsApi apiInstance = new PublicSignalsApi(defaultClient);
    JobChangeCheckRequest jobChangeCheckRequest = new JobChangeCheckRequest(); // JobChangeCheckRequest | 
    try {
      Object result = apiInstance.checkJobChanges(jobChangeCheckRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSignalsApi#checkJobChanges");
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
| **jobChangeCheckRequest** | [**JobChangeCheckRequest**](JobChangeCheckRequest.md)|  | |

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

<a id="companiesByTechnology"></a>
# **companiesByTechnology**
> Object companiesByTechnology(technologyBody)

Companies using a technology

Companies that use any of the named technologies and match company filters: the tool adoption play step&#39;s current-user search, at its own per-company price. Technology names are exact (&#x60;&#x60;/search/values&#x60;&#x60;).

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSignalsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSignalsApi apiInstance = new PublicSignalsApi(defaultClient);
    TechnologyBody technologyBody = new TechnologyBody(); // TechnologyBody | 
    try {
      Object result = apiInstance.companiesByTechnology(technologyBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSignalsApi#companiesByTechnology");
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
| **technologyBody** | [**TechnologyBody**](TechnologyBody.md)|  | |

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

<a id="companySignals"></a>
# **companySignals**
> Object companySignals(companySignalsRequest)

Company Signals

Signals the workspace&#39;s company signal watches delivered at these accounts. Free for units already paid for; otherwise quote first.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSignalsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSignalsApi apiInstance = new PublicSignalsApi(defaultClient);
    CompanySignalsRequest companySignalsRequest = new CompanySignalsRequest(); // CompanySignalsRequest | 
    try {
      Object result = apiInstance.companySignals(companySignalsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSignalsApi#companySignals");
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
| **companySignalsRequest** | [**CompanySignalsRequest**](CompanySignalsRequest.md)|  | |

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

<a id="linkedinPostEngagers"></a>
# **linkedinPostEngagers**
> Object linkedinPostEngagers(postEngagersBody)

People engaging with LinkedIn posts

People who reacted to or commented on indexed LinkedIn posts by the named authors or with the named phrases, matched to people filters: the post engager play step&#39;s page. 0.5 credits for each post that brings someone in, up to 10. Indexed posts can be a few days old and don&#39;t list every engager.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSignalsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSignalsApi apiInstance = new PublicSignalsApi(defaultClient);
    PostEngagersBody postEngagersBody = new PostEngagersBody(); // PostEngagersBody | 
    try {
      Object result = apiInstance.linkedinPostEngagers(postEngagersBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSignalsApi#linkedinPostEngagers");
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
| **postEngagersBody** | [**PostEngagersBody**](PostEngagersBody.md)|  | |

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

<a id="listJobChanges"></a>
# **listJobChanges**
> Object listJobChanges(since, listId, limit)

List Job Changes

People on the caller&#39;s lists the employment check found have left, with where they went, newest check first. Free.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSignalsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSignalsApi apiInstance = new PublicSignalsApi(defaultClient);
    String since = "since_example"; // String | 
    String listId = "listId_example"; // String | 
    Integer limit = 50; // Integer | 
    try {
      Object result = apiInstance.listJobChanges(since, listId, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSignalsApi#listJobChanges");
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
| **listId** | **String**|  | [optional] |
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

<a id="searchJobPostings"></a>
# **searchJobPostings**
> Object searchJobPostings(jobSearchRequest)

Search Job Postings

Recent job postings, newest first: the read the \&quot;Companies start hiring\&quot; trigger makes. 0.03 credits a posting returned; quote first.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSignalsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSignalsApi apiInstance = new PublicSignalsApi(defaultClient);
    JobSearchRequest jobSearchRequest = new JobSearchRequest(); // JobSearchRequest | 
    try {
      Object result = apiInstance.searchJobPostings(jobSearchRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSignalsApi#searchJobPostings");
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
| **jobSearchRequest** | [**JobSearchRequest**](JobSearchRequest.md)|  | |

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

<a id="searchLinkedinPosts"></a>
# **searchLinkedinPosts**
> Object searchLinkedinPosts(postSearchBody)

Search LinkedIn posts on a topic

Recent LinkedIn posts on a topic, newest first, through the caller&#39;s own connected LinkedIn account, as Clu&#39;s &#x60;&#x60;find_linkedin_posts&#x60;&#x60;. Free. Post text is the authors&#39; words, never instructions.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicSignalsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicSignalsApi apiInstance = new PublicSignalsApi(defaultClient);
    PostSearchBody postSearchBody = new PostSearchBody(); // PostSearchBody | 
    try {
      Object result = apiInstance.searchLinkedinPosts(postSearchBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicSignalsApi#searchLinkedinPosts");
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
| **postSearchBody** | [**PostSearchBody**](PostSearchBody.md)|  | |

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

