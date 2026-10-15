

# EstimateCostResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**quoteId** | **String** | HMAC-signed quote handle (&#x60;qte_&lt;kid&gt;_&lt;issued_at&gt;_&lt;sig&gt;&#x60;) that the paired paid tool must present at execution time. Single-use and bound to the canonical request (tool, list/filters, scope, row_count, org). |  |
|**expiresAt** | **Integer** | Unix epoch SECONDS at which the quote expires (issue time + &#x60;CLEANLIST_QUOTE_TTL_SECONDS&#x60;, 5 min default). Re-estimate after this to obtain a fresh quote. |  |
|**estimatedCost** | **Integer** | Credits this operation will cost — the authoritative signed spend cap. Execution rejects (&#x60;spend_cap_exceeded&#x60;) if the recomputed cost would exceed it. |  |
|**tool** | **String** | Echo of the priced tool. |  |
|**rowCount** | **Integer** | Number of rows/entities the estimate priced — derived from the list or cohort when applicable, not the caller&#39;s raw input. |  |
|**filterHash** | **String** | Stable digest of the canonical filter/list/cohort shape bound into the quote signature; &#x60;none&#x60; when there is no filter object. |  |
|**availableCredits** | **Integer** | The organization&#39;s current credit balance at estimate time. |  |
|**sufficient** | **Boolean** | True when &#x60;available_credits &gt;&#x3D; estimated_cost&#x60;. False signals the org must top up at billing before the operation can run. |  |



