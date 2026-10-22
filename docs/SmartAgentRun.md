

# SmartAgentRun


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** | Run id for this smart-agent run — poll it via GET /smart-agents/{id}. |  |
|**listId** | **String** | UUID of the lead list this run targeted. |  |
|**columnName** | **String** | Name of the column the run wrote its output to. |  |
|**agentType** | **String** | The &#x60;agent_type&#x60; the run was started with (e.g. &#x60;custom_ai&#x60;, &#x60;cold_intro_email&#x60;, &#x60;title_normalizer&#x60;), or the smart-column type for runs started outside POST /smart-agents/run. |  |
|**status** | **String** | Lifecycle state: &#x60;pending&#x60;, &#x60;processing&#x60;, &#x60;completed&#x60;, or &#x60;failed&#x60;. |  |
|**total** | **Integer** | Total leads scheduled for this run. |  [optional] |
|**processed** | **Integer** | Leads processed so far (succeeded + failed). |  [optional] |
|**failed** | **Integer** | Leads that errored during processing. |  [optional] |
|**createdAt** | **String** |  |  [optional] |



