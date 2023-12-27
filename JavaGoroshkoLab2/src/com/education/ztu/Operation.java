package com.education.ztu;

import java.util.Arrays;

public class Operation {
    public static double addition(double... numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static double subtraction(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number is required for subtraction.");
        }
        return Arrays.stream(numbers, 1, numbers.length).reduce(numbers[0], (r, e) -> r - e);
    }

    public static double multiplication(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number is required for multiplication.");
        }
        return Arrays.stream(numbers).reduce(1, (r, e) -> r * e);
    }

    public static double division(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number is required for division.");
        }
        return Arrays.stream(numbers, 1, numbers.length).reduce(numbers[0], (r, e) -> {
            if (e == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }
            return r / e;
        });
    }

    public static double average(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number is required to calculate the average.");
        }
        return Arrays.stream(numbers).average().orElseThrow();
    }

    public static double maximum(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number is required to find the maximum.");
        }
        return Arrays.stream(numbers).max().orElseThrow();
    }

    public static double minimum(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number is required to find the minimum.");
        }
        return Arrays.stream(numbers).min().orElseThrow();
    }
}