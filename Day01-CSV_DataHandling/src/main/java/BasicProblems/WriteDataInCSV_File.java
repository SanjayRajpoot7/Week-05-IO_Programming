package BasicProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataInCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\BasicProblems\\CSV_FileData.csv";

        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true))
                ){
            bufferedWriter.write("ID,Name,Departement,Salary\n");
            bufferedWriter.write("1001,Sanjay,IT,75000\n");
            bufferedWriter.write("1002,Raj,EC,65000\n");
            bufferedWriter.write("1003,jay,Manager,75000\n");
            bufferedWriter.write("1004,Rahul,HR,95000\n");
            bufferedWriter.write("1005,Jitesh,IT,45000");

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Data successfully written");
    }
}
