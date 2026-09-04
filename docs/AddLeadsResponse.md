

# AddLeadsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listId** | **String** | Identifier of the list leads were added to. |  |
|**added** | **Integer** | Number of leads newly inserted into the list (billed rows). |  |
|**skippedDuplicates** | **Integer** | Leads already in the list that were skipped (not re-billed). |  |
|**created** | **Integer** |  |  [optional] |
|**creditsCharged** | **BigDecimal** | Import credits charged. Import is free, so this is 0; only enrichment is billed (separately). |  [optional] |



