package PracticeProblems1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

class Car{
    public String carName;
    public String brandName;
    public String color;

    public Car(String carName, String brandName, String color){
        this.carName = carName;
        this.brandName = brandName;
        this.color = color;
    }
}
public class ObjectWithJSON_Format {
    public static void main(String[] args) throws JsonProcessingException {
        Car car = new Car("Safari","TATA","White");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String convertIntoJSON = objectMapper.writeValueAsString(car);
        System.out.println(convertIntoJSON);

    }
}
