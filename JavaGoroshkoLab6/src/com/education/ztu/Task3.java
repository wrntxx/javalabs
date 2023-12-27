package com.education.ztu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.education.ztu.shop.Categories;
import com.education.ztu.shop.Product;

public class Task3 {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<Product>();

        products.add(new Product("T-Shirt", Categories.MENS_CLOTHING, 19.99));
        products.add(new Product("Jeans", Categories.WOMENS_CLOTHING, 49.99));
        products.add(new Product("Sneakers", Categories.MENS_CLOTHING, 39.99));
        products.add(new Product("Dress Shirt", Categories.WOMENS_CLOTHING, 29.99));
        products.add(new Product("Running Shoes", Categories.MENS_CLOTHING, 59.99));
        products.add(new Product("Skirt", Categories.WOMENS_CLOTHING, 34.99));
        products.add(new Product("Hoodie", Categories.MENS_CLOTHING, 44.99));
        products.add(new Product("Blouse", Categories.WOMENS_CLOTHING, 27.99));
        products.add(new Product("Casual Shoes", Categories.MENS_CLOTHING, 49.99));
        products.add(new Product("Jacket", Categories.WOMENS_CLOTHING, 69.99));

        String filePath = "text.txt";
        Locale locale = new Locale("uk_UA");

        FileWriter fileWriter = new FileWriter(filePath, StandardCharsets.UTF_8);
        Formatter formatter = new Formatter(fileWriter);

        printBill(formatter, products, locale);
        fileWriter.close();

        int data;
        FileReader fileReader = new FileReader(filePath, StandardCharsets.UTF_8);
        PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        while ((data = fileReader.read()) != -1) {
            ps.print((char) data);
        }
        fileReader.close();
    }

    private static void printBill(Formatter formatter, List<Product> products, Locale locale) {
        LocalDateTime dateTime = LocalDateTime.now();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.education.ztu.resources.data", locale);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        String divider = "=".repeat(55) + "\n";
        String formattedDateTime = dateTime.format(dateFormatter);

        formatter.format("%-30s%25s%n", resourceBundle.getString("date.time.purchase"), formattedDateTime);
        formatter.format(divider);
        formatter.format("%-5s%-20s%-20s%-10s%n", "#",
                resourceBundle.getString("product"),
                resourceBundle.getString("category"),
                resourceBundle.getString("price"));
        formatter.format(divider);

        int productNumber = 1;
        double totalCost = 0;

        for (Product product : products) {
            formatter.format("%-5d%-20s%-20s%-10s\n",
                    productNumber++,
                    product.getName(),
                    product.getCategory(),
                    currencyFormat.format(product.getPrice()));
            totalCost += product.getPrice();
        }

        formatter.format(divider);
        formatter.format("%-45s%-10s\n", resourceBundle.getString("total"), currencyFormat.format(totalCost));
    }
}