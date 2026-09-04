

# RunSmartAgentResponse

Three identifiers can live on this response (T1-6 ID-space rename):  - `smart_agent_task_id` — canonical id for polling   `get_smart_agent_results`. - `smart_agent_task_ids` — dict keyed by column type when   `process_smart_columns` returns multiple underlying task ids. - `task_id` (from EnvelopeFields) — kept populated for back-compat   with v1.0 callers that read it from the envelope.  The three are distinct identifiers. A smart-column run's id is NOT an MCP cohort handle, but the envelope still carries `task_id` for transitional compat. New callers should read `smart_agent_task_id`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**smartAgentTaskId** | **String** | Canonical run id. Pass this to GET /smart-agents/{id} to poll progress and per-lead results. |  |
|**smartAgentTaskIds** | **Map&lt;String, String&gt;** | Underlying task ids keyed by column type. Usually a single entry; populated when the run fans out to more than one smart-column task. |  [optional] |
|**status** | **String** | Initial run status; always &#39;pending&#39; at launch. |  |
|**listId** | **String** | UUID of the lead list the run was launched against. |  |
|**columnName** | **String** | Name of the column that will hold each lead&#39;s output. |  |
|**estimatedCost** | **Integer** | Credits expected for this run (per-lead rate × row count). Actual debit happens as rows complete and may be lower if leads fail. |  |



