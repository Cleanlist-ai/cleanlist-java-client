/*
 * Enrich a single person and poll the workflow to completion.
 *
 * ⚠️ Spends credits (partial scope = 1 credit if data is found; pay-for-results).
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.EnrichPerson"
 */
package examples;

import java.util.Set;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.CreateListRequest;
import ai.cleanlist.client.model.EnrichPersonRequest;
import ai.cleanlist.client.model.EnrichPersonResponse;
import ai.cleanlist.client.model.ListDetailResponse;
import ai.cleanlist.client.model.WorkflowStatusResponse;

public class EnrichPerson {
    private static final Set<String> TERMINAL = Set.of("completed", "failed", "cancelled");

    public static void main(String[] args) throws ApiException, InterruptedException {
        Cleanlist cl = Cleanlist.fromEnv();

        ListDetailResponse list = cl.leadLists.createList(new CreateListRequest().name("SDK — enrich person"));

        // Provide whatever you know: email, linkedinUrl, or name + company/domain.
        EnrichPersonResponse job = cl.enrichment.enrichPerson(new EnrichPersonRequest()
                .leadListId(list.getListId())
                .firstName("Ada").lastName("Lovelace").companyName("Analytical Engines"));
        System.out.printf("Dispatched workflow %s (reserved %d credits)%n",
                job.getWorkflowId(), job.getCreditsReserved());

        WorkflowStatusResponse status;
        do {
            Thread.sleep(3000);
            status = cl.enrichment.enrichmentStatus(job.getWorkflowId());
            System.out.printf("  status=%s processed=%s/%s%n",
                    status.getStatus(), status.getProcessed(), status.getTotal());
        } while (!TERMINAL.contains(status.getStatus()));

        System.out.printf("Done: charged=%s refunded=%s%n",
                status.getCreditsCharged(), status.getCreditsRefunded());
        if (status.getResult() != null) {
            System.out.println("Result: " + status.getResult());
        }
    }
}
