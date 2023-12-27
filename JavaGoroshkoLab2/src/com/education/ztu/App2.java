package com.education.ztu;

import java.util.Arrays;

public class App2 {
    public static void main(String[] args) throws Exception {
        double[] numbers = new double[] { 10, 5, 2 };
        System.out.println("Numbers: " + Arrays.toString(numbers) + "\n");

        try {
            System.out.println("Addition: " + Operation.addition(numbers));
            System.out.println("Subtraction: " + Operation.subtraction(numbers));
            System.out.println("Multiplication: " + Operation.multiplication(numbers));
            System.out.println("Division: " + Operation.division(numbers));
            System.out.println("Average: " + Operation.average(numbers));
            System.out.println("Maximum: " + Operation.maximum(numbers));
            System.out.println("Minimum: " + Operation.minimum(numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nLocations: " + Arrays.toString(Location.values()));
    }
}