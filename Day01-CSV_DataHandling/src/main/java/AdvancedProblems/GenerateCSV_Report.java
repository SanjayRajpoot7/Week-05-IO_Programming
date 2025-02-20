package AdvancedProblems;

import java.io.*;
import java.sql.*;

public class GenerateCSV_Report {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:300/your_database";
        String username = "your_username";
        String password = "your_password";
        String csvFilePath = "employees_report.csv";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {

            String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees";
            ResultSet resultSet = statement.executeQuery(query);

            writer.write("EmployeeID,Name,Department,Salary\n");

            while (((ResultSet) resultSet).next()) {
                String employeeID = resultSet.getString("EmployeeID");
                String name = resultSet.getString("Name");
                String department = resultSet.getString("Department");
                String salary = resultSet.getString("Salary");
                writer.write(employeeID + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV report generated successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
