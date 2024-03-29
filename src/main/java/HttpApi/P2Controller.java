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
    public static final boolean printFile = false;
    @GetMapping(value = "/api/searchTop3")
    public String searchTop3() {
        List<Country> listOfCountries = getCountries();
        String top3Countries = Main.printLowOrTopForApi(listOfCountries, false);;
        return top3Countries;
    }

    private List<Country> getCountries() {
        List<Country> listOfCountries = new ArrayList<>();
        try {
            LoadJson.loadFile(listOfCountries);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listOfCountries;
    }

    @GetMapping(value = "/api/searchLow3")
    public String searchLow3() {
        List<Country> listOfCountries = getCountries();
        String low3Countries = Main.printLowOrTopForApi(listOfCountries, true);

        return low3Countries;
    }

    @GetMapping(value = "/api/searchByAbbrev/{abbrev}")
    public String searchByAbbrev(@PathVariable String abbrev) {
        List<Country> listOfCountries = getCountries();
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
