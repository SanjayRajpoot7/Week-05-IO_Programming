package AdvancedProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Student {
        private int id;
        private String name;
        private int age;
        private int marks;
        private String grade;

        // Constructor
        public Student(int id, String name, int age, int marks, String grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
            this.grade = grade;
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return id + "," + name + "," + age + "," + marks + "," + grade;
        }
    }


public class MergeCSV_File {
    public static void main(String[] args) throws IOException {
        String filePath1 = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\student1CSV_File.csv";
        String filePath2 = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\student2CSV_File.csv";
        String outputFilePath = "D:\\capgeminiTraining\\week-05-IO_Programming\\Day01-CSV_DataHandling\\src\\main\\java\\AdvancedProblems\\mergeData.csv";

        Map<Integer, Student> studentsMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath1))) {
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());

                studentsMap.put(id, new Student(id, name, age, 0, null));
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath2));
             FileWriter fileWriter = new FileWriter(outputFilePath)) {

            fileWriter.write("ID, Name, Age, Marks, Grade\n");

            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0].trim());
                int marks = Integer.parseInt(columns[1].trim());
                String grade = columns[2].trim();

                if (studentsMap.containsKey(id)) {
                    Student student = studentsMap.get(id);

                    student.setMarks(marks);
                    student.setGrade(grade);

                    fileWriter.write(student.toString() + "\n");
                }
            }
        }

        System.out.println("CSV files merged successfully!");
    }
}