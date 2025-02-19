//package Hands_OnPracticeProblems;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.networknt.schema.*;
//import com.networknt.schema.JsonSchema;
//import com.networknt.schema.JsonValidator;
//import org.json.JSONObject;
//
//import javax.xml.validation.Schema;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Set;
//
//public class ValidateAnEmailFieldUsingJsonSchema {
//    public static void main(String[] args) {
//
//        String schemaString = "{\n" +
//                "  \"type\": \"object\",\n" +
//                "  \"properties\": {\n" +
//                "    \"email\": {\n" +
//                "      \"type\": \"string\",\n" +
//                "      \"format\": \"email\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"required\": [\"email\"]\n" +
//                "}";
//
//        String jsonString = "{ \"email\": \"test@example.com\" }";
//
//        JSONObject jsonSchemaObject = new JSONObject(schemaString);
//
//        // Load the JSON schema
//        Schema schema = SchemaLoader.load(jsonSchemaObject);
//
//        // Convert the JSON string to a JSONObject
//        JSONObject jsonSubject = new JSONObject(jsonString);
//
//        try {
//            schema.validate(jsonSubject);
//            System.out.println("JSON is valid!");
//        } catch (ValidationException e) {
//            System.out.println("Invalid JSON: " + e.getMessage());
//        }
//    }
//}