

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
|**total** | **Integer** | Total number of leads in the list (across all pages). |  |
|**cursor** | **String** |  |  [optional] |



