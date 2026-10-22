

# EnrichByTaskResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**crmNote** | **String** |  |  [optional] |
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**entityKind** | [**EntityKindEnum**](#EntityKindEnum) | Resolved entity type of the task. &#39;person&#39; → async workflow; &#39;company&#39; → synchronous inline results. |  |
|**listId** | **String** |  |  [optional] |
|**workflowId** | **String** |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | &#39;pending&#39; for person tasks (workflow running); &#39;completed&#39; for company tasks (results already attached). |  |
|**totalEntities** | **Integer** | Number of cohort entities dispatched for enrichment. |  |
|**creditsReserved** | **Integer** | Person tasks: upfront reservation cap; the workflow settles with actual usage and refunds the delta. Company tasks: the final billed amount (settled inline). |  |
|**results** | [**List&lt;EnrichByTaskEntityResult&gt;**](EnrichByTaskEntityResult.md) | Per-entity outcomes. Person tasks: all &#39;queued&#39;. Company tasks: &#39;enriched&#39;/&#39;skipped&#39;/&#39;failed&#39; with records attached. |  |



## Enum: EntityKindEnum

| Name | Value |
|---- | -----|
| PERSON | &quot;person&quot; |
| COMPANY | &quot;company&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| COMPLETED | &quot;completed&quot; |



