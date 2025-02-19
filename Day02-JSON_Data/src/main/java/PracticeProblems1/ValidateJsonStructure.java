package PracticeProblems1;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ValidateJsonStructure {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\", \"age\":30}";

        if (isValidJSON(json)) {
            System.out.println("Valid JSON.");
        } else {
            System.out.println("Invalid JSON.");
        }
    }

    public static boolean isValidJSON(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            return jsonNode != null;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}
