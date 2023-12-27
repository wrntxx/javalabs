package com.education.ztu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("db");

        String url = bundle.getString("db.url");
        String username = bundle.getString("db.username");
        String password = bundle.getString("db.password");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("The connection has been successfully established!");

            Task1_5.connection = connection;
            Task6.connection = connection;

            System.out.println("[Task 1-5]");
            Task1_5.main(args);
            System.out.println();
            System.out.println("[Task 6]");
            Task6.main(args);
            System.out.println();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}