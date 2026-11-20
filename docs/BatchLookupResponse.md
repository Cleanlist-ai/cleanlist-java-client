

# BatchLookupResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**totalRows** | **Integer** |  |  |
|**acceptedRows** | **Integer** |  |  |
|**workflowId** | **String** |  |  [optional] |
|**listId** | **String** |  |  [optional] |
|**creditsReserved** | **Integer** |  |  [optional] |
|**creditsCharged** | **Integer** |  |  [optional] |
|**readBackUrl** | **String** |  |  [optional] |
|**pollUrl** | **String** |  |  [optional] |
|**rows** | [**List&lt;BatchRow&gt;**](BatchRow.md) |  |  |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| COMPLETED | &quot;completed&quot; |



