/*
 * The estimate -> quote -> bulk-enrich credit flow.
 *
 * Bulk ops must be pre-priced: creditsEstimate returns a signed, single-use quoteId
 * that enrichList redeems. The quote caps the spend.
 *
 * ⚠️ Spends credits for every lead in the list. Stops before dispatch if the balance
 * is insufficient, and prints the cost first.
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.BulkEnrichWithQuote" -Dexec.args="<list_id>"
 */
package examples;

import java.util.Set;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.EnrichListRequest;
import ai.cleanlist.client.model.EnrichListResponse;
import ai.cleanlist.client.model.EstimateCostRequest;
import ai.cleanlist.client.model.EstimateCostResponse;
import ai.cleanlist.client.model.WorkflowStatusResponse;

public class BulkEnrichWithQuote {
    private static final Set<String> TERMINAL = Set.of("completed", "failed", "cancelled");

    public static void main(String[] args) throws ApiException, InterruptedException {
        if (args.length < 1) {
            System.err.println("Usage: BulkEnrichWithQuote <list_id>");
            System.exit(1);
        }
        String listId = args[0];
        Cleanlist cl = Cleanlist.fromEnv();

        // 1. Price it.
        EstimateCostResponse quote = cl.workspace.creditsEstimate(
                new EstimateCostRequest().tool("enrich_list").listId(listId).scope("full"));
        System.out.printf("Estimate: %d credits for %d leads (you have %d, sufficient=%b)%n",
                quote.getEstimatedCost(), quote.getRowCount(), quote.getAvailableCredits(), quote.getSufficient());
        if (!Boolean.TRUE.equals(quote.getSufficient())) {
            System.err.println("Not enough credits — top up at app.cleanlist.ai/billing.");
            System.exit(1);
        }

        // 2. Redeem the quote.
        EnrichListResponse run = cl.enrichment.enrichList(new EnrichListRequest()
                .listId(listId).scope(EnrichListRequest.ScopeEnum.FULL).quoteId(quote.getQuoteId()));
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
