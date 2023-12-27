package com.education.ztu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Task6 {
    public static Connection connection;

    public static void main(String[] args) {
        try {
            SomeInterfaceDAO<Product> dao = new SomeInterfaceDAOImpl(connection);
            dao.createTable();

            Product product1 = new Product(1, "Apple", 4.99);
            Product product2 = new Product(2, "Coconut", 19.99);
            dao.insertEntity(product1);
            dao.insertEntity(product2);

            List<Product> products = dao.getAllEntities();
            System.out.println("All Products:");
            for (Product product : products) {
                System.out.println(product);
            }

            product1.setPrice(7.49);
            dao.updateEntity(product1);

            Product updatedProduct = dao.getEntityById(1);
            System.out.println("Updated Product:");
            System.out.println(updatedProduct);

            dao.deleteEntity(2);

            List<Product> remainingProducts = dao.getAllEntities();
            System.out.println("Remaining Products:");
            for (Product product : remainingProducts) {
                System.out.println(product);
            }

            dao.deleteEntities();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}