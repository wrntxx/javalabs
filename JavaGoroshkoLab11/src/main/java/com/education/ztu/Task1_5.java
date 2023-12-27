package com.education.ztu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Task1_5 {
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableQuery = "IF OBJECT_ID(N'person', N'U') IS NULL CREATE TABLE person (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "age INT)";
            statement.executeUpdate(createTableQuery);
        }

        try (Statement statement = connection.createStatement()) {
            String insertDataQuery = "INSERT INTO person (id, name, age) VALUES ";
            for (int i = 1; i <= 10; i++) {
                insertDataQuery += String.format("(%d, '%s', %d)", i, "Name" + i, 18 + i);
                if (i < 10) {
                    insertDataQuery += ", ";
                }
            }
            statement.addBatch(insertDataQuery);
            statement.executeBatch();
            printTable(statement);
        }

        String insertDataPreparedStatement = "INSERT INTO person (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataPreparedStatement)) {
            for (int i = 11; i <= 15; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "Name" + i);
                preparedStatement.setInt(3, 18 + i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            printTable(connection.createStatement());
        }

        String selectByCriteriaQuery = "SELECT * FROM person WHERE age > ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectByCriteriaQuery)) {
            int ageGreaterThan = 25;
            preparedStatement.setInt(1, ageGreaterThan);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Records with age greater than " + ageGreaterThan + ":");
            printTable(resultSet);
        }

        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);

            String insertDataQuery1 = "INSERT INTO person (id, name, age) VALUES (16, 'Name16', 36)";
            String insertDataQuery2 = "INSERT INTO person (id, name, age) VALUES (17, 'Name17', 28)";
            String insertDataQueryWithError = "INSERT INTO person (id, name, age) VALUES (18, 'Name18', 'invalid_age')";

            statement.executeUpdate(insertDataQuery1);
            statement.executeUpdate(insertDataQuery2);

            statement.executeUpdate(insertDataQueryWithError);

            Savepoint savepoint = connection.setSavepoint("after_successful_insert");

            String insertDataQuery3 = "INSERT INTO person (id, name, age) VALUES (19, 'Name19', 32)";
            statement.executeUpdate(insertDataQuery3);

            connection.rollback(savepoint);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE id > 15");
            System.out.println("Records added after savepoint:");
            printTable(resultSet);

            connection.commit();
        } catch (SQLException e) {
            System.err.println("Error during transaction execution: " + e.getMessage());
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

        try (Statement statement = connection.createStatement()) {
            String deleteAllRecordsQuery = "DELETE FROM person";
            statement.executeUpdate(deleteAllRecordsQuery);
            printTable(statement);
        }
    }

    private static void printTable(ResultSet resultSet) throws SQLException {
        System.out.println("ID\tName\tAge");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id + "\t" + name + "\t" + age);
        }
        System.out.println();
    }

    private static void printTable(Statement statement) throws SQLException {
        String selectAllQuery = "SELECT * FROM person";
        ResultSet resultSet = statement.executeQuery(selectAllQuery);
        printTable(resultSet);
    }
}