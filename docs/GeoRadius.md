

# GeoRadius

``SearchFilters.geoRadius``: a free-text center plus a distance.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**center** | **String** | Free-text location the radius is measured from. |  [optional] |
|**radius** | **BigDecimal** | Distance from the center; must be greater than 0 to apply. |  [optional] |
|**unit** | [**UnitEnum**](#UnitEnum) | Distance unit: km or mi. |  [optional] |



## Enum: UnitEnum

| Name | Value |
|---- | -----|
| KM | &quot;km&quot; |
| MI | &quot;mi&quot; |



