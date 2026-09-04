

# EstimateCostRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tool** | **String** | Tool to price. Must be a key in the server&#39;s cost table (e.g. &#x60;enrich_list&#x60;, &#x60;enrich_person&#x60;, &#x60;run_smart_agent&#x60;, &#x60;sync_to_crm&#x60;, &#x60;add_person_enrichments&#x60;). Unknown tools return a 400. |  |
|**listId** | **String** |  |  [optional] |
|**filters** | **Object** |  |  [optional] |
|**rowCount** | **Integer** |  |  [optional] |
|**scope** | **String** |  |  [optional] |
|**agentType** | **String** |  |  [optional] |
|**includePhone** | **Boolean** | Legacy boolean that requests phone enrichment when &#x60;enrichment_type&#x60;/&#x60;scope&#x60; are not set. Kept for back-compat; prefer &#x60;scope&#x60;/&#x60;enrichment_type&#x60;. |  [optional] |
|**provider** | **String** |  |  [optional] |
|**subAction** | **String** |  |  [optional] |
|**enrichmentType** | **String** |  |  [optional] |
|**taskId** | **String** |  |  [optional] |
|**dataPoints** | **List&lt;String&gt;** |  |  [optional] |
|**entityIds** | **List&lt;String&gt;** |  |  [optional] |
|**extra** | **Object** |  |  [optional] |



