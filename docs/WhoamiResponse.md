

# WhoamiResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**userEmail** | **String** |  |  |
|**userId** | **String** |  |  [optional] |
|**userName** | **String** |  |  [optional] |
|**organizationId** | **String** | Cleanlist organization id that owns this session&#39;s credits and lists. |  |
|**organizationName** | **String** |  |  [optional] |
|**authType** | [**AuthTypeEnum**](#AuthTypeEnum) | How the caller authenticated: &#x60;clerk_jwt&#x60; (portal session token), &#x60;api_key&#x60; (a &#x60;clapi_&#x60; bearer key), or &#x60;oauth&#x60; (third-party grant). |  |
|**scopes** | **List&lt;String&gt;** | Granted permission scopes for this credential (per-user Clerk &#x60;publicMetadata.cleanlist_scopes&#x60;). Endpoints gate on these — e.g. &#x60;credits:read&#x60;, &#x60;search:read&#x60;, &#x60;lists:write&#x60;, &#x60;enrichment:write&#x60;, &#x60;admin:api_keys&#x60;. |  |
|**tier** | [**TierEnum**](#TierEnum) | Resolved plan tier from the org&#39;s Stripe &#x60;credits_product_id&#x60; (V2 &#39;Scale&#39; buyers map to &#x60;enterprise&#x60;). The MCP reads this once per session to tier-filter its advertised tool list. Unknown / unmapped products fall through to &#x60;free&#x60; (the safe default). |  |
|**appsumoTier** | **Integer** |  |  [optional] |
|**features** | **List&lt;String&gt;** | EFFECTIVE feature grants the gates actually enforce: base Stripe tier ∪ AppSumo carve-outs − AppSumo blocks (via &#x60;has_feature_effective&#x60;). Sourced from the same function the server-side gate uses so the advertised list and the gate can&#39;t drift. Sorted alphabetically for stable diffs. |  |



## Enum: AuthTypeEnum

| Name | Value |
|---- | -----|
| CLERK_JWT | &quot;clerk_jwt&quot; |
| API_KEY | &quot;api_key&quot; |
| OAUTH | &quot;oauth&quot; |



## Enum: TierEnum

| Name | Value |
|---- | -----|
| FREE | &quot;free&quot; |
| STARTER | &quot;starter&quot; |
| PRO | &quot;pro&quot; |
| ENTERPRISE | &quot;enterprise&quot; |



