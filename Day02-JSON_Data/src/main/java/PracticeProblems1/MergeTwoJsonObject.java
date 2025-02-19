package PracticeProblems1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;

public class MergeTwoJsonObject {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Veeru");
        jsonObject.put("age", "25");

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("city", "Jaipur");
        jsonObject1.put("address", "A-17 MP Nagar");

        JSONObject mergeTwoObject = new JSONObject(jsonObject.toString());
        for (String key : jsonObject1.keySet()) {
            mergeTwoObject.put(key, jsonObject1.get(key));
        }

        System.out.println(mergeTwoObject.toString());

    }
}
