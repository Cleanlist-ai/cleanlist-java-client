

# BulkContactResult

One contact of a bulk run, returned when polling with `include_results=true`. `lead` is the same row `GET /lead-lists/{id}/leads` returns, so contact fields follow the same reveal rules.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**index** | **Integer** | Position of this contact in the run. |  |
|**status** | **String** | pending / processing / completed / failed while known; &#39;unavailable&#39; once the per-contact record has expired (24h). |  |
|**failureClass** | **String** |  |  [optional] |
|**lead** | [**LeadRow**](LeadRow.md) |  |  [optional] |



