package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first number: ");
            int number1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int number2 = scanner.nextInt();

            int result = gcd(number1, number2);
            System.out.println("Greatest Common Divisor: " + result);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
