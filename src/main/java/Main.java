import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String test = "Search top 3";
        switch (test.toUpperCase(Locale.ROOT)){
            case "SEARCH TOP 3":
                System.out.println("That's right");
                break;
            case "SEARCH LOW 3":
                break;
            case "MENU":
                break;
            case "EXIT":
                System.exit(1);
                break;
            default:
                System.out.println("Default value");
        }
    }
}
