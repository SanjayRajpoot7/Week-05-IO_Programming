package Hands_OnPracticeProblems;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ConvertCsvIntoJson {
    public static void main(String[] args) {
        String csvFile = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\resources\\csvFile.csv";

        try {
            CSVReader reader = new CSVReader(new FileReader(csvFile));

            List<String[]> rows = reader.readAll();

            String[] headers = rows.get(0);

            JSONArray jsonArray = new JSONArray();

            for (int i = 1; i < rows.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                String[] row = rows.get(i);

                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]);
                }

                jsonArray.put(jsonObject);
            }

            System.out.println(jsonArray.toString(4));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}