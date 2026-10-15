

# EnrichListRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listId** | **String** | The lead list to enrich in bulk. Every lead in the list runs through the provider waterfall. Must be non-empty and accessible to your API key. |  |
|**scope** | [**ScopeEnum**](#ScopeEnum) | Enrichment scope per lead. &#39;partial&#39; &#x3D; email + LinkedIn + title + company (1 credit); &#39;phone-only&#39; &#x3D; phone only (10 credits); &#39;full&#39; &#x3D; email AND phone (11 credits). |  [optional] |
|**quoteId** | **String** | Required. Obtain via POST /credits/estimate first (bound to this list_id + scope + lead count). Bulk spend must be pre-approved; cost is capped at the quote&#39;s max_credits. |  |
|**leadIds** | **List&lt;String&gt;** |  |  [optional] |



## Enum: ScopeEnum

| Name | Value |
|---- | -----|
| PARTIAL | &quot;partial&quot; |
| FULL | &quot;full&quot; |
| PHONE_ONLY | &quot;phone-only&quot; |



