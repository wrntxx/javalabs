package com.education.ztu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductTable implements ITable<Product> {
    private static final String TABLE_NAME = "products";
    private Connection connection;

    public ProductTable(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        String createTableQuery = "IF OBJECT_ID(N'" + TABLE_NAME + "', N'U') IS NULL CREATE TABLE " + TABLE_NAME + " (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "price FLOAT)";
        statement.executeUpdate(createTableQuery);
    }

    @Override
    public Product getEntityById(int entityId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
        preparedStatement.setInt(1, entityId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"));
        }
        return null;
    }

    @Override
    public List<Product> getAllEntities() throws SQLException {
        List<Product> products = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);

        while (resultSet.next()) {
            Product product = new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"));
            products.add(product);
        }

        return products;
    }

    @Override
    public void insertEntity(Product entity) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO " + TABLE_NAME + " (id, name, price) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setDouble(3, entity.getPrice());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateEntity(Product entity) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE " + TABLE_NAME + " SET name = ?, price = ? WHERE id = ?");
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setDouble(2, entity.getPrice());
        preparedStatement.setInt(3, entity.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteEntity(int entityId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ?");
        preparedStatement.setInt(1, entityId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteEntities() throws SQLException {
        Statement statement = connection.createStatement();
        String deleteAllRecordsQuery = "DELETE FROM " + TABLE_NAME;
        statement.executeUpdate(deleteAllRecordsQuery);
    }
}