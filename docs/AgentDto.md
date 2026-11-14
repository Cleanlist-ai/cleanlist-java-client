

# AgentDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**organizationId** | **String** |  |  |
|**ownerUserId** | **String** |  |  |
|**name** | **String** |  |  |
|**markColor** | **String** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**goal** | **String** |  |  [optional] |
|**instructions** | **String** |  |  [optional] |
|**selfEditInstructions** | **Boolean** |  |  |
|**skillRefs** | [**List&lt;SkillRefDto&gt;**](SkillRefDto.md) |  |  |
|**knowledge** | [**KnowledgeDto**](KnowledgeDto.md) |  |  |
|**connections** | [**List&lt;ConnectionDto&gt;**](ConnectionDto.md) |  |  |
|**tools** | **Map&lt;String, Boolean&gt;** |  |  |
|**triggers** | [**List&lt;TriggerDto&gt;**](TriggerDto.md) |  |  |
|**playIds** | **List&lt;String&gt;** |  |  |
|**limits** | [**LimitsDto**](LimitsDto.md) |  |  |
|**capWindow** | **String** |  |  [optional] |
|**delivery** | [**DeliveryDto**](DeliveryDto.md) |  |  |
|**status** | **String** |  |  |
|**aiManagedTriggers** | **Boolean** |  |  |
|**isFavorite** | **Boolean** |  |  |
|**archivedAt** | **String** |  |  [optional] |
|**version** | **Integer** |  |  |
|**createdAt** | **String** |  |  [optional] |
|**modifiedAt** | **String** |  |  [optional] |
|**nextRunAt** | **String** |  |  [optional] |
|**lastRunAt** | **String** |  |  [optional] |
|**pendingProposalId** | **String** |  |  [optional] |
|**greetedAt** | **String** |  |  [optional] |
|**setupCompletedAt** | **String** |  |  [optional] |
|**reopenedMerges** | **Integer** |  |  [optional] |
|**blocked** | [**List&lt;SettingsIssueDto&gt;**](SettingsIssueDto.md) |  |  [optional] |
|**asksFirst** | [**List&lt;SettingsIssueDto&gt;**](SettingsIssueDto.md) |  |  [optional] |
|**abilitiesInUse** | **List&lt;String&gt;** |  |  [optional] |
|**playConnectionTypes** | **List&lt;String&gt;** |  |  [optional] |
|**appBlocks** | **Map&lt;String, Map&lt;String, String&gt;&gt;** |  |  [optional] |
|**gaps** | [**List&lt;PlayGapDto&gt;**](PlayGapDto.md) |  |  [optional] |
|**quickReplies** | **List&lt;String&gt;** |  |  [optional] |
|**builtFrom** | [**BuiltFromDto**](BuiltFromDto.md) |  |  [optional] |



