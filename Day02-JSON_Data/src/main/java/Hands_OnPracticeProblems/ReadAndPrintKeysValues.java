package Hands_OnPracticeProblems;

import PracticeProblems1.JSON_Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadAndPrintKeysValues {
    public static void main(String[] args) throws IOException {
        String filepath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\resources\\JsonData.json";
        String jsonString = new String(Files.readAllBytes(Paths.get(filepath)));

        JSONObject jsonObject = new JSONObject(jsonString);

        for (String key : jsonObject.keySet()) {
            System.out.println("Key: " + key + ", Value: " + jsonObject.get(key));
        }

        }
}
