package IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCSV_RecordsByColumn {
    public static void main(String[] args) {
        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\IntermediateProblems\\modifyCSV.csv";

        List<String[]> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            String header = bufferedReader.readLine();
            records.add(header.split(","));

            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");
                records.add(columns);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        records.sort((record1, record2) -> {
            double salary1 = Double.parseDouble(record1[3]);
            double salary2 = Double.parseDouble(record2[3]);
            return Double.compare(salary2, salary1);
        });

        System.out.println("Top 5 highest-paid employees:");
        for (int i = 1; i <= 5 && i < records.size(); i++) {
            String[] record = records.get(i);
            System.out.println("ID: " + record[0] + ", Name: " + record[1] + ", Department: " + record[2]+ ", Department: " + record[3]);
        }
    }
}
