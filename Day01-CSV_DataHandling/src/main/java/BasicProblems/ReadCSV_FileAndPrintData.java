package BasicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV_FileAndPrintData {
    public static void main(String[] args) {

        String file = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\BasicProblems\\CSV_FileData.csv";
        String line;

        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file))
                ){

            String header = bufferedReader.readLine();
            String[] headerFields = header.split(",");
            System.out.println(headerFields[0]+" "+headerFields[1]+" "+headerFields[2]+" "+headerFields[3]);
            System.out.println();

            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("ID: "+data[0]+", Name: "+data[1]+", Department: "+data[2]+", Salary: "+data[3]);
            }




        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
