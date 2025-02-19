package PracticeProblems1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ExtractData {
    public static void main(String[] args) {

        String filepath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day02-JSON_Data\\src\\main\\resources\\JsonData.json";
        try{
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File(filepath));

            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
