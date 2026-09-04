

# AddByCohort

Mode B: materialize a prior search cohort into the list.  `search_*` rows carry integer search-DB ids (not lead UUIDs), so Mode A's `UUID(lead_id)` rejects them — Mode B resolves the cohort by `task_id` and creates the lead rows from the task's cached `entity_details`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** | A cohort handle from a prior search_people / list_leads_in_list response. Materializes that cohort&#39;s entities into this list. |  |
|**entityIds** | **List&lt;String&gt;** |  |  [optional] |
|**idempotencyKey** | **String** |  |  [optional] |



