

# SmartAgentResultsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**smartAgentTaskId** | **String** | The run id being polled (echoes the path parameter). |  |
|**status** | **String** | Run lifecycle state: &#x60;pending&#x60;, &#x60;processing&#x60;, &#x60;completed&#x60;, or &#x60;failed&#x60;. |  |
|**progress** | **Integer** | Percent complete (0–100), derived from processed / total. |  |
|**total** | **Integer** | Total leads scheduled for this run. |  |
|**succeeded** | **Integer** | Leads that produced a value without error. |  |
|**failed** | **Integer** | Leads that errored during processing. |  |
|**results** | [**List&lt;SmartAgentResultRow&gt;**](SmartAgentResultRow.md) | Per-lead output rows attributed to this run. May be empty while the run is still starting up. |  |



