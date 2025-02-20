package AdvancedProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Studentt {
    private String name;
    private String email;
    private String mobileNumber;

    public Studentt(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

}

public class ConvertCSV_IntoObjects {

    public static void main(String[] args) {

        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\Data.csv";

        List<Studentt> students = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            String header = bufferedReader.readLine();
            System.out.println("Header: " + header);

            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length == 3) {
                    String name = columns[0].trim();
                    String email = columns[1].trim();
                    String mobileNumber = columns[2].trim();

                    Studentt student = new Studentt(name, email, mobileNumber);
                    students.add(student);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nList of Students:");
        for (Studentt student : students) {
            System.out.println(student);
        }
    }
}
