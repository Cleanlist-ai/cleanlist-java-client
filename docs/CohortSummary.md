

# CohortSummary


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**identityNamespace** | [**IdentityNamespaceEnum**](#IdentityNamespaceEnum) |  |  [optional] |
|**populationScope** | [**PopulationScopeEnum**](#PopulationScopeEnum) |  |  [optional] |
|**providerTotal** | **Integer** |  |  [optional] |
|**returnedCount** | **Integer** |  |  [optional] |
|**retainedCount** | **Integer** | Unique IDs accessible through this task snapshot. |  |
|**evidenceCheckedCount** | **Integer** |  |  [optional] |
|**providerHasMore** | **Boolean** |  |  [optional] |
|**retentionTruncated** | **Boolean** |  |  [optional] |
|**expiresAt** | **String** |  |  [optional] |



## Enum: IdentityNamespaceEnum

| Name | Value |
|---- | -----|
| PROVIDER_PERSON | &quot;provider_person&quot; |
| PROVIDER_COMPANY | &quot;provider_company&quot; |
| SAVED_LEAD | &quot;saved_lead&quot; |
| SAVED_COMPANY | &quot;saved_company&quot; |
| UNKNOWN | &quot;unknown&quot; |



## Enum: PopulationScopeEnum

| Name | Value |
|---- | -----|
| PROVIDER_PAGE | &quot;provider_page&quot; |
| SAVED_PAGE | &quot;saved_page&quot; |
| UNKNOWN | &quot;unknown&quot; |



