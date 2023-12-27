package com.education.ztu;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            int number = scanner.nextInt();

            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            System.out.println("Sum: " + sum);
        }
    }
}
