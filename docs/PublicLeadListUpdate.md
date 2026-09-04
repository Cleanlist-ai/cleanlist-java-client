

# PublicLeadListUpdate

PATCH body for renaming / re-describing / re-filing a list.  All fields optional but at least one must be supplied. PATCH semantics: only the fields PRESENT in the request change. A field set to ``null`` clears it (``description``) or unfiles the list (``folder_id``); a field omitted entirely is left untouched. The omitted-vs-explicit-null distinction is read from ``model_fields_set`` in the handler — which is exactly why ``extra=\"forbid\"`` matters here: an unknown key would otherwise land in that set and be mistaken for a real field change.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**folderId** | **String** |  |  [optional] |



