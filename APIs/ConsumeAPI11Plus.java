import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumeAPI11Plus {

    public static void main(String[] args) {
        HttpClient hc = HttpClient.newHttpClient();
        HttpRequest hr = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
            .GET()
            .build();

        try {
            HttpResponse<InputStream> hres = hc.send(
                hr,
                HttpResponse.BodyHandlers.ofInputStream()
                // HttpResponse.BodyHandlers.ofString()
            );

            InputStreamReader isr = new InputStreamReader(hres.body());
            BufferedReader br = new BufferedReader(isr);

            String linea = "";
            int count = 0;
            do {
                linea = br.readLine();
                if (linea != null && linea.contains("id\":")) {
                    count++;
                    System.out.println(linea);
                    System.out.println(linea.substring(linea.length() - 3));
                }
            } while (linea != null);
            System.out.println("Total " + count);
        } catch (IOException ioe) {
            System.out.println("Error consuming API =>" + ioe);
        } catch (InterruptedException ie) {
            System.out.println("Interrupted => " + ie);
        }
    }
}
