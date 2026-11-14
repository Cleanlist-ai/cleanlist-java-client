

# BatchRow


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**row** | **Integer** | The item&#39;s index in the request. |  |
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**entityId** | **String** |  |  [optional] |
|**resultIndex** | **Integer** |  |  [optional] |
|**error** | **String** |  |  [optional] |
|**company** | [**CompanyRecord**](CompanyRecord.md) |  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| QUEUED | &quot;queued&quot; |
| FOUND | &quot;found&quot; |
| NOT_FOUND | &quot;not_found&quot; |
| FAILED | &quot;failed&quot; |
| INVALID | &quot;invalid&quot; |
| DUPLICATE | &quot;duplicate&quot; |
| OPTED_OUT | &quot;opted_out&quot; |



