package com.education.ztu;

public class Task6 {
    public static void main(String[] args) {
        Product product = new Product("Laptop", "Dell", 999.99, 5);

        String json = product.toJson();
        System.out.println("JSON representation:\n" + json);

        Product loadedProduct = Product.fromJson(json);
        System.out.println("\nLoaded Person from JSON:");
        System.out.println(loadedProduct);
    }
}