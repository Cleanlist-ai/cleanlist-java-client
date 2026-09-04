

# UsageGroupRow


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**group** | **String** | Bucket label for this row, per the requested &#x60;group_by&#x60;: the tool/path, key id, day, or error class. |  |
|**calls** | **Integer** | Number of API calls counted in this bucket over the window. |  |
|**creditsSpent** | **BigDecimal** | Credits spent in this bucket. Float because per-lead agents can cost fractional credits (e.g. 0.5). Currently 0.0 until the request log gains a per-row cost column. |  |
|**errors** | **Integer** | Number of error (non-2xx) responses counted in this bucket. |  |



