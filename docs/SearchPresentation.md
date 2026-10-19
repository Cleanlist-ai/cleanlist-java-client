

# SearchPresentation


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**entityKind** | [**EntityKindEnum**](#EntityKindEnum) |  |  [optional] |
|**columns** | **List&lt;String&gt;** | Columns to lay out, in order. Name, Title, Company, Location, Headcount, Industry, Email and Phone read the row&#39;s own cells; any other column reads the row&#39;s extra cells. Renderers show exactly these. |  [optional] |
|**rows** | [**List&lt;PersonPresentationRow&gt;**](PersonPresentationRow.md) |  |  [optional] |
|**shown** | **Integer** | Rows in this block. |  |
|**returned** | **Integer** | Rows in the producing response. |  |
|**providerTotal** | **Integer** |  |  [optional] |
|**evidenceChecked** | **Integer** |  |  [optional] |
|**headcountDiscrepancyRows** | **List&lt;Integer&gt;** |  |  [optional] |
|**industryTruncatedRows** | **List&lt;Integer&gt;** |  |  [optional] |



## Enum: EntityKindEnum

| Name | Value |
|---- | -----|
| PERSON | &quot;person&quot; |



