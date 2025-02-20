package IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class ModifyCSV_File {
    public static void main(String[] args) throws IOException {

        String filePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\IntermediateProblems\\modifyCSV.csv";

        List<String> modifiedLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String field = "IT";
            String line;

            String header = bufferedReader.readLine();
            modifiedLines.add(header);
            String[] headerField = header.split(",");

            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");

                if(columns[2].contains(field)) {
                    double salary = Double.parseDouble(columns[3]);
                    double increaseSalary = salary * 10 / 100;
                    double totalSalary = salary + increaseSalary;
                    columns[3] = String.valueOf(totalSalary);
                }
                modifiedLines.add(String.join(",", columns));
            }
        }

        try (FileWriter fileWriter = new FileWriter(filePath,true)) {
            for (String modifiedLine : modifiedLines) {
                fileWriter.write(modifiedLine + "\n");
            }
            System.out.println("CSV file has been modified successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
