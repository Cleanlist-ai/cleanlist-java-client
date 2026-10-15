/*
 * The quote -> bulk-enrich credit flow.
 *
 * Bulk ops must be pre-priced: enrichList redeems a signed, single-use quoteId (bound to
 * the list + scope + lead count). The quote caps the spend. The pricing endpoint
 * (POST /api/v2/credits/estimate) is no longer part of the public API spec, so this
 * SDK cannot request a quote — pass one you already have.
 *
 * ⚠️ Spends credits for every lead in the list.
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.BulkEnrichWithQuote" -Dexec.args="<list_id> <quote_id>"
 */
package examples;

import java.util.Set;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.EnrichListRequest;
import ai.cleanlist.client.model.EnrichListResponse;
import ai.cleanlist.client.model.WorkflowStatusResponse;

public class BulkEnrichWithQuote {
    private static final Set<String> TERMINAL = Set.of("completed", "failed", "cancelled");

    public static void main(String[] args) throws ApiException, InterruptedException {
        if (args.length < 2) {
            System.err.println("Usage: BulkEnrichWithQuote <list_id> <quote_id>");
            System.exit(1);
        }
        String listId = args[0];
        String quoteId = args[1];
        Cleanlist cl = Cleanlist.fromEnv();

        // 1. Show the balance before spending.
        System.out.println("Balance: " + cl.workspace.creditsBalance());

        // 2. Redeem the quote.
        EnrichListResponse run = cl.enrichment.enrichList(new EnrichListRequest()
                .listId(listId).scope(EnrichListRequest.ScopeEnum.FULL).quoteId(quoteId));
        System.out.println("Bulk workflow dispatched: " + run.getWorkflowId());

        // 3. Poll.
        WorkflowStatusResponse status;
        do {
            Thread.sleep(5000);
            status = cl.enrichment.enrichmentStatus(run.getWorkflowId());
            System.out.printf("  %s: %s/%s (ok=%s failed=%s)%n", status.getStatus(),
                    status.getProcessed(), status.getTotal(), status.getCompleted(), status.getFailed());
        } while (!TERMINAL.contains(status.getStatus()));

        System.out.printf("Finished: charged=%s refunded=%s%n",
                status.getCreditsCharged(), status.getCreditsRefunded());
    }
}
