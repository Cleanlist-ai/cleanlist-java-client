

# LeadsPageResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**presentation** | [**SearchPresentation**](SearchPresentation.md) |  |  [optional] |
|**pendingImports** | [**List&lt;PendingImportRow&gt;**](PendingImportRow.md) |  |  [optional] |
|**pendingImportTotal** | **Integer** |  |  [optional] |
|**pendingImportCursor** | **String** |  |  [optional] |
|**listId** | **String** | Identifier of the list these leads belong to. |  |
|**leads** | [**List&lt;LeadRow&gt;**](LeadRow.md) | The page of leads in the list. |  |
|**total** | **Integer** | Total number of leads in the list across all pages. |  |
|**cursor** | **String** |  |  [optional] |



