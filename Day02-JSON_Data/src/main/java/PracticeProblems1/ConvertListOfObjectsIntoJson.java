package PracticeProblems1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class SuperClass{
    private String name;
    private String address;
    private String email;

    public SuperClass(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }

    public void setAddress(int i) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String mail) {
        this.email = email;
    }


}
public class ConvertListOfObjectsIntoJson {
    public static void main(String[] args) throws JsonProcessingException {

        List<SuperClass> people = new ArrayList<>();
        people.add(new SuperClass("John Doe", "john.doe@example.com","Indore"));
        people.add(new SuperClass("Jane Smith",  "jane.smith@example.com","Bhopal"));

        JSONArray jsonArray = new JSONArray();

        for (SuperClass person : people) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", person.getName());
            jsonObject.put("email", person.getEmail());
            jsonObject.put("address",person.getAddress());
            jsonArray.put(jsonObject);
        }

        System.out.println(jsonArray.toString(2));

    }
}
