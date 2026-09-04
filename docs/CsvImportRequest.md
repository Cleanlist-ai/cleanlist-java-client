

# CsvImportRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**csvContentBase64** | **String** | Full CSV file body, base64-encoded. UTF-8 (with or without BOM). v1 hard-caps the raw body at 150 KB / ~600 rows — past that the base64 payload starts hitting tool-call output limits in the agent before any server cap fires. Above the cap the endpoint returns 413; chunk the file upstream. |  |
|**columnMapping** | **Map&lt;String, String&gt;** | { canonical_field: csv_header_name }. The MCP agent reads the CSV header line and supplies the mapping; the server never guesses. CSV columns not mapped are dropped. Mapping a field that isn&#39;t in the CSV header returns 400 missing_column with the bad header name in &#x60;details&#x60;. |  |
|**dispatchEnrichment** | **Boolean** | When True (default), the import dispatches a BulkEnrichmentWorkflow immediately after the RawPeople rows land. When False, rows land as RawPerson(status&#x3D;pending) and the caller dispatches enrichment separately via enrich_list. |  [optional] |
|**enrichmentType** | [**EnrichmentTypeEnum**](#EnrichmentTypeEnum) |  |  [optional] |
|**quoteId** | **String** |  |  [optional] |
|**idempotencyKey** | **String** |  |  [optional] |



## Enum: EnrichmentTypeEnum

| Name | Value |
|---- | -----|
| PARTIAL | &quot;partial&quot; |
| PHONE_ONLY | &quot;phone_only&quot; |
| FULL | &quot;full&quot; |



