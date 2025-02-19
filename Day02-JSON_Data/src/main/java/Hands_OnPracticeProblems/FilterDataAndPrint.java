package Hands_OnPracticeProblems;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterDataAndPrint {
    public static void main(String[] args) {
        String jsonString = "[\n" +
                "  {\n" +
                "    \"name\": \"Raj\",\n" +
                "    \"age\": 30,\n" +
                "    \"gender\": \"Male\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Kirti\",\n" +
                "    \"age\": 38,\n" +
                "    \"gender\": \"Female\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Jay\",\n" +
                "    \"age\": 55,\n" +
                "    \"gender\": \"Male\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Rajeev\",\n" +
                "    \"age\": 29,\n" +
                "    \"gender\": \"Male\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Rahul\",\n" +
                "    \"age\": 15,\n" +
                "    \"gender\": \"Male\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Amrita\",\n" +
                "    \"age\": 15,\n" +
                "    \"gender\": \"Female\"\n" +
                "  }\n" +
                "]";

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int age = jsonObject.getInt("age");
                if(age > 25){
                    System.out.println(jsonObject.toString(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
