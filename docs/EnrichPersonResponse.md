

# EnrichPersonResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**workflowId** | **String** | Handle for the async enrichment workflow. Poll it via poll_url. |  |
|**status** | [**StatusEnum**](#StatusEnum) | Always &#39;pending&#39; on dispatch — the workflow runs asynchronously. |  |
|**creditsReserved** | **Integer** | Upfront credit reservation cap (1/10/11 for partial/phone_only/full). Pay-for-results: the workflow refunds the unused portion at settle, so the final debit may be lower. Poll status for the actual charge. |  |
|**leadListId** | **String** | List the enriched contact will be written to on completion. |  |
|**pollUrl** | **String** | Fully-qualified URL to poll for workflow status and results. |  |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |



