package com.education.ztu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.education.ztu.shop.Categories;
import com.education.ztu.shop.Product;

public class Task3 {
    public static void main(String[] args) throws Exception {
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product("Shirt", Categories.MENS_CLOTHING, 29.99));
        productList.add(new Product("Dress", Categories.WOMENS_CLOTHING, 49.99));

        System.out.println("Size of the list: " + productList.size());

        Product firstProduct = productList.get(0);
        System.out.println("First product: " + firstProduct.getName());
        System.out.println();

        productList.addAll(List.of(
                new Product("Jeans", Categories.MENS_CLOTHING, 39.99),
                new Product("Blouse", Categories.WOMENS_CLOTHING, 34.99)
        ));

        System.out.println("Products using Iterator:");
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
        System.out.println();

        System.out.println("Products using ListIterator (backward):");
        ListIterator<Product> listIterator = productList.listIterator(productList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous().getName());
        }
        System.out.println();

        productList.remove(firstProduct);

        Product newProduct = new Product("Sweater", Categories.MENS_CLOTHING, 44.99);
        productList.set(1, newProduct);

        productList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));

        List<Product> subList = productList.subList(0, 2);

        System.out.println("Products in the sub list:");
        for (Product product : subList) {
            System.out.println(product.getName());
        }
        System.out.println();

        productList.clear();

        System.out.println("Is the list empty: " + productList.isEmpty());
    }
}