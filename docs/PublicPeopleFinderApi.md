# PublicPeopleFinderApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**companiesFindStart**](PublicPeopleFinderApi.md#companiesFindStart) | **POST** /api/v2/people/find-at-companies | Find people at companies by filter (async discovery) |
| [**companiesFindStatus**](PublicPeopleFinderApi.md#companiesFindStatus) | **GET** /api/v2/people/find-at-companies/status/{task_id} | Poll a find-people-at-companies search |
| [**compileSearch**](PublicPeopleFinderApi.md#compileSearch) | **POST** /api/v2/people/find/compile | Compile criteria without running the search |
| [**searchFiltersPeople**](PublicPeopleFinderApi.md#searchFiltersPeople) | **GET** /api/v2/people/find/filters | Search Filters People |
| [**searchPeople**](PublicPeopleFinderApi.md#searchPeople) | **POST** /api/v2/people/find | Search People |


<a id="companiesFindStart"></a>
# **companiesFindStart**
> CompaniesFindStartResponse companiesFindStart(peopleByCompaniesRequest)

Find people at companies by filter (async discovery)

Start an async \&quot;find people at these companies\&quot; search. FREE — credits are spent at enrichment / save time.  Returns a &#x60;&#x60;task_id&#x60;&#x60; immediately; poll &#x60;&#x60;poll_url&#x60;&#x60; (GET /people/find-at-companies/status/{task_id}) until &#x60;&#x60;status&#x60;&#x60; is terminal. One job returns one result block; page by re-calling with the returned &#x60;&#x60;cursor&#x60;&#x60;.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPeopleFinderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPeopleFinderApi apiInstance = new PublicPeopleFinderApi(defaultClient);
    PeopleByCompaniesRequest peopleByCompaniesRequest = new PeopleByCompaniesRequest(); // PeopleByCompaniesRequest | 
    try {
      CompaniesFindStartResponse result = apiInstance.companiesFindStart(peopleByCompaniesRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPeopleFinderApi#companiesFindStart");
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
| **peopleByCompaniesRequest** | [**PeopleByCompaniesRequest**](PeopleByCompaniesRequest.md)|  | |

### Return type

[**CompaniesFindStartResponse**](CompaniesFindStartResponse.md)

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

<a id="companiesFindStatus"></a>
# **companiesFindStatus**
> CompaniesFindStatusResponse companiesFindStatus(taskId)

Poll a find-people-at-companies search

Poll a search started by &#x60;&#x60;POST /people/find-at-companies&#x60;&#x60;. Free and idempotent — call until &#x60;&#x60;status&#x60;&#x60; is terminal (&#x60;&#x60;completed&#x60;&#x60; / &#x60;&#x60;failed&#x60;&#x60;). Cross-tenant task ids fail closed as 404.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPeopleFinderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPeopleFinderApi apiInstance = new PublicPeopleFinderApi(defaultClient);
    String taskId = "taskId_example"; // String | 
    try {
      CompaniesFindStatusResponse result = apiInstance.companiesFindStatus(taskId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPeopleFinderApi#companiesFindStatus");
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
| **taskId** | **String**|  | |

### Return type

[**CompaniesFindStatusResponse**](CompaniesFindStatusResponse.md)

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

<a id="compileSearch"></a>
# **compileSearch**
> CompileResponse compileSearch(compileRequest)

Compile criteria without running the search

Show what a search would do, without doing it. FREE.  Returns the compiled query, the route the search would take, and the exclusions that would apply. Use it to check an unfamiliar combination of criteria before spending a search, and to explain to a user why a result is bounded: a by-companies route resolves a limited company set first, and incomplete CRM exclusions block compilation with an actionable error.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPeopleFinderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPeopleFinderApi apiInstance = new PublicPeopleFinderApi(defaultClient);
    CompileRequest compileRequest = new CompileRequest(); // CompileRequest | 
    try {
      CompileResponse result = apiInstance.compileSearch(compileRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPeopleFinderApi#compileSearch");
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
| **compileRequest** | [**CompileRequest**](CompileRequest.md)|  | |

### Return type

[**CompileResponse**](CompileResponse.md)

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

<a id="searchFiltersPeople"></a>
# **searchFiltersPeople**
> PeopleFiltersResponse searchFiltersPeople(field, query)

Search Filters People

Valid filter values for people search. ZERO CREDITS.  Fixed-enum fields (seniority, management_levels, departments, job_functions, company_headcount) return a canned list — Crustdata accepts these values verbatim, no autocomplete needed.  Autocompletable fields (titles, locations, company_industries) delegate to Crustdata&#39;s autocomplete with the friendly field name translated via &#x60;_PEOPLE_AUTOCOMPLETE_FIELD_MAP&#x60;.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPeopleFinderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPeopleFinderApi apiInstance = new PublicPeopleFinderApi(defaultClient);
    String field = "titles"; // String | 
    String query = "query_example"; // String | 
    try {
      PeopleFiltersResponse result = apiInstance.searchFiltersPeople(field, query);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPeopleFinderApi#searchFiltersPeople");
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
| **field** | **String**|  | [enum: titles, seniority, departments, job_functions, management_levels, locations, company_headcount, company_industries] |
| **query** | **String**|  | [optional] |

### Return type

[**PeopleFiltersResponse**](PeopleFiltersResponse.md)

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

<a id="searchPeople"></a>
# **searchPeople**
> PeopleSearchResponse searchPeople(peopleSearchRequest)

Search People

Search people. FREE — credits are spent at enrichment / save time.  Delegates to the internal staging handler so the 5-step filter pipeline (location component expansion → region contains expansion → column mapping → enum alias expansion → Crustdata format transform) runs unchanged. We pass the caller&#39;s actual tier so FREE-tier callers get the 25-row preview cap.

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicPeopleFinderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicPeopleFinderApi apiInstance = new PublicPeopleFinderApi(defaultClient);
    PeopleSearchRequest peopleSearchRequest = new PeopleSearchRequest(); // PeopleSearchRequest | 
    try {
      PeopleSearchResponse result = apiInstance.searchPeople(peopleSearchRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicPeopleFinderApi#searchPeople");
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
| **peopleSearchRequest** | [**PeopleSearchRequest**](PeopleSearchRequest.md)|  | |

### Return type

[**PeopleSearchResponse**](PeopleSearchResponse.md)

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

