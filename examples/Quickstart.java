/*
 * Quickstart — the 60-second tour. Free (no credits spent).
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.Quickstart"
 */
package examples;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.CreateListRequest;
import ai.cleanlist.client.model.ListDetailResponse;
import ai.cleanlist.client.model.ListSummary;
import ai.cleanlist.client.model.ListsPageResponse;
import ai.cleanlist.client.model.WhoamiResponse;

public class Quickstart {
    public static void main(String[] args) throws ApiException {
        String host = System.getenv().getOrDefault("CLEANLIST_HOST", Cleanlist.DEFAULT_BASE_PATH);
        Cleanlist cl = new Cleanlist(null, host); // null -> reads CLEANLIST_API_KEY

        // Who am I? — identity, org, plan tier, scopes.
        WhoamiResponse me = cl.workspace.whoami();
        System.out.printf("Authenticated as org '%s' (tier: %s)%n", me.getOrganizationName(), me.getTier());

        // Credit balance.
        System.out.println("Credit balance: " + cl.workspace.creditsBalance().getCredits());

        // Create a lead list (idempotent on name).
        ListDetailResponse list = cl.leadLists.createList(new CreateListRequest().name("SDK quickstart"));
        System.out.println("List ready: " + list.getListId());

        // Recent lists.
        ListsPageResponse page = cl.leadLists.listLists(null, 5, null);
        System.out.println("Recent lists:");
        for (ListSummary s : page.getLists()) {
            System.out.printf("  - %s (%d leads)%n", s.getName(), s.getLeadCount());
        }
    }
}
