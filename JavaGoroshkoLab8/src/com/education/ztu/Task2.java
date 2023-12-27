package com.education.ztu;

@FunctionalInterface
interface Printable {
    void print();
}

public class Task2 {
    public static void main(String[] args) throws Exception {
        Printable printable = () -> System.out.println("Hello, World!");

        printable.print();
    }
}
