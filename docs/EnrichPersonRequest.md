

# EnrichPersonRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**leadListId** | **String** | ID of the lead list the enriched contact is written to when the workflow completes. Must be a list your API key can access. |  |
|**email** | **String** |  |  [optional] |
|**linkedinUrl** | **String** |  |  [optional] |
|**phone** | **String** |  |  [optional] |
|**firstName** | **String** |  |  [optional] |
|**lastName** | **String** |  |  [optional] |
|**companyName** | **String** |  |  [optional] |
|**domain** | **String** |  |  [optional] |
|**personId** | **String** |  |  [optional] |
|**enrichmentType** | [**EnrichmentTypeEnum**](#EnrichmentTypeEnum) |  |  [optional] |
|**includePhone** | **Boolean** | Legacy scope toggle, kept for back-compat. false → &#39;partial&#39;, true → &#39;phone_only&#39;. Ignored when enrichment_type is set. |  [optional] |
|**quoteId** | **String** |  |  [optional] |



## Enum: EnrichmentTypeEnum

| Name | Value |
|---- | -----|
| PARTIAL | &quot;partial&quot; |
| PHONE_ONLY | &quot;phone_only&quot; |
| FULL | &quot;full&quot; |



