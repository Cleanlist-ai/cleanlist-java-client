

# ApiKeyInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**keyId** | **String** | Opaque id of the API key row (safe to display and reference). |  |
|**keyPrefix** | **String** | Non-secret leading segment of the key, used for at-a-glance identification. Cleanlist keys are &#x60;clapi_&#x60;. |  |
|**keyLast4** | **String** | Last 4 characters of the key for disambiguation. The full secret is never returned by this endpoint. |  |
|**name** | **String** |  |  [optional] |
|**scopes** | **List&lt;String&gt;** | Permission scopes carried by this key. Scopes are granted per-USER today, so every key the caller owns shares the caller&#39;s scopes. |  |
|**createdAt** | **String** |  |  [optional] |
|**lastUsedAt** | **String** |  |  [optional] |
|**expiresAt** | **String** |  |  [optional] |
|**isActive** | **Boolean** | Whether the key is currently active. Revoked keys report false. |  |



