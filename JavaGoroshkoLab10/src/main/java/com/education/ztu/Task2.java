package com.education.ztu;

public class Task2 {
    public static void main(String[] args) {
        Product originalProduct = new Product("Laptop", "Dell", 999.99, 5);
        originalProduct.serialize("product.srl");

        Product deserializedProduct = Product.deserialize("product.srl");
        System.out.println("Deserialized Product: " + deserializedProduct);
    }
}