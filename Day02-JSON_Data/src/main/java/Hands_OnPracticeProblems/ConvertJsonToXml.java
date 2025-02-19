package Hands_OnPracticeProblems;
import org.json.JSONObject;
import org.json.XML;

public class ConvertJsonToXml {
    public static void main(String[] args) {

        String jsonString = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\" }";
        JSONObject jsonObject = new JSONObject(jsonString);

        String xmlString = XML.toString(jsonObject);
        System.out.println(xmlString);
    }
}