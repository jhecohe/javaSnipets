import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ConsumeAPI {

    public static void main(String[] args) {
        try {
            URL url = new URL(
                "https://jsonplaceholder.typicode.com/posts/" + 1
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                System.out.println(
                    "Error in request " + conn.getResponseCode()
                );
            }

            StringBuilder response = new StringBuilder();
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {
                response.append(sc.nextLine());
            }
            sc.close();
            System.out.println(response.toString());
        } catch (MalformedURLException mufe) {
            System.out.println("Error fetching URL" + mufe);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
