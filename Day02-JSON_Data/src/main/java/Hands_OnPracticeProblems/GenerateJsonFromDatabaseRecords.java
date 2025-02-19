package Hands_OnPracticeProblems;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class GenerateJsonFromDatabaseRecords {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "1234s";

        String sqlQuery = "SELECT eID, name, age, city FROM employee";

        JSONArray jsonArray = new JSONArray();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", resultSet.getInt("eID"));
                jsonObject.put("name", resultSet.getString("name"));
                jsonObject.put("age", resultSet.getInt("age"));
                jsonObject.put("city", resultSet.getString("city"));

                jsonArray.put(jsonObject);
            }

            System.out.println(jsonArray.toString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
