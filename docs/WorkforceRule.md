

# WorkforceRule

One CompanyDB role distribution or role growth rule.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**role** | **String** | Workforce role, one of WORKFORCE_ROLES. |  |
|**metric** | [**MetricEnum**](#MetricEnum) | Role distribution percent, six-month growth (growth_6m), or year-over-year growth (growth_yoy). |  |
|**op** | [**OpEnum**](#OpEnum) | Comparison direction. |  |
|**threshold** | **BigDecimal** | Finite percentage threshold; growth thresholds may be negative. |  |



## Enum: MetricEnum

| Name | Value |
|---- | -----|
| PERCENT | &quot;percent&quot; |
| GROWTH_6M | &quot;growth_6m&quot; |
| GROWTH_YOY | &quot;growth_yoy&quot; |



## Enum: OpEnum

| Name | Value |
|---- | -----|
| GREATER_THAN_OR_EQUAL_TO | &quot;&gt;&#x3D;&quot; |
| LESS_THAN_OR_EQUAL_TO | &quot;&lt;&#x3D;&quot; |



