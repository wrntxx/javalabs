package com.education.ztu;

import java.util.ArrayDeque;
import java.util.Deque;

import com.education.ztu.shop.Categories;
import com.education.ztu.shop.Product;

public class Task4 {
    public static void main(String[] args) throws Exception {
        Deque<Product> productDeque = new ArrayDeque<Product>();

        productDeque.push(new Product("Hat", Categories.MENS_CLOTHING, 19.99));
        productDeque.offerLast(new Product("Skirt", Categories.WOMENS_CLOTHING, 29.99));

        Product firstProductInDeque = productDeque.getFirst();
        System.out.println("First product in the deque: " + firstProductInDeque.getName());

        Product lastProductInDequePeek = productDeque.peekLast();
        System.out.println("Last product in the deque (peek): "
                + (lastProductInDequePeek != null ? lastProductInDequePeek.getName() : "Deque is empty"));

        Product lastProductInDeque = productDeque.pop();
        System.out.println("Last product in the deque (pop): " + lastProductInDeque.getName());

        System.out.println("Products in the deque:");
        for (Product product : productDeque) {
            System.out.println(product.getName());
        }

        productDeque.removeLast();

        System.out.println("Products in the deque after removing the last:");
        for (Product product : productDeque) {
            System.out.println(product.getName());
        }
    }
}