

# PeopleSearchResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**entityKind** | [**EntityKindEnum**](#EntityKindEnum) |  |  [optional] |
|**searchHandoff** | [**SearchHandoff**](SearchHandoff.md) |  |  [optional] |
|**route** | **Object** |  |  [optional] |
|**warnings** | **List&lt;String&gt;** |  |  [optional] |
|**exclusionsApplied** | **Map&lt;String, Integer&gt;** |  |  [optional] |
|**results** | [**List&lt;PeopleSearchResultRow&gt;**](PeopleSearchResultRow.md) |  |  |
|**total** | **Integer** |  |  |
|**cursor** | **String** |  |  [optional] |
|**creditsCharged** | **Integer** |  |  |
|**truncationWarning** | **String** |  |  [optional] |



## Enum: EntityKindEnum

| Name | Value |
|---- | -----|
| PERSON | &quot;person&quot; |



