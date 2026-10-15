

# RunSmartAgentRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listId** | **String** | UUID of the lead list the agent runs against. Must be a list this API key can access (owned, org-visible, or shared) — a known id for a private list in the same org is rejected with 404. |  |
|**agentType** | [**AgentTypeEnum**](#AgentTypeEnum) | Which agent to run. &#x60;custom_ai&#x60; runs your own &#x60;prompt&#x60;; &#x60;cold_intro_email&#x60; drafts a personalized opener from an email template. The preset research agents (&#x60;title_normalizer&#x60;, &#x60;company_intel&#x60;, &#x60;pain_point_hypothesis&#x60;) run a baked-in instruction and ignore &#x60;prompt&#x60;. All types execute asynchronously as an AI smart column. |  [optional] |
|**prompt** | **String** |  |  [optional] |
|**columnName** | **String** | Display name for the new column that stores each lead&#39;s agent output for custom/preset agents. Existing completed outputs are preserved unless &#x60;overwrite&#x3D;true&#x60; is quoted. Cold intro email uses the platform&#39;s built-in email column. |  |
|**templateId** | **String** |  |  [optional] |
|**leadScope** | [**LeadScopeEnum**](#LeadScopeEnum) | &#x60;subset&#x60; runs on up to &#x60;max_rows&#x60; leads (the fast, cheap path). &#x60;all&#x60; selects the entire list. Any selection above the configured threshold (default 500 leads) is blocked with a 400 &#x60;approval_required&#x60; until you narrow scope or route a human approval. |  [optional] |
|**maxRows** | **Integer** | Upper bound on how many leads to process when &#x60;lead_scope&#x3D;&#39;subset&#39;&#x60;. Clamped to the list size. Ignored when &#x60;lead_scope&#x3D;&#39;all&#39;&#x60;. |  [optional] |
|**quoteId** | **String** | Single-use spend quote from POST /credits/estimate, signed for this exact request shape (list_id + agent_type + column_name + row count). It is verified and atomically redeemed before the run starts; a stale, mismatched, or already-used quote returns a 400 or 409. Re-quote if you change any field. |  |
|**overwrite** | **Boolean** | When true, existing values in a column of the same name are overwritten instead of preserved. Included in the signed quote and applied while resolving the exact eligible lead IDs. |  [optional] |



## Enum: AgentTypeEnum

| Name | Value |
|---- | -----|
| CUSTOM_AI | &quot;custom_ai&quot; |
| COLD_INTRO_EMAIL | &quot;cold_intro_email&quot; |
| TITLE_NORMALIZER | &quot;title_normalizer&quot; |
| COMPANY_INTEL | &quot;company_intel&quot; |
| PAIN_POINT_HYPOTHESIS | &quot;pain_point_hypothesis&quot; |



## Enum: LeadScopeEnum

| Name | Value |
|---- | -----|
| SUBSET | &quot;subset&quot; |
| ALL | &quot;all&quot; |



