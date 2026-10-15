

# CrmFilterClause

``CrmFilterClause``: one include/exclude condition against a CRM.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Required, nonblank stable client id for the clause. |  |
|**polarity** | [**PolarityEnum**](#PolarityEnum) | Whether the clause narrows (exclude) or requires (include). |  [optional] |
|**condition** | **String** | The /crm/exclusion-set token, e.g. current_customers, owner:&lt;id&gt;, account_status:&lt;value&gt;. |  |



## Enum: PolarityEnum

| Name | Value |
|---- | -----|
| INCLUDE | &quot;include&quot; |
| EXCLUDE | &quot;exclude&quot; |



