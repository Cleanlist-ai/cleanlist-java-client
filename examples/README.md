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

Or compile and run them straight from this repo against the built jar:

```bash
mvn -q -DskipTests -Dgpg.skip package dependency:build-classpath -Dmdep.outputFile=target/cp.txt
javac -d target/examples -cp "target/cleanlist-java-4.0.1.jar:$(cat target/cp.txt)" examples/*.java
java -cp "target/examples:target/cleanlist-java-4.0.1.jar:$(cat target/cp.txt)" examples.Quickstart
```

## Examples

| File | What it shows |
| ---- | ------------- |
| [`Quickstart.java`](Quickstart.java) | whoami, credit balance, create a list. Free. |
| [`LeadLists.java`](LeadLists.java) | List CRUD + paginate all leads. Free. |
| [`FindPeople.java`](FindPeople.java) | People Finder: filter values, compile preview, search + next page. Free. |
| [`EnrichPerson.java`](EnrichPerson.java) | Enrich one contact and poll to completion. Spends credits. |
| [`BulkEnrichWithQuote.java`](BulkEnrichWithQuote.java) | The estimate → quote → bulk-enrich flow. Spends credits. |
| [`SmartAgent.java`](SmartAgent.java) | Run a custom AI smart-agent column and read the results. Spends credits. |
| [`Export.java`](Export.java) | CSV (signed URL) + JSON export. Free. |
| [`ErrorHandling.java`](ErrorHandling.java) | Catching `ApiException`. Free. |

> ⚠️ Examples that enrich or run smart agents **spend credits** (they estimate first and
> print the cost). Read each file's header before running.
