

# LivePreview

What a live call would do, sent back without ``commit``: nothing ran and no quote was used.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**committed** | **Boolean** |  |  [optional] |
|**action** | **String** | agent_on, run_gtm_agent or run_play. |  |
|**description** | **String** |  |  |
|**creditsMax** | **BigDecimal** | The most it can spend. |  |
|**recordsMax** | **Integer** |  |  [optional] |
|**effects** | **List&lt;String&gt;** | What its plays can do outside Cleanlist: sends, crm_writes. |  |
|**requiredScopes** | **List&lt;String&gt;** | The opt-in scopes a key needs to commit it. |  |
|**missingScopes** | **List&lt;String&gt;** | Those this credential lacks; empty on the MCP. |  |
|**estimate** | **Object** | The POST /credits/estimate body that quotes it. |  |



