# Cleanlist Java SDK (`ai.cleanlist:cleanlist-java`)

Official Java client for the **[Cleanlist](https://cleanlist.ai) API (v2)** — B2B lead
discovery, waterfall enrichment, lead lists, smart agents, and export.

Generated from the public v2 OpenAPI schema (OkHttp + Gson), with a small `Cleanlist`
convenience facade so you can get productive in a few lines.

```java
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.CreateListRequest;

Cleanlist cl = new Cleanlist("clapi_live_...");
System.out.println(cl.workspace.whoami().getOrganizationName());
var list = cl.leadLists.createList(new CreateListRequest().name("Q3 outbound"));
System.out.println("created list: " + list.getListId());
```

- ✅ Fully typed request & response models (fluent builders + getters)
- ✅ OkHttp transport, Gson serialization
- ✅ Bearer-token auth, production defaults
- ✅ Java 8+ · Maven & Gradle
- ✅ Generated from the same schema the API serves, so it never drifts

---

## Table of contents

- [Installation](#installation)
- [Authentication](#authentication)
- [Quickstart](#quickstart)
- [Configuration](#configuration)
- [Core concepts](#core-concepts)
  - [Credits & quotes](#credits--quotes)
  - [Enrichment is asynchronous — poll for results](#enrichment-is-asynchronous--poll-for-results)
- [Endpoint reference](#endpoint-reference)
  - [Workspace](#workspace-clworkspace)
  - [Lead Lists](#lead-lists-clleadlists)
  - [Enrichment](#enrichment-clenrichment)
  - [Smart Agents](#smart-agents-clsmartagents)
  - [Export](#export-clexport)
- [Error handling](#error-handling)
- [Pagination](#pagination)
- [Using the generated API classes directly](#using-the-generated-api-classes-directly)
- [Regenerating from the schema](#regenerating-from-the-schema)
- [Support](#support)

---

## Installation

**Maven**

```xml
<dependency>
  <groupId>ai.cleanlist</groupId>
  <artifactId>cleanlist-java</artifactId>
  <version>2.0.0</version>
</dependency>
```

**Gradle**

```groovy
implementation 'ai.cleanlist:cleanlist-java:2.0.0'
```

Requires Java 8+.

## Authentication

Every request is authenticated with a **Cleanlist API key**, sent as an
`Authorization: Bearer <key>` header. Create one in the portal under
**[Settings → API Keys](https://app.cleanlist.ai/api-keys)** (keys start with
`clapi_`).

```java
// Explicit
Cleanlist cl = new Cleanlist("clapi_live_...");

// Or read the CLEANLIST_API_KEY environment variable
Cleanlist cl2 = Cleanlist.fromEnv();
```

> **Keep keys secret.** Never commit them. Prefer environment variables or a secrets
> manager over hard-coding.

## Quickstart

```java
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.model.*;

public class Quickstart {
    public static void main(String[] args) throws ApiException {
        Cleanlist cl = Cleanlist.fromEnv(); // CLEANLIST_API_KEY

        // 1. Who am I? (identity, tier, scopes)
        WhoamiResponse me = cl.workspace.whoami();
        System.out.printf("Org: %s | tier: %s%n", me.getOrganizationName(), me.getTier());

        // 2. Credit balance
        System.out.println("credits: " + cl.workspace.creditsBalance().getCredits());

        // 3. Create a lead list
        ListDetailResponse list = cl.leadLists.createList(new CreateListRequest().name("Demo — API"));

        // 4. Enrich a person into it (async workflow — returns a handle)
        EnrichPersonResponse job = cl.enrichment.enrichPerson(new EnrichPersonRequest()
                .leadListId(list.getListId())
                .firstName("Ada").lastName("Lovelace").companyName("Analytical Engines"));
        System.out.printf("workflow: %s | reserved: %d%n", job.getWorkflowId(), job.getCreditsReserved());
    }
}
```

> Every API method throws the checked `ai.cleanlist.client.ApiException` on a non-2xx
> response — declare `throws ApiException` or wrap in try/catch.

## Configuration

Pass a base path for local development, and reach the underlying `ApiClient` for
timeouts / interceptors:

```java
import ai.cleanlist.client.Cleanlist;

Cleanlist cl = new Cleanlist("clapi_live_...", "http://localhost:8000");

// Advanced: tweak the underlying OkHttp-backed client
cl.getApiClient().setConnectTimeout(10_000);
cl.getApiClient().setReadTimeout(30_000);
```

## Core concepts

### Credits & quotes

Search and list management are free; **enrichment and smart-agent runs cost credits**.
Bulk/paid operations (`enrichList`, `runSmartAgent`, and CSV import with enrichment)
require a **signed, single-use `quoteId`** that pins the price. The pricing endpoint
(`POST /api/v2/credits/estimate`) is not part of the public API spec, so this SDK has
no method to request a quote; pass one you already have:

```java
EnrichListResponse run = cl.enrichment.enrichList(new EnrichListRequest()
        .listId(list.getListId())
        .scope(EnrichListRequest.ScopeEnum.FULL)
        .quoteId(quoteId));
System.out.println("bulk workflow: " + run.getWorkflowId());
```

Enrichment **scopes**: `PARTIAL` (email + LinkedIn + title + company, 1 credit) ·
`PHONE_ONLY` (10 credits) · `FULL` (email **and** phone, 11 credits). Pricing is
pay-for-results — the reservation is a cap and the unused portion is refunded.

### Enrichment is asynchronous — poll for results

`enrichPerson`, `enrichCompany`, `enrichByTask`, and `enrichList` **dispatch a workflow**
and return a `workflowId`. Poll `enrichmentStatus` until it settles:

```java
import java.util.Set;

Set<String> terminal = Set.of("completed", "failed", "cancelled");
WorkflowStatusResponse status;
do {
    Thread.sleep(3000);
    status = cl.enrichment.enrichmentStatus(job.getWorkflowId());
    System.out.printf("  %s %d/%d%n", status.getStatus(), status.getProcessed(), status.getTotal());
} while (!terminal.contains(status.getStatus()));
System.out.printf("charged=%d refunded=%d%n", status.getCreditsCharged(), status.getCreditsRefunded());
```

---

## Endpoint reference

The v2 surface is 24 operations across five resource groups, exposed on the `Cleanlist`
facade as `cl.workspace`, `cl.leadLists`, `cl.enrichment`, `cl.smartAgents`, and
`cl.export`. Field-by-field model docs live in [`docs/`](docs/).

### Workspace (`cl.workspace`)

| Method | HTTP | Description |
| ------ | ---- | ----------- |
| `whoami()` | `GET /api/v2/whoami` | Identity, org, tier, scopes & features. |
| `creditsBalance()` | `GET /api/v2/credits/balance` | Spendable credit balance. |
| `listApiKeys()` | `GET /api/v2/api-keys` | List the org's API keys. |
| `usageReport(Integer days, String groupBy)` | `GET /api/v2/usage` | Credit-usage report. |

### Lead Lists (`cl.leadLists`)

| Method | HTTP | Description |
| ------ | ---- | ----------- |
| `createList(CreateListRequest)` | `POST /api/v2/lead-lists` | Create a list (idempotent on name). |
| `listLists(String folderId, Integer limit, String cursor)` | `GET /api/v2/lead-lists` | List your lists (paginated). |
| `getList(String listId)` | `GET /api/v2/lead-lists/{list_id}` | Fetch one list. |
| `updateList(String listId, PublicLeadListUpdate)` | `PATCH …/{list_id}` | Rename / move / edit. |
| `deleteList(String listId)` | `DELETE …/{list_id}` | Delete a list. |
| `listLeadsInList(String listId, Integer limit, String cursor)` | `GET …/{list_id}/leads` | Page through leads. |
| `addLeadsToList(String listId, Body)` | `POST …/{list_id}/leads` | Add leads by id or cohort. |
| `removeLeadsFromList(String listId, RemoveLeadsRequest)` | `DELETE …/{list_id}/leads` | Remove up to 100. |
| `csvImport(String listId, CsvImportRequest)` | `POST …/{list_id}/csv-import` | Import from base64 CSV. |

```java
import java.util.Arrays;

ListDetailResponse list = cl.leadLists.createList(new CreateListRequest().name("Prospects — West"));

LeadsPageResponse page = cl.leadLists.listLeadsInList(list.getListId(), 100, null);

// `Body` is a one-of: wrap AddByLeadIds OR AddByCohort (a search task_id)
cl.leadLists.addLeadsToList(list.getListId(),
        new Body(new AddByLeadIds().leadIds(Arrays.asList("lead_a", "lead_b"))));

cl.leadLists.removeLeadsFromList(list.getListId(),
        new RemoveLeadsRequest().leadIds(Arrays.asList("lead_a")));
```

### Enrichment (`cl.enrichment`)

| Method | HTTP | Description |
| ------ | ---- | ----------- |
| `enrichPerson(EnrichPersonRequest)` | `POST /api/v2/enrichment/person` | Enrich one contact into a list. |
| `enrichCompany(EnrichCompanyRequest)` | `POST /api/v2/enrichment/company` | Enrich a company. |
| `enrichByTask(EnrichByTaskRequest)` | `POST /api/v2/enrichment/by-task` | Enrich entities from a prior task. |
| `enrichList(EnrichListRequest)` | `POST /api/v2/enrichment/bulk` | Bulk-enrich a list (needs `quoteId`). |
| `enrichmentStatus(String workflowId)` | `GET /api/v2/enrichment/status/{workflow_id}` | Poll a workflow. |

```java
EnrichPersonResponse job = cl.enrichment.enrichPerson(new EnrichPersonRequest()
        .leadListId(list.getListId()).linkedinUrl("https://linkedin.com/in/ada"));
EnrichCompanyResponse company = cl.enrichment.enrichCompany(new EnrichCompanyRequest().domain("stripe.com"));
```

### Smart Agents (`cl.smartAgents`)

| Method | HTTP | Description |
| ------ | ---- | ----------- |
| `runSmartAgent(RunSmartAgentRequest)` | `POST /api/v2/smart-agents/run` | Run an agent as a new AI column (needs `quoteId`). |
| `listSmartAgents(String listId, Integer limit)` | `GET /api/v2/smart-agents` | Recent agent runs. |
| `getSmartAgentResults(String smartAgentTaskId)` | `GET /api/v2/smart-agents/{smart_agent_task_id}` | Per-lead output. |

```java
RunSmartAgentResponse run = cl.smartAgents.runSmartAgent(new RunSmartAgentRequest()
        .listId(list.getListId())
        .agentType("custom_ai")
        .columnName("Personalized angle")
        .prompt("In one sentence, suggest a cold-outreach angle for this lead.")
        .maxRows(50)
        .quoteId(quoteId)); // signed quote for this exact request shape
SmartAgentResultsResponse results = cl.smartAgents.getSmartAgentResults(run.getSmartAgentTaskId());
```

### Export (`cl.export`)

| Method | HTTP | Description |
| ------ | ---- | ----------- |
| `exportCsv(ExportCsvRequest)` | `POST /api/v2/export/csv/signed-url` | Export to CSV; returns a signed URL. |
| `exportJson(String listId, Integer limit, String cursor, List<String> columns)` | `GET /api/v2/export/json` | Export rows inline as JSON. |

```java
ExportCsvResponse signed = cl.export.exportCsv(new ExportCsvRequest().listId(list.getListId()));
System.out.println("download: " + signed.getDownloadUrl()); // valid until signed.getExpiresAt()

ExportJsonResponse data = cl.export.exportJson(list.getListId(), 500, null, null);
data.getLeads().forEach(System.out::println);
```

## Error handling

Non-2xx responses throw the checked `ApiException`, exposing the status code and body:

```java
import ai.cleanlist.client.ApiException;

try {
    cl.leadLists.getList("does-not-exist");
} catch (ApiException e) {
    switch (e.getCode()) {
        case 404 -> System.out.println("no such list");
        case 401 -> System.out.println("bad or missing API key");
        default  -> System.out.printf("API error %d: %s%n", e.getCode(), e.getResponseBody());
    }
}
```

## Pagination

List endpoints return a page plus an opaque `cursor`. Pass it back for the next page; a
`null` cursor means you've reached the end:

```java
String cursor = null;
do {
    LeadsPageResponse page = cl.leadLists.listLeadsInList(list.getListId(), 500, cursor);
    page.getLeads().forEach(lead -> { /* ... */ });
    cursor = page.getCursor();
} while (cursor != null && !cursor.isEmpty());
```

## Using the generated API classes directly

The `Cleanlist` facade is optional sugar. Wire the generated pieces yourself if you prefer:

```java
import ai.cleanlist.client.ApiClient;
import ai.cleanlist.client.Configuration;
import ai.cleanlist.client.api.PublicWorkspaceApi;

ApiClient client = Configuration.getDefaultApiClient();
client.setBasePath("https://api.cleanlist.ai");
client.setBearerToken("clapi_live_...");

PublicWorkspaceApi workspace = new PublicWorkspaceApi(client);
System.out.println(workspace.whoami());
```

## Regenerating from the schema

This SDK is generated with [`openapi-generator-cli`](https://openapi-generator.tech)
(`java` / okhttp-gson, pinned in `openapitools.json`). To refresh after an API change:

```bash
# 1. Drop the latest openapi/cleanse-api-v2.oas.json in place, then:
bash scripts/generate.sh      # cleans operationIds, regenerates src/, re-applies the facade
mvn -q -DskipTests package     # or ./gradlew build
```

## Support

- Interactive API docs (OpenAPI): <https://api.cleanlist.ai/docs>
- Docs & guides: <https://docs.cleanlist.ai>
- Dashboard: <https://app.cleanlist.ai>
- Email: [sal@cleanlist.ai](mailto:sal@cleanlist.ai)

Licensed under the [MIT License](LICENSE).
