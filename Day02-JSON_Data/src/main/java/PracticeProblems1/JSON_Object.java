package PracticeProblems1;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON_Object {

    public static void main(String[] args) {
        JSONArray subjects = new JSONArray();
        subjects.put("Science");
        subjects.put("Maths");
        subjects.put("Physics");

        JSONObject userData = new JSONObject();
        userData.put("name","sanjay");
        userData.put("age","22");
        userData.put("subjects",subjects);

        System.out.println(userData.toString(2));
    }
}
