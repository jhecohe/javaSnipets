import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumeAPI11Plus {

    public static void main(String[] args) {
        HttpClient hc = HttpClient.newHttpClient();
        HttpRequest hr = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts/" + 1))
            .GET()
            .build();

        Post p = new Post("12", "`1322", "title", "body");

        System.out.println("Test post => " + p.toString());

        try {
            // HttpResponse<String> hres = hc.send(
            //     hr,
            //     HttpResponse.BodyHandlers.ofString()
            // );
            // System.out.println("Post => " + hres.body());
            // From above is working to return a String
            //

            HttpResponse<InputStream> hres = hc.send(
                hr,
                BodyHandlers.ofInputStream()
            );
            ObjectInputStream ois = new ObjectInputStream(hres.body());
            Post post = (Post) ois.readObject();

            System.out.println(post.toString());
        } catch (IOException ioe) {
            System.out.println("Error consuming API =>" + ioe);
        } catch (InterruptedException ie) {
            System.out.println("Interrupted => " + ie);
        } catch (ClassNotFoundException cne) {
            System.out.println("Interrupted => " + cne);
        }
    }
}
