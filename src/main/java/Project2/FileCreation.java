package Project2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileCreation {
    public static void setFile(String countriesToSave, String name) {
    try (PrintWriter out = new PrintWriter(name + ".txt")) {
        out.println(countriesToSave);
        System.out.println("File created!");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
}
