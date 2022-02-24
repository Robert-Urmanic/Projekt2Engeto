import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoadJson {
    public static void loadFile() throws IOException, InterruptedException {
        String jsonFile = "https://euvatrates.com/rates.json";

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(jsonFile)).GET().build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + httpResponse.statusCode());

        System.out.println(httpResponse.body());

        String unfilteredJson = (String) httpResponse.body();
        System.out.println(unfilteredJson);
    }

    public static void main(String[] args) {
        try {
            LoadJson.loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
