package IntermediateProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilterRecordsFromCSV {
    public static void main(String[] args) {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\IntermediateProblems\\filterRecordsData.csv";

        int count = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            int marks = 80;
            String line;

            String header = bufferedReader.readLine();
            String[] headerField = header.split(",");
            System.out.println(Arrays.toString(headerField));

            while((line = bufferedReader.readLine())  != null){
                String[] columns = line.split(",");

                try {
                    int mark = Integer.parseInt(columns[2].trim());

                    if (marks < mark) {
                        System.out.println(line);
                        count++;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing marks for line: " + line);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Total student who marks above 80: "+count);
    }
}
