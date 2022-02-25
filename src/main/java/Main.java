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
                        break;
                    case "SEARCH LOW 3":
                        printLow3(listOfCountries);
                        break;
                    case "SAVE TOP 3":
                        break;
                    case "SAVE LOW 3":
                        break;
                    case "MENU":
                        printMenu();
                        break;
                    case "EXIT":
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Default value");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void printTop3(List<Country> listOfCountries){
        Collections.sort(listOfCountries,(o1, o2) -> {return (o2.getStandard_rate().subtract(o1.getStandard_rate())).intValue();});
        for (int i = 0; i < 3; i++) {
            System.out.println(listOfCountries.get(i));
        }
    }

    public static void printLow3(List<Country> listOfCountries) {
        Collections.sort(listOfCountries,(o1, o2) -> {return (o1.getStandard_rate().subtract(o2.getStandard_rate())).intValue();});
        for (int i = 0; i < 3; i++) {
            System.out.println(listOfCountries.get(i));
        }
    }

    public static void printMenu() {
        System.out.println("Choose from the following.");
        System.out.println("SEARCH TOP 3 - types out the top 3 countries with highest standart rate (descending)");
        System.out.println("SEARCH LOW 3 - types out the top 3 countries with lowest standart rate (ascending)");
        System.out.println("MENU - shows menu options");
        System.out.println("EXIT");
        System.out.println("Enter your choice: ");
    }
}
