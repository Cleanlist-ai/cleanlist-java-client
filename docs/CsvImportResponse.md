

# CsvImportResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**listId** | **String** | Identifier of the list the CSV was imported into. |  |
|**rowsParsed** | **Integer** | Total data rows read from the CSV (excludes the header). |  |
|**rowsImported** | **Integer** | Rows that landed as importable contacts. |  |
|**rowsSkipped** | **Integer** | Rows dropped during parsing (see skip_reasons). |  |
|**skipReasons** | **Map&lt;String, Integer&gt;** | Skip counts by stable reason key (missing_required, duplicate_email, duplicate_linkedin, row_cap_exceeded). |  [optional] |
|**sampleSkipRows** | **List&lt;Integer&gt;** | Up to 10 1-indexed row numbers (header is row 1) that were skipped, for spot-checking the file. |  [optional] |
|**workflowId** | **String** |  |  [optional] |
|**enrichmentStatusUrl** | **String** |  |  [optional] |
|**idempotencyReplayed** | **Boolean** | True when served from the idempotency cache — the CSV was NOT re-imported and NO credits were re-charged. |  [optional] |



