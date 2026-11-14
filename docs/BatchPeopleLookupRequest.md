

# BatchPeopleLookupRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**items** | **List&lt;Object&gt;** | Up to 1,000 people, each &#x60;{email}&#x60;, &#x60;{linkedin_url}&#x60; or &#x60;{first_name, last_name, domain}&#x60; (extra known keys help the match). |  |
|**fields** | [**List&lt;FieldsEnum&gt;**](#List&lt;FieldsEnum&gt;) | What to look up for each row. Every email or phone lookup also resolves the profile; &#x60;profile&#x60; alone looks up the profile only. |  |
|**quoteId** | **String** |  |  [optional] |
|**leadListId** | **String** |  |  [optional] |



## Enum: List&lt;FieldsEnum&gt;

| Name | Value |
|---- | -----|
| EMAIL | &quot;email&quot; |
| PHONE | &quot;phone&quot; |
| PROFILE | &quot;profile&quot; |



