

# ListSmartAgentsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**runs** | [**List&lt;SmartAgentRun&gt;**](SmartAgentRun.md) | Smart-agent runs, most recent first, scoped to what the caller can see (a single list when &#x60;list_id&#x60; is passed, else a rollup across accessible lists). |  |
|**total** | **Integer** | Number of runs returned in &#x60;runs&#x60; (bounded by &#x60;limit&#x60;). |  |



