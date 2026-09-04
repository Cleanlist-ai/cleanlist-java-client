

# UsageReportResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**days** | **Integer** | Length of the reporting window in days (as requested). |  |
|**groupBy** | **String** | Dimension the rows are grouped by: &#x60;tool&#x60;, &#x60;key&#x60;, &#x60;day&#x60;, or &#x60;error&#x60;. |  |
|**totalCalls** | **Integer** | Total API calls across all buckets in the window. |  |
|**totalCreditsSpent** | **BigDecimal** | Total credits spent across all buckets. Currently 0.0 until the request log gains a per-row cost column. |  |
|**totalErrors** | **Integer** | Total error (non-2xx) responses across all buckets. |  |
|**rows** | [**List&lt;UsageGroupRow&gt;**](UsageGroupRow.md) | Per-bucket usage rows for the requested &#x60;group_by&#x60; dimension. |  |



