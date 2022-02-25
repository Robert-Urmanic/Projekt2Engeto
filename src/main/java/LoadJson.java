import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadJson {
    public static void loadFile(List<Country> listOfCountries) throws IOException, InterruptedException {
        String jsonFile = "https://euvatrates.com/rates.json";

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(jsonFile)).GET().build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // System.out.println("Status code: " + httpResponse.statusCode());



        String unfilteredJson = (String) httpResponse.body();

        String parts[] = unfilteredJson.split("\"rates\": \\{");
        String splitToJsonByWildcard[] = parts[1].split("\"\\w\\w\":");
        String splitForAbbrev[] = Arrays.stream(parts[1].split("\\},")).map(String::trim).toArray(String[]::new);



        List<String> listOfAbbreviations = new ArrayList<>();

        for (int i = 0; i < splitForAbbrev.length; i++) {
            String tempAbbrevHolder = "";
            for (int j = 0; j < 4; j++) {
                tempAbbrevHolder += splitForAbbrev[i].charAt(j);
            }
            listOfAbbreviations.add(tempAbbrevHolder);
        }



        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();

        Gson gson = gsonBuilder.create();
        Country country1 = new Country();



        for (int i = 0; i < listOfAbbreviations.size(); i++) {
            if (i < 29) {
                country1 = gson.fromJson(splitToJsonByWildcard[i + 1].replace("},", ",\"abbreviation\": " + listOfAbbreviations.get(i) + "}"), Country.class);
                listOfCountries.add(country1);
            }
            else{
                country1 = gson.fromJson(splitToJsonByWildcard[i+1].replace("}","") + ",\"abbreviation\": " + listOfAbbreviations.get(i) + "}", Country.class);
                listOfCountries.add(country1);
            }
        }
    }
}
