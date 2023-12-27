package com.education.ztu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) throws Exception {
        Product[] products = {
                new Product("Laptop", "HP", 1200.0, 5),
                new Product("Smartphone", "Samsung", 800.0, 8),
                new Product("Tablet", "Apple", 900.0, 3),
        };

        List<String> brands = Arrays.stream(products)
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Brands: " + brands);
        System.out.println();

        List<Product> cheapProducts = Arrays.stream(products)
                .filter(product -> product.getPrice() < 1000)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Filtered products:");
        for (Product product : cheapProducts) {
            System.out.println(product);
        }
        System.out.println();

        double totalPrice = Arrays.stream(products)
                .mapToDouble(product -> product.getPrice() * product.getCount())
                .reduce(0, Double::sum);
        System.out.println("Total price: " + totalPrice);
        System.out.println();

        Map<String, List<Product>> productsByBrand = Arrays.stream(products)
                .collect(Collectors.groupingBy(Product::getBrand));
        System.out.println("Products grouped by brand:");

        for (Map.Entry<String, List<Product>> entry : productsByBrand.entrySet()) {
            System.out.println("[" + entry.getKey() + "]");
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
        System.out.println();

        Product[] sortedProducts = Arrays.stream(products)
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .toArray(Product[]::new);

        System.out.println("Sorted products in ascending order of price:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
}