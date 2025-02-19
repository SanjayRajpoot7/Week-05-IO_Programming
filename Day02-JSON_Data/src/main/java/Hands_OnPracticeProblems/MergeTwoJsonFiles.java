package Hands_OnPracticeProblems;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MergeTwoJsonFiles {
    public static void main(String[] args) {

        try {
            File file1 = new File("D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\resources\\merge1.json");
            JSONObject json1 = readJSONFromFile(file1);

            File file2 = new File("D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\resources\\merge2.json");
            JSONObject json2 = readJSONFromFile(file2);

            JSONObject mergedJson = new JSONObject(json1.toString());
            for (String key : json2.keySet()) {
                mergedJson.put(key, json2.get(key));
            }

            System.out.println("Merged JSON: " + mergedJson.toString(4)); // Pretty print with indentation

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject readJSONFromFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        JSONTokener tokener = new JSONTokener(reader);
        return new JSONObject(tokener);
    }
}
