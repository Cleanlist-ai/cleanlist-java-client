

# CreateWebhookRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**url** | **String** | Public https:// URL on port 443 that receives the events. |  |
|**events** | [**List&lt;EventsEnum&gt;**](#List&lt;EventsEnum&gt;) | Event types to send to this URL. |  |



## Enum: List&lt;EventsEnum&gt;

| Name | Value |
|---- | -----|
| PLAY_RUN_COMPLETED | &quot;play_run.completed&quot; |
| PLAY_RUN_FAILED | &quot;play_run.failed&quot; |
| APPROVAL_NEEDED | &quot;approval.needed&quot; |
| REPLY_RECEIVED | &quot;reply.received&quot; |
| ENRICHMENT_COMPLETED | &quot;enrichment.completed&quot; |
| JOB_CHANGE_DETECTED | &quot;job_change.detected&quot; |
| WEBSITE_VISIT_DETECTED | &quot;website_visit.detected&quot; |
| CRM_RECORD_CHANGED | &quot;crm.record_changed&quot; |
| CRM_DEAL_STAGE_CHANGED | &quot;crm.deal_stage_changed&quot; |



