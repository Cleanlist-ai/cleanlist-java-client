

# SingleEnrichmentResultRead

Inline enriched-lead payload for single-workflow polls.  Populated by `enrich_status` only when the workflow is a single- lead `enrich_person` run AND has reached a terminal state. Read from the workflow's returned `EnrichmentResult` via Temporal's history — no extra DB round-trip, no race with backend visibility. Bulk-list runs leave `result=None` on the parent response (the aggregate counters carry the cohort's progress instead).  `status` here is the EnrichmentResult-level outcome (\"completed\" / \"failed\"), NOT the outer workflow status. Use it to distinguish a real enrichment (Lead persisted, lead_id set) from a workflow that returned cleanly with no usable Lead (e.g. provider cascade exhausted — `lead_id` will be empty).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**leadId** | **String** | ID of the persisted Lead. Empty when the provider cascade was exhausted with no usable result. |  |
|**status** | **String** | EnrichmentResult-level outcome: &#39;completed&#39; (lead persisted) or &#39;failed&#39;. Distinct from the outer workflow status. |  |
|**fullName** | **String** |  |  [optional] |
|**firstName** | **String** |  |  [optional] |
|**lastName** | **String** |  |  [optional] |
|**email** | **String** |  |  [optional] |
|**emailStatus** | **String** |  |  [optional] |
|**phone** | **String** |  |  [optional] |
|**linkedinUrl** | **String** |  |  [optional] |
|**title** | **String** |  |  [optional] |
|**company** | **String** |  |  [optional] |
|**enrichmentType** | **String** |  |  [optional] |
|**provider** | **String** |  |  [optional] |
|**failureKind** | **String** |  |  [optional] |
|**error** | **String** |  |  [optional] |



