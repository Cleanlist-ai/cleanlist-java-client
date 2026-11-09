

# ExportCsvResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listId** | **String** | ID of the Lead List that was exported. |  |
|**jobId** | **String** |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | &#x60;completed&#x60; with a &#x60;download_url&#x60;, or &#x60;running&#x60; (HTTP 202): call again with &#x60;job_id&#x60;. |  [optional] |
|**downloadUrl** | **String** |  |  [optional] |
|**expiresAt** | **String** |  |  [optional] |
|**rowCount** | **Integer** | Number of data rows written to the CSV (excludes the header row); while running, the rows being exported. |  |
|**fileSizeBytes** | **Integer** |  |  [optional] |
|**skippedCount** | **Integer** | Rows of the list that changed while it was exporting (deleted, or merged into another row) and are not in the file. &#x60;row_count&#x60; + &#x60;skipped_count&#x60; is the list&#39;s row count when the export started. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| RUNNING | &quot;running&quot; |
| COMPLETED | &quot;completed&quot; |



