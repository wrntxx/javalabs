package com.education.ztu;

import java.util.NavigableSet;
import java.util.TreeSet;

import com.education.ztu.shop.Categories;
import com.education.ztu.shop.Product;

public class Task5 {
    public static void main(String[] args) throws Exception {
        NavigableSet<Product> productSet = new TreeSet<Product>();

        productSet.add(new Product("Sweater", Categories.MENS_CLOTHING, 44.99));
        productSet.add(new Product("Jacket", Categories.WOMENS_CLOTHING, 59.99));
        productSet.add(new Product("Gloves", Categories.MENS_CLOTHING, 9.99));
        productSet.add(new Product("Scarf", Categories.WOMENS_CLOTHING, 14.99));
        productSet.add(new Product("Socks", Categories.MENS_CLOTHING, 7.99));

        Product firstProductInSet = productSet.pollFirst();
        System.out.println("First product in the set: " + firstProductInSet.getName());

        Product newFirstProduct = new Product("Hat", Categories.MENS_CLOTHING, 19.99);
        productSet.add(newFirstProduct);

        Product lastProductInSet = productSet.pollLast();
        System.out.println("Last product in the set: " + lastProductInSet.getName());
        System.out.println();

        
        System.out.println("Products in the set:");
        for (Product product : productSet) {
            System.out.println(product.getName());
        }
        System.out.println();
        
        Product firstProduct = productSet.first();
        Product lastProduct = productSet.last();

        NavigableSet<Product> subSet = productSet.subSet(firstProduct, true, lastProduct, true);
        NavigableSet<Product> headSet = productSet.headSet(lastProduct, false);
        NavigableSet<Product> tailSet = productSet.tailSet(lastProduct, true);
        NavigableSet<Product> descendingSet = productSet.descendingSet();

        Product ceilingProduct = productSet.ceiling(new Product("Blouse", Categories.WOMENS_CLOTHING, 34.99));
        Product floorProduct = productSet.floor(new Product("Jeans", Categories.MENS_CLOTHING, 39.99));
        Product higherProduct = productSet.higher(new Product("Dress", Categories.WOMENS_CLOTHING, 49.99));
        Product lowerProduct = productSet.lower(new Product("Jacket", Categories.WOMENS_CLOTHING, 59.99));

        System.out.println("Products in descending order:");
        for (Product product : descendingSet) {
            System.out.println(product.getName());
        }
        System.out.println();

        System.out.println("Products in the subset:");
        for (Product product : subSet) {
            System.out.println(product.getName());
        }
        System.out.println();

        System.out.println("Products in the headSet:");
        for (Product product : headSet) {
            System.out.println(product.getName());
        }
        System.out.println();

        System.out.println("Products in the tailSet:");
        for (Product product : tailSet) {
            System.out.println(product.getName());
        }
        System.out.println();

        System.out.println("Products in descending order:");
        for (Product product : descendingSet) {
            System.out.println(product.getName());
        }
        System.out.println();

        System.out.println("Ceiling product: " + (ceilingProduct != null ? ceilingProduct.getName() : "No ceiling product"));
        System.out.println("Floor product: " + (floorProduct != null ? floorProduct.getName() : "No floor product"));
        System.out.println("Higher product: " + (higherProduct != null ? higherProduct.getName() : "No higher product"));
        System.out.println("Lower product: " + (lowerProduct != null ? lowerProduct.getName() : "No lower product"));
    }
}