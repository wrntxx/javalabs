package com.education.ztu;

import java.util.HashMap;
import java.util.Map;

import com.education.ztu.shop.Categories;
import com.education.ztu.shop.Product;

public class Task6 {
    public static void main(String[] args) throws Exception {
        Map<String, Product> productMap = new HashMap<>();

        productMap.put("Shirt", new Product("Shirt", Categories.MENS_CLOTHING, 29.99));
        productMap.put("Dress", new Product("Dress", Categories.WOMENS_CLOTHING, 49.99));
        productMap.put("Gloves", new Product("Gloves", Categories.MENS_CLOTHING, 9.99));
        productMap.put("Scarf", new Product("Scarf", Categories.WOMENS_CLOTHING, 14.99));
        productMap.put("Socks", new Product("Socks", Categories.MENS_CLOTHING, 7.99));

        System.out.println("All products in the map:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        System.out.println();

        Product shirt = productMap.get("Shirt");
        System.out.println("Product with key 'Shirt': " + shirt.getName());

        boolean containsKey = productMap.containsKey("Shirt");
        System.out.println("Does the map contain key 'Shirt'? " + containsKey);

        boolean containsValue = productMap.containsValue(new Product("Dress", Categories.WOMENS_CLOTHING, 49.99));
        System.out.println("Does the map contain the value 'Dress'? " + containsValue);
        System.out.println();

        productMap.clear();

        productMap.putIfAbsent("Shirt", new Product("Shirt", Categories.MENS_CLOTHING, 29.99));
        productMap.putIfAbsent("Dress", new Product("Dress", Categories.WOMENS_CLOTHING, 49.99));

        System.out.println("Keys in the map:");
        for (String key : productMap.keySet()) {
            System.out.println(key);
        }
        System.out.println();

        System.out.println("Values in the map:");
        for (Product product : productMap.values()) {
            System.out.println(product.getName());
        }
        System.out.println();

        Map<String, Product> additionalMap = new HashMap<>();
        additionalMap.put("Jeans", new Product("Jeans", Categories.MENS_CLOTHING, 39.99));
        additionalMap.put("Blouse", new Product("Blouse", Categories.WOMENS_CLOTHING, 34.99));
        productMap.putAll(additionalMap);

        System.out.println("All products in the map after putAll:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        System.out.println();

        productMap.remove("Jeans");

        System.out.println("All products in the map after removal:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        System.out.println();

        int size = productMap.size();
        System.out.println("Size of the map: " + size);
    }
}
