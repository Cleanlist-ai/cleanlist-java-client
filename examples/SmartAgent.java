/*
 * Run a custom AI smart-agent column over a list and read the per-lead results.
 *
 * ⚠️ Spends credits (priced per processed row). Estimates first and prints the cost.
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.SmartAgent" -Dexec.args="<list_id>"
 */
package examples;

import java.util.Set;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.EstimateCostRequest;
import ai.cleanlist.client.model.EstimateCostResponse;
import ai.cleanlist.client.model.RunSmartAgentRequest;
import ai.cleanlist.client.model.RunSmartAgentResponse;
import ai.cleanlist.client.model.SmartAgentResultRow;
import ai.cleanlist.client.model.SmartAgentResultsResponse;

public class SmartAgent {
    private static final Set<String> TERMINAL = Set.of("completed", "failed", "cancelled");
    private static final int MAX_ROWS = 25;

    public static void main(String[] args) throws ApiException, InterruptedException {
        if (args.length < 1) {
            System.err.println("Usage: SmartAgent <list_id>");
            System.exit(1);
        }
        String listId = args[0];
        Cleanlist cl = Cleanlist.fromEnv();

        // Price the run for the exact request shape.
        EstimateCostResponse quote = cl.workspace.creditsEstimate(new EstimateCostRequest()
                .tool("run_smart_agent").listId(listId).agentType("custom_ai").rowCount(MAX_ROWS));
        System.out.printf("Cost: %d credits (sufficient=%b)%n", quote.getEstimatedCost(), quote.getSufficient());
        if (!Boolean.TRUE.equals(quote.getSufficient())) {
            System.err.println("Not enough credits.");
            System.exit(1);
        }

        RunSmartAgentResponse run = cl.smartAgents.runSmartAgent(new RunSmartAgentRequest()
                .listId(listId)
                .agentType(RunSmartAgentRequest.AgentTypeEnum.CUSTOM_AI)
                .columnName("Outreach angle")
                .prompt("In one sentence, suggest a cold-outreach angle for this lead.")
                .leadScope(RunSmartAgentRequest.LeadScopeEnum.SUBSET)
                .maxRows(MAX_ROWS)
                .quoteId(quote.getQuoteId()));
        System.out.printf("Started smart agent: %s (status=%s)%n", run.getSmartAgentTaskId(), run.getStatus());

        // Poll the run's results endpoint until it finishes.
        SmartAgentResultsResponse res = cl.smartAgents.getSmartAgentResults(run.getSmartAgentTaskId());
        while (!TERMINAL.contains(res.getStatus())) {
            System.out.printf("  %s: ok=%s failed=%s/%s%n", res.getStatus(), res.getSucceeded(), res.getFailed(), res.getTotal());
            Thread.sleep(5000);
            res = cl.smartAgents.getSmartAgentResults(run.getSmartAgentTaskId());
        }

        for (SmartAgentResultRow row : res.getResults().subList(0, Math.min(10, res.getResults().size()))) {
            System.out.printf("  lead=%s -> %s%n", row.getLeadId(), row.getValue());
        }
    }
}
