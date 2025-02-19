package IPL_CensorAnalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class IplCensorAnalyzer {
    public static void main(String[] args) {

                try {
                    String jsonInputFile = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\java\\IPL_CensorAnalyzer\\InputData.json"; // JSON file path
                    String jsonOutputFile = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\java\\IPL_CensorAnalyzer\\OutputData.json"; // Output file path
                    List<Map<String, Object>> jsonData = readJsonFile(jsonInputFile);
                    List<Map<String, Object>> censoredJsonData = applyCensorship(jsonData);
                    writeJsonFile(jsonOutputFile, censoredJsonData);

                    // Read and process CSV file
                    String csvInputFile = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\java\\IPL_CensorAnalyzer\\InputData.csv"; // CSV file path
                    String csvOutputFile = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\java\\IPL_CensorAnalyzer\\OutputData.csv"; // Output file path
                    List<String[]> csvData = readCsvFile(csvInputFile);
                    List<String[]> censoredCsvData = applyCsvCensorship(csvData);
                    writeCsvFile(csvOutputFile, censoredCsvData);

                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }

            // Function to read JSON data from file
            public static List<Map<String, Object>> readJsonFile(String filePath) throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                return Arrays.asList(objectMapper.readValue(new File(filePath), Map[].class));
            }

            // Function to apply censorship to JSON data
            public static List<Map<String, Object>> applyCensorship(List<Map<String, Object>> data) {
                List<Map<String, Object>> censoredData = new ArrayList<>();

                for (Map<String, Object> match : data) {
                    Map<String, Object> censoredMatch = new HashMap<>(match);

                    // Masking team names
                    censoredMatch.put("team1", maskTeamName((String) censoredMatch.get("team1")));
                    censoredMatch.put("team2", maskTeamName((String) censoredMatch.get("team2")));

                    // Redacting player of the match
                    censoredMatch.put("player_of_match", "REDACTED");

                    censoredData.add(censoredMatch);
                }

                return censoredData;
            }

            // Function to mask part of the team name
            public static String maskTeamName(String teamName) {
                if (teamName != null && teamName.contains(" ")) {
                    String[] parts = teamName.split(" ");
                    return parts[0] + " ***";
                }
                return teamName;
            }

            // Function to write JSON data to file
            public static void writeJsonFile(String filePath, List<Map<String, Object>> data) throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
            }

            // Function to read CSV data from file
            public static List<String[]> readCsvFile(String filePath) throws IOException, CsvException {
                CSVReader reader = new CSVReader(new FileReader(filePath));
                List<String[]> data = reader.readAll();
                reader.close();
                return data;
            }

            // Function to apply censorship to CSV data
            public static List<String[]> applyCsvCensorship(List<String[]> data) {
                List<String[]> censoredData = new ArrayList<>();

                for (String[] match : data) {
                    // Skip the header row
                    if (match[0].equals("match_id")) {
                        censoredData.add(match);
                        continue;
                    }

                    // Censoring the match data
                    match[1] = maskTeamName(match[1]); // team1
                    match[2] = maskTeamName(match[2]); // team2
                    match[6] = "REDACTED"; // player_of_match

                    censoredData.add(match);
                }

                return censoredData;
            }

            // Function to write CSV data to file
            public static void writeCsvFile(String filePath, List<String[]> data) throws IOException {
                CSVWriter writer = new CSVWriter(new FileWriter(filePath));
                writer.writeAll(data);
                writer.close();
                System.out.println("Successfully");
            }

}
