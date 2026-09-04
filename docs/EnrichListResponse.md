

# EnrichListResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**workflowId** | **String** | Handle for the bulk enrichment workflow. Poll it via poll_url. |  |
|**status** | [**StatusEnum**](#StatusEnum) | Always &#39;pending&#39; on dispatch — the bulk workflow runs async. |  |
|**totalLeads** | **Integer** | Number of leads in the list submitted for enrichment. |  |
|**estimatedCost** | **Integer** | Recomputed cost for the run, capped at the quote&#39;s max_credits. |  |
|**creditsReserved** | **Integer** | Upfront reservation cap. Pay-for-results: leads with no email/phone found aren&#39;t charged, so settle refunds the unused portion. Poll status for the final debit. |  |
|**pollUrl** | **String** | Fully-qualified URL to poll for aggregate progress and billing. |  |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |



