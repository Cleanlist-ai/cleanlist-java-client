

# ExportJsonResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**listId** | **String** | ID of the Lead List whose leads were returned. |  |
|**leads** | **List&lt;Object&gt;** | Page of lead rows returned inline, each projected to the selected (or default) columns. At most &#x60;limit&#x60; rows are returned per call. |  |
|**total** | **Integer** | Total number of rows in the list (across all pages), import rows not yet enriched included. |  |
|**cursor** | **String** |  |  [optional] |
|**skipped** | **Integer** | Rows of this page&#39;s place in the ordering that left the list (deleted or moved) after the cursor&#39;s ordering was taken, so the page holds fewer rows than it covers. &#x60;total&#x60; minus the sum of &#x60;skipped&#x60; over every page is the number of rows returned. |  [optional] |



