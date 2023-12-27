package com.education.ztu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task5 {
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
        cheapProducts.forEach(System.out::println);
        System.out.println();

        double totalPrice = Arrays.stream(products)
                .mapToDouble(Product::getTotalValue)
                .reduce(0, Double::sum);
        System.out.println("Total price: " + totalPrice);
        System.out.println();

        Map<String, List<Product>> productsByBrand = Arrays.stream(products)
                .collect(Collectors.groupingBy(Product::getBrand));
        System.out.println("Products grouped by brand:");

        productsByBrand.entrySet().forEach(e -> {
            System.out.println("[" + e.getKey() + "]");
            e.getValue().forEach(System.out::println);
        });
        System.out.println();

        Product[] sortedProducts = Arrays.stream(products)
                .sorted(Product::compareByPrice)
                .toArray(Product[]::new);

        System.out.println("Sorted products in ascending order of price:");
        Arrays.stream(sortedProducts).forEach(System.out::println);
    }
}
