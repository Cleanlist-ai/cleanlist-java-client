

# PersonPresentationRow


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**position** | **Integer** | 1-based position in the returned rows. |  |
|**entityId** | **String** |  |  [optional] |
|**name** | [**PresentationLink**](PresentationLink.md) |  |  |
|**title** | **String** |  |  |
|**company** | [**PresentationLink**](PresentationLink.md) |  |  |
|**location** | **String** |  |  |
|**headcount** | **String** |  |  |
|**headcountDiscrepancy** | **Boolean** | The latest count falls outside the returned size band; both are observations. |  [optional] |
|**industry** | **String** |  |  |
|**industryTruncated** | **Boolean** | Provider industry labels were shortened or omitted upstream. |  [optional] |
|**evidenceStatus** | [**EvidenceStatusEnum**](#EvidenceStatusEnum) |  |  [optional] |
|**email** | **String** |  |  [optional] |
|**phone** | **String** |  |  [optional] |
|**extra** | **Map&lt;String, String&gt;** | Cells for the requested extra columns, keyed by column name. |  [optional] |



## Enum: EvidenceStatusEnum

| Name | Value |
|---- | -----|
| MATCHED | &quot;matched&quot; |
| UNVERIFIED | &quot;unverified&quot; |



