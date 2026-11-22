

# UpdateTaskBody


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**outcome** | **String** |  |  [optional] |
|**note** | **String** |  |  [optional] |
|**commit** | **Boolean** | Needed when the change writes to the CRM, or completes a sequence step&#39;s task (its sequence moves on); without it that call answers with a preview. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DONE | &quot;done&quot; |
| SKIPPED | &quot;skipped&quot; |



