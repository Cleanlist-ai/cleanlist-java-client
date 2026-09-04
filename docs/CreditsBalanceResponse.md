

# CreditsBalanceResponse

Minimal balance shape. The MCP `check_credits` description tells the agent to direct the user to billing for plan/renewal info, so we deliberately don't ship plan_slug / renew_at here even though callers might want them — keep the contract tight.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taskId** | **String** |  |  [optional] |
|**timestampMs** | **Integer** |  |  [optional] |
|**agentInstructions** | **String** |  |  [optional] |
|**usage** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**organizationId** | **String** | Organization whose credit wallet this balance belongs to. |  |
|**credits** | **Integer** | Current spendable credit balance for the organization (&#x60;organizations.credits_count&#x60;). Whole credits; never negative. |  |



