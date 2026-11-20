

# CreateTaskBody


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**leadId** | **String** |  |  |
|**taskType** | [**TaskTypeEnum**](#TaskTypeEnum) |  |  [optional] |
|**dueAt** | **String** | YYYY-MM-DD |  |
|**note** | **String** |  |  [optional] |
|**commit** | **Boolean** | Needed when the new task is also created in the CRM; without it that call answers with a preview. |  [optional] |



## Enum: TaskTypeEnum

| Name | Value |
|---- | -----|
| CALL | &quot;Call&quot; |
| MANUAL | &quot;Manual&quot; |



