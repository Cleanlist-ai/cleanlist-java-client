

# PeopleMatchEvidence


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**scope** | [**ScopeEnum**](#ScopeEnum) |  |  [optional] |
|**titleMatchMode** | [**TitleMatchModeEnum**](#TitleMatchModeEnum) |  |  [optional] |
|**companyScopeMatch** | **Boolean** |  |  [optional] |
|**warnings** | **List&lt;String&gt;** |  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| MATCHED | &quot;matched&quot; |
| UNVERIFIED | &quot;unverified&quot; |



## Enum: ScopeEnum

| Name | Value |
|---- | -----|
| CURRENT_ROLE_AND_COMPANY | &quot;current_role_and_company&quot; |



## Enum: TitleMatchModeEnum

| Name | Value |
|---- | -----|
| CONTAINS | &quot;contains&quot; |
| EXACT | &quot;exact&quot; |
| SIMILAR | &quot;similar&quot; |



