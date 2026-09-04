

# WorkflowStatusResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**workflowId** | **String** | The workflow (or cohort task) handle being polled. |  |
|**status** | **String** | Outer workflow status: e.g. &#39;pending&#39;, &#39;running&#39;, &#39;completed&#39;, &#39;failed&#39;, &#39;cancelled&#39;. |  |
|**progress** | **Integer** |  |  [optional] |
|**total** | **Integer** |  |  [optional] |
|**processed** | **Integer** |  |  [optional] |
|**completed** | **Integer** |  |  [optional] |
|**failed** | **Integer** |  |  [optional] |
|**enrichmentType** | **String** |  |  [optional] |
|**leadListId** | **String** |  |  [optional] |
|**summary** | **Object** |  |  [optional] |
|**refundStatus** | [**RefundStatusEnum**](#RefundStatusEnum) |  |  [optional] |
|**refundMessage** | **String** |  |  [optional] |
|**result** | [**SingleEnrichmentResultRead**](SingleEnrichmentResultRead.md) |  |  [optional] |
|**creditsCharged** | **Integer** |  |  [optional] |
|**creditsRefunded** | **Integer** |  |  [optional] |



## Enum: RefundStatusEnum

| Name | Value |
|---- | -----|
| NOT_APPLICABLE | &quot;not_applicable&quot; |
| PENDING_REVIEW | &quot;pending_review&quot; |



