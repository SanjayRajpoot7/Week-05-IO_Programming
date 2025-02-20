package AdvancedProblems;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSV_TO_JSON {
    public static void main(String[] args) {
        // Paths to the input CSV and output JSON files
        String csvFilePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\students.csv";
        String jsonFilePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\students.json"; // Use .json for output

        // Create ObjectMapper for JSON handling
        ObjectMapper objectMapper = new ObjectMapper();

        // List to store student data as maps
        List<Map<String, String>> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String[] headers = reader.readLine().split(","); // Read headers

            // Read the CSV file line by line
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                Map<String, String> student = new HashMap<>();

                // Create a map of header-value pairs for each student
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], columns[i]);
                }
                students.add(student);
            }

            // Write the students data as JSON to the output file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);
            System.out.println("CSV converted to JSON successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
