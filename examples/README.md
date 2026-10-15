# Cleanlist Java SDK — examples

Reference programs using `ai.cleanlist:cleanlist-java`.

## Setup

Add the dependency (see the [root README](../README.md)) and set your key:

```bash
export CLEANLIST_API_KEY="clapi_live_..."   # app.cleanlist.ai → Settings → API Keys
# optional: export CLEANLIST_HOST="http://localhost:8000"
```

Each file is a standalone class with a `main` method. Drop one into a project that has
the SDK on its classpath and run it, e.g. with Maven:

```bash
mvn -q exec:java -Dexec.mainClass="examples.Quickstart"
```

## Examples

| File | What it shows |
| ---- | ------------- |
| [`Quickstart.java`](Quickstart.java) | whoami, credit balance, create a list. Free. |
| [`EnrichPerson.java`](EnrichPerson.java) | Enrich one contact and poll to completion. Spends credits. |
| [`BulkEnrichWithQuote.java`](BulkEnrichWithQuote.java) | Redeem an existing `quoteId` to bulk-enrich a list. Spends credits. |
| [`Export.java`](Export.java) | CSV (signed URL) + JSON export. Free. |
| [`ErrorHandling.java`](ErrorHandling.java) | Catching `ApiException`. Free. |

> ⚠️ Examples that enrich or run smart agents **spend credits**. Bulk enrich needs a
> quote id you already have: the pricing endpoint is not in the public spec, so the
> SDK cannot request one. Read each file's header before running.
