

# PublicApiErrorPayload

The `error` field of every public-API error response.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** |  |  |
|**problem** | **String** |  |  |
|**cause** | **String** |  |  [optional] |
|**fix** | **String** |  |  [optional] |
|**retryable** | **Boolean** |  |  [optional] |
|**retryAfterMs** | **Integer** |  |  [optional] |
|**docsUrl** | **String** |  |  |
|**requestId** | **String** |  |  |
|**estimatedCostCredits** | **Integer** |  |  [optional] |
|**availableCredits** | **Integer** |  |  [optional] |
|**shortfallCredits** | **Integer** |  |  [optional] |
|**suggestedActions** | [**List&lt;SuggestedAction&gt;**](SuggestedAction.md) |  |  [optional] |
|**details** | **Object** |  |  [optional] |



