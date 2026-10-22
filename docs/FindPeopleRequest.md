

# FindPeopleRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**companyIds** | **List&lt;String&gt;** | Cleanlist company ids to find people at. Must be companies already in the list: read them from the &#x60;company_id&#x60; of the list&#39;s lead rows (GET /lead-lists/{list_id}/leads). Ids outside the list are dropped. |  |
|**jobTitles** | **List&lt;String&gt;** |  |  [optional] |
|**seniorityLevels** | **List&lt;String&gt;** |  |  [optional] |
|**limitPerCompany** | **Integer** |  |  [optional] |
|**locationState** | **String** |  |  [optional] |
|**locationCountry** | **String** |  |  [optional] |



