/*
 * Catching API errors. Free.
 *
 * Non-2xx responses throw the checked ApiException, exposing the status code and body.
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.ErrorHandling"
 */
package examples;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;

public class ErrorHandling {
    public static void main(String[] args) {
        Cleanlist cl = Cleanlist.fromEnv();
        try {
            cl.leadLists.getList("00000000-0000-0000-0000-000000000000");
        } catch (ApiException e) {
            switch (e.getCode()) {
                case 404 -> System.out.println("[404] no such list — handled");
                case 401 -> System.out.println("[401] bad or missing API key");
                default -> System.out.printf("[%d] %s%n", e.getCode(), e.getResponseBody());
            }
        }
    }
}
