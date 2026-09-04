

# EnrichCompanyResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**company** | [**CompanyRecord**](CompanyRecord.md) | The enriched company record returned synchronously. |  |
|**creditsCharged** | **Integer** | Final credits billed for this lookup (1). Settled inline before the response returns — no reserved-vs-charged ambiguity. |  |



