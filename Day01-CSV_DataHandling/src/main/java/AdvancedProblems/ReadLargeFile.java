package AdvancedProblems;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\largeFile.csv";
        int chunkSize = 100;
        int recordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                recordCount++;
                System.out.println(line);

                if (recordCount % chunkSize == 0) {
                    System.out.println("Processed " + recordCount + " records so far.");
                }
            }
            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
