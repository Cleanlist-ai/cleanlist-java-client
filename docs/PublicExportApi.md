# PublicExportApi

All URIs are relative to *https://api.cleanlist.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**exportCsv**](PublicExportApi.md#exportCsv) | **POST** /api/v2/export/csv/signed-url | Export a list to CSV (signed URL) |
| [**exportJson**](PublicExportApi.md#exportJson) | **GET** /api/v2/export/json | Export a list as JSON |


<a id="exportCsv"></a>
# **exportCsv**
> ExportCsvResponse exportCsv(exportCsvRequest)

Export a list to CSV (signed URL)

Export a Lead List to CSV and return a time-limited signed download URL.  Streams the list&#39;s leads through a temporary spooled file, uploads the result to blob storage, and responds with a SAS-signed &#x60;download_url&#x60; that expires 24 hours after generation (see &#x60;expires_at&#x60;). Pass &#x60;columns&#x60; to control which fields — and their order — are written, or omit it to use the default column set; set &#x60;include_smart_agents&#x3D;false&#x60; to skip any configured smart-agent result columns. This export is free and does not consume credits.  **📖 Docs:** https://docs.cleanlist.ai/guides/exporting-data

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicExportApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicExportApi apiInstance = new PublicExportApi(defaultClient);
    ExportCsvRequest exportCsvRequest = new ExportCsvRequest(); // ExportCsvRequest | 
    try {
      ExportCsvResponse result = apiInstance.exportCsv(exportCsvRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicExportApi#exportCsv");
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
| **exportCsvRequest** | [**ExportCsvRequest**](ExportCsvRequest.md)|  | |

### Return type

[**ExportCsvResponse**](ExportCsvResponse.md)

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

<a id="exportJson"></a>
# **exportJson**
> ExportJsonResponse exportJson(listId, limit, cursor, columns)

Export a list as JSON

Export a Lead List as JSON rows returned inline in the response.  Returns a page of leads (default 100, max 500 per call) projected to the same columns as the CSV export and wrapped in the standard response envelope. Use the opaque &#x60;cursor&#x60; from each response to fetch the next page; a malformed cursor returns 400 rather than silently rewinding to page 0. This export is free and does not consume credits.  **📖 Docs:** https://docs.cleanlist.ai/guides/exporting-data

### Example
```java
// Import classes:
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.auth.*;
import ai.cleanlist.client.models.*;
import ai.cleanlist.client.api.PublicExportApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.cleanlist.ai");
    
    // Configure HTTP bearer authorization: HTTPBearer
    HttpBearerAuth HTTPBearer = (HttpBearerAuth) defaultClient.getAuthentication("HTTPBearer");
    HTTPBearer.setBearerToken("BEARER TOKEN");

    PublicExportApi apiInstance = new PublicExportApi(defaultClient);
    String listId = "listId_example"; // String | 
    Integer limit = 100; // Integer | 
    String cursor = "cursor_example"; // String | 
    List<String> columns = Arrays.asList(); // List<String> | 
    try {
      ExportJsonResponse result = apiInstance.exportJson(listId, limit, cursor, columns);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PublicExportApi#exportJson");
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
| **listId** | **String**|  | |
| **limit** | **Integer**|  | [optional] [default to 100] |
| **cursor** | **String**|  | [optional] |
| **columns** | [**List&lt;String&gt;**](String.md)|  | [optional] |

### Return type

[**ExportJsonResponse**](ExportJsonResponse.md)

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

