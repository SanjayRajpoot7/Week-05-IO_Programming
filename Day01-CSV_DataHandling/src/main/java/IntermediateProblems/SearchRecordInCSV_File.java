package IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecordInCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\IntermediateProblems\\File.csv";

        int count = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String field = "Jitin";
            String line;

            while((line = bufferedReader.readLine())  != null){
                String[] columns = line.split(",");
                if(columns[1].contains(field)){
                    System.out.println("Department: "+columns[2]+", Salary: "+columns[3]);
                    count++;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Total records: "+count);
    }
}
