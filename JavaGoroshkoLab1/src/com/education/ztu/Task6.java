package com.education.ztu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task6 {
    static int[] fibonacci(int number) {
        int[] fibonacciNumbers = new int[number];
        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;

        for (int i = 2; i < fibonacciNumbers.length; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        return fibonacciNumbers;
    }

    private static int[] reverseArray(int[] array) {
        int length = array.length;
        return IntStream.range(0, length).map(i -> array[length - 1 - i]).toArray();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements in the Fibonacci array: ");
            int n = scanner.nextInt();

            int[] fibonacciArray = fibonacci(n);
            int[] reverseFibonacciArray = reverseArray(fibonacciArray);

            System.out.println("Fibonacci Array: " + Arrays.toString(fibonacciArray));
            System.out.println("Reverse Fibonacci Array: " + Arrays.toString(reverseFibonacciArray));
        }
    }
}
