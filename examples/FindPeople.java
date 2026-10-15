/*
 * Find people by filters — look up valid values, preview the compiled query, search.
 *
 * Free: searching spends no credits (credits are spent only when you enrich or save).
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.FindPeople"
 */
package examples;

import java.util.List;
import java.util.stream.Collectors;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.CompileRequest;
import ai.cleanlist.client.model.CompileResponse;
import ai.cleanlist.client.model.FilterOption;
import ai.cleanlist.client.model.PeopleFiltersResponse;
import ai.cleanlist.client.model.PeopleSearchCriteria;
import ai.cleanlist.client.model.PeopleSearchRequest;
import ai.cleanlist.client.model.PeopleSearchResponse;
import ai.cleanlist.client.model.PeopleSearchResultRow;

public class FindPeople {
    public static void main(String[] args) throws ApiException {
        Cleanlist cl = Cleanlist.fromEnv();

        // 1. Look up valid filter values. Fixed-enum fields (seniority, departments, ...)
        //    return a canned list; free-text fields (titles, locations) autocomplete the query.
        PeopleFiltersResponse seniority = cl.peopleFinder.searchFiltersPeople("seniority", null);
        System.out.println("Seniority values: " + seniority.getOptions().stream()
                .limit(8).map(FilterOption::getId).collect(Collectors.joining(", ")));

        PeopleFiltersResponse titles = cl.peopleFinder.searchFiltersPeople("titles", "vp sales");
        System.out.println("Title suggestions: " + titles.getOptions().stream()
                .limit(5).map(FilterOption::getLabel).collect(Collectors.joining(", ")));

        PeopleSearchCriteria criteria = new PeopleSearchCriteria()
                .jobTitlesInclude(List.of("VP of Sales", "Head of Sales"))
                .seniority(List.of("Vice President"))
                .contactCountries(List.of("USA", "CAN"))
                .companySizes(List.of("51-200", "201-500"));

        // 2. Dry run: compile the criteria into the provider filter without searching.
        CompileResponse compiled = cl.peopleFinder.compileSearch(new CompileRequest().criteria(criteria));
        System.out.println("Compiled route: " + compiled.getRoute());
        for (String warning : compiled.getWarnings()) {
            System.out.println("  warning: " + warning);
        }

        // 3. Search. limit caps this page; pass the cursor back for the next one.
        PeopleSearchResponse page = cl.peopleFinder.searchPeople(
                new PeopleSearchRequest().criteria(criteria).limit(10));
        System.out.printf("%s matches (credits charged: %s)%n", page.getTotal(), page.getCreditsCharged());
        for (PeopleSearchResultRow row : page.getResults()) {
            System.out.printf("  - %s | %s @ %s | %s%n",
                    row.getFullName(), row.getTitle(), row.getCompany(), row.getLinkedinUrl());
        }

        if (page.getCursor() != null) {
            PeopleSearchResponse more = cl.peopleFinder.searchPeople(
                    new PeopleSearchRequest().criteria(criteria).limit(10).cursor(page.getCursor()));
            System.out.println("Next page: " + more.getResults().size() + " more rows");
        }
    }
}
