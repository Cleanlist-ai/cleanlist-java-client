

# ExportCsvResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listId** | **String** | ID of the Lead List that was exported. |  |
|**downloadUrl** | **String** | Time-limited, SAS-signed URL to download the generated CSV file. The signature (&#x60;sig&#x60;) and expiry (&#x60;exp&#x60;) query params gate access; the link stops working after &#x60;expires_at&#x60;. |  |
|**expiresAt** | **String** | ISO-8601 UTC timestamp at which &#x60;download_url&#x60; expires. Generated URLs are valid for 24 hours. |  |
|**rowCount** | **Integer** | Number of data rows written to the CSV (excludes the header row). |  |
|**fileSizeBytes** | **Integer** | Size of the generated CSV file in bytes. |  |



