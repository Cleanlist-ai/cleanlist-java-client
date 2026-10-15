/*
 * Full lead-list lifecycle — create, read, update, paginate, delete. Free.
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.LeadLists"
 */
package examples;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.CreateListRequest;
import ai.cleanlist.client.model.LeadsPageResponse;
import ai.cleanlist.client.model.ListDetailResponse;
import ai.cleanlist.client.model.PublicLeadListUpdate;

public class LeadLists {
    public static void main(String[] args) throws ApiException {
        Cleanlist cl = Cleanlist.fromEnv();

        // Create (idempotent on name).
        ListDetailResponse list = cl.leadLists.createList(new CreateListRequest()
                .name("SDK — CRUD demo").description("created by the SDK example"));
        System.out.printf("Created %s (reused=%s)%n", list.getListId(), list.getReused());

        // Read one.
        ListDetailResponse detail = cl.leadLists.getList(list.getListId());
        System.out.printf("Name=%s leads=%s enriched=%s%n",
                detail.getName(), detail.getLeadCount(), detail.getEnrichedCount());

        // Update (rename / edit description / move folder).
        cl.leadLists.updateList(list.getListId(),
                new PublicLeadListUpdate().description("updated by the SDK example"));
        System.out.println("Updated description.");

        // Paginate all leads, following the cursor until it comes back empty.
        int total = 0;
        String cursor = null;
        do {
            LeadsPageResponse page = cl.leadLists.listLeadsInList(list.getListId(), 500, cursor);
            total += page.getLeads().size();
            cursor = page.getCursor();
        } while (cursor != null && !cursor.isEmpty());
        System.out.println("Walked " + total + " leads across all pages.");

        // Clean up.
        cl.leadLists.deleteList(list.getListId());
        System.out.println("Deleted list.");
    }
}
