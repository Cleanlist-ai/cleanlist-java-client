

# ListDetailResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**listId** | **String** | Stable identifier of the list. |  |
|**name** | **String** | Display name of the list. |  |
|**description** | **String** |  |  [optional] |
|**leadCount** | **Integer** | Live count of leads in the list (derived from a fresh COUNT). |  |
|**enrichedCount** | **Integer** | How many of the leads have been enriched (email/phone found). |  |
|**folderId** | **String** |  |  [optional] |
|**createdAt** | **String** |  |  [optional] |
|**reused** | **Boolean** | True only when POST /lead-lists returned a pre-existing same-name list (idempotent reuse). Always false on reads and genuine creates. |  [optional] |



