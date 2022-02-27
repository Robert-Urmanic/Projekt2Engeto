package Project2;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean bool = true;
        Scanner scanner = new Scanner(System.in);
        List<Country> listOfCountries = new ArrayList<>();
        try {
            LoadJson.loadFile(listOfCountries);
            while (bool) {
                printMenu();
                String choice = scanner.nextLine();
                switch (choice.toUpperCase(Locale.ROOT)) {
                    case "SEARCH TOP 3":
                        printTop3(listOfCountries);
                        System.out.println("Do you want to save these countries into a .txt file? Y/n");
                        choice = scanner.nextLine();
                        if ("Y".equals(choice.toUpperCase(Locale.ROOT))) {
                            String top3countries = "";
                            for (int i = 0; i < 3; i++) {
                                top3countries += listOfCountries.get(i);
                            }
                            FileCreation.setFile(top3countries, "top3Countries");
                            break;
                        }
                        System.out.println("File wasn't created.\n");
                        break;
                    case "SEARCH LOW 3":
                        printLow3(listOfCountries);
                        System.out.println("Do you want to save these countries into a .txt file? Y/n");
                        choice = scanner.nextLine();
                        if ("Y".equals(choice.toUpperCase(Locale.ROOT))) {
                            String top3countries = "";
                            for (int i = 0; i < 3; i++) {
                                top3countries += listOfCountries.get(i);
                            }
                            FileCreation.setFile(top3countries, "low3Countries");
                            break;
                        }
                        System.out.println("File wasn't created.\n");
                        break;
                    case "SEARCH BY COUNTRY":
                        System.out.println("Enter abbreviation of a country: ");
                        choice = scanner.nextLine();
                        for (Country tempC : listOfCountries) {
                            if (tempC.getAbbreviation().equals(choice.toUpperCase(Locale.ROOT))) {
                                System.out.println("The country of " + tempC.getCountry() + " has rates of:");
                                System.out.println("Standard rate: " + tempC.getStandard_rate());
                                System.out.println("Reduced rate: " + tempC.getReduced_rate());
                                System.out.println("Reduced rate alternative: " + tempC.getReduced_rate_alt());
                                System.out.println("Super reduced rate: " + tempC.getSuper_reduced_rate());
                                System.out.println("Parking rate: " + tempC.getParking_rate());
                                break;
                            }
                        }
                        System.out.println("There is not a country with an abbreviation of \"" + choice.toUpperCase(Locale.ROOT) + "\" in our database.");
                        break;
                    case "MENU":
                        printMenu();
                        break;
                    case "EXIT":
                        System.exit(1);
                        break;
                    default:
                        System.err.println("You have entered the wrong value!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTop3(List<Country> listOfCountries) {
        Collections.sort(listOfCountries, (o1, o2) -> {
            return (o2.getStandard_rate().subtract(o1.getStandard_rate())).intValue();
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(listOfCountries.get(i));
        }
    }

    public static void printLow3(List<Country> listOfCountries) {
        Collections.sort(listOfCountries, (o1, o2) -> {
            return (o1.getStandard_rate().subtract(o2.getStandard_rate())).intValue();
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(listOfCountries.get(i));
        }
    }

    public static void printMenu() {
        System.out.println("Choose from the following.\n");
        System.out.println("SEARCH TOP 3 - types out the top 3 countries with highest standart rate (descending)");
        System.out.println("SEARCH LOW 3 - types out the top 3 countries with lowest standart rate (ascending)");
        System.out.println("SEARCH BY COUNTRY - gives the option to search rates of a specific country by entering it's abbreviation");
        System.out.println("MENU - shows menu options");
        System.out.println("EXIT\n");
        System.out.println("Enter your choice: ");
    }
}
