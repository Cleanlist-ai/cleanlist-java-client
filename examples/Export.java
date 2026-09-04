/*
 * Export a list — CSV (signed URL) and JSON (inline, paginated). Free.
 *
 *   mvn -q exec:java -Dexec.mainClass="examples.Export" -Dexec.args="<list_id>"
 */
package examples;

import ai.cleanlist.client.ApiException;
import ai.cleanlist.client.Cleanlist;
import ai.cleanlist.client.model.ExportCsvRequest;
import ai.cleanlist.client.model.ExportCsvResponse;
import ai.cleanlist.client.model.ExportJsonResponse;

public class Export {
    public static void main(String[] args) throws ApiException {
        if (args.length < 1) {
            System.err.println("Usage: Export <list_id>");
            System.exit(1);
        }
        String listId = args[0];
        Cleanlist cl = Cleanlist.fromEnv();

        // CSV: short-lived signed URL.
        ExportCsvResponse signed = cl.export.exportCsv(new ExportCsvRequest().listId(listId));
        System.out.printf("CSV: %d rows, %d bytes%n", signed.getRowCount(), signed.getFileSizeBytes());
        System.out.printf("     download_url (expires %s): %s%n", signed.getExpiresAt(), signed.getDownloadUrl());

        // JSON: rows inline, page by page.
        String cursor = null;
        int count = 0;
        long total = 0;
        do {
            ExportJsonResponse data = cl.export.exportJson(listId, 500, cursor, null);
            count += data.getLeads().size();
            total = data.getTotal();
            cursor = data.getCursor();
        } while (cursor != null && !cursor.isEmpty());
        System.out.printf("JSON: streamed %d of %d rows.%n", count, total);
    }
}
