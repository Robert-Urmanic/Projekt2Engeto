package HttpApi;

import Project2.Country;
import Project2.LoadJson;
import Project2.Main;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class P2Controller {

    @GetMapping(value = "/api/searchTop3")
    public String searchTop3() {
        List<Country> listOfCountries = new ArrayList<>();
        try {
            LoadJson.loadFile(listOfCountries);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.printTop3(listOfCountries);
        String top3countries = "";
        for (int i = 0; i < 3; i++) {
            top3countries += listOfCountries.get(i);
        }
        return top3countries;
    }

    @GetMapping(value = "/api/searchLow3")
    public String searchLow3() {
        List<Country> listOfCountries = new ArrayList<>();
        try {
            LoadJson.loadFile(listOfCountries);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.printLow3(listOfCountries);
        String low3countries = "";
        for (int i = 0; i < 3; i++) {
            low3countries += listOfCountries.get(i);
        }
        return low3countries;
    }

    @GetMapping(value = "/api/searchByAbbrev/{abbrev}")
    public String searchByAbbrev(@PathVariable String abbrev) {
        List<Country> listOfCountries = new ArrayList<>();
        try {
            LoadJson.loadFile(listOfCountries);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String returnValue = "";
        for (Country tempC : listOfCountries) {
            if (tempC.getAbbreviation().equals(abbrev.toUpperCase(Locale.ROOT))) {
                returnValue += ("The country of " + tempC.getCountry() + " has rates of:" +
                        "\nStandard rate: " + tempC.getStandard_rate() + "\nReduced rate: " + tempC.getReduced_rate() +
                        "\nReduced rate alternative: " + tempC.getReduced_rate_alt() +
                        "\nSuper reduced rate: " + tempC.getSuper_reduced_rate() +
                        "\nParking rate: " + tempC.getParking_rate());

            }
        }
        if (returnValue.equals("")){
            return "Wrong abbreviation!";
        }
        return returnValue;
    }

}
