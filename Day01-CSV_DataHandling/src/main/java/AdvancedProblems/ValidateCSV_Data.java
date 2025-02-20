package AdvancedProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV_Data {

    private static String mobile_numberRegex = "^\\d{10}$";
    private static String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


    public static void main(String[] args) throws IOException {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\Data.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = bufferedReader.readLine();
            System.out.println("Header: " + header);

            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                String[] columns = line.split(",");

                if (columns.length != 2) {
                    System.out.println("Invalid row: " + line);
                    continue;
                }


                String email = columns[0].trim();
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                boolean validEmail = matcher.matches();
                if (!validEmail) {
                    System.out.println("Invalid email: " + email + " in row: " + line);
                    continue;
                }

                String phoneNumber = columns[1].trim();
                Pattern pattern1 = Pattern.compile(mobile_numberRegex);
                Matcher matcher1 = pattern1.matcher(phoneNumber);
                boolean validMobileNumber =  matcher.matches();
                if (!validMobileNumber) {
                    System.out.println("Invalid phone number: " + phoneNumber + " in row: " + line);
                    continue;
                }

                System.out.println("Valid row: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
