package com.foodordering;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/food_ordering";
        String user = "root"; // or your MySQL username
        String password = ""; // replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connection successful!");

                // Create a simple query to fetch data from Restaurants table
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Restaurants");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Address: " + rs.getString("address"));
                }
            } else {
                System.out.println("Connection failed (conn is null).");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
