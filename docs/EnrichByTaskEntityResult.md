

# EnrichByTaskEntityResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**entityId** | **String** | The cohort entity id this result belongs to. |  |
|**status** | [**StatusEnum**](#StatusEnum) | Per-entity outcome. Person tasks return &#39;queued&#39; (results land asynchronously). Company tasks return &#39;enriched&#39; (record attached), &#39;skipped&#39; (no cached identifier), or &#39;failed&#39; (lookup error / not found). |  |
|**error** | **String** |  |  [optional] |
|**company** | [**CompanyRecord**](CompanyRecord.md) |  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| QUEUED | &quot;queued&quot; |
| ENRICHED | &quot;enriched&quot; |
| SKIPPED | &quot;skipped&quot; |
| FAILED | &quot;failed&quot; |



