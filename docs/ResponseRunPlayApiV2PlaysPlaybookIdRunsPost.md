

# ResponseRunPlayApiV2PlaysPlaybookIdRunsPost


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**runId** | **String** |  |  [optional] |
|**queued** | **Boolean** |  |  [optional] |
|**reason** | **String** |  |  [optional] |
|**eventId** | **String** | The record&#39;s event. While queued, GET /plays/{playbook_id}/events/{event_id} answers its run_id once a run takes it. |  |
|**committed** | **Boolean** |  |  [optional] |
|**action** | **String** | agent_on, run_gtm_agent or run_play. |  |
|**description** | **String** |  |  |
|**creditsMax** | **BigDecimal** | The most it can spend. |  |
|**recordsMax** | **Integer** |  |  [optional] |
|**effects** | **List&lt;String&gt;** | What its plays can do outside Cleanlist: sends, crm_writes. |  |
|**requiredScopes** | **List&lt;String&gt;** | The opt-in scopes a key needs to commit it. |  |
|**missingScopes** | **List&lt;String&gt;** | Those this credential lacks; empty on the MCP. |  |
|**estimate** | **Object** | The POST /credits/estimate body that quotes it. |  |



