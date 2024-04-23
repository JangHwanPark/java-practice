package File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataSavaEx {
    public static void main(String[] args) {
        String dataToSave = "Test data";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BankManagement/src/data/test.txt"))) {
            writer.write(dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}