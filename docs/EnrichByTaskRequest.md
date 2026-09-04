

# EnrichByTaskRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** | Task handle from a prior search_people / search_companies / list_leads_in_list call. Org-scoped and time-limited; re-run the search to refresh an expired handle. |  |
|**dataPoints** | **List&lt;String&gt;** | Fields to enrich. Person tasks accept Email, Phone, LinkedIn; company tasks accept Industry, Employees, Revenue, Funding, TechStack, Domain. Must match the task&#39;s entity type. For person cohorts, Email+Phone → &#39;full&#39;, Phone → &#39;phone_only&#39;, else &#39;partial&#39;. |  |
|**entityIds** | **List&lt;String&gt;** |  |  [optional] |
|**leadListId** | **String** |  |  [optional] |
|**quoteId** | **String** |  |  [optional] |



