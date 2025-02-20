package BasicProblems;
import org.apache.commons.collections.BagUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRowsInCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\BasicProblems\\CSV_FileData.csv";
        int count = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = bufferedReader.readLine()) != null){
                count++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Total rows in csv file: "+count);
    }
}
