package AdvancedProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\detectDuplicates.csv";
        Set<String> ids = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                if (!ids.add(id)) { // If ID already exists in the set
                    System.out.println("Duplicate record found: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
