package com.education.ztu;

import java.util.Arrays;
import java.util.Optional;

public class Task6 {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 1, 5, 3, 8, 2 };

        Optional<String> maxNumber = findMaxNumber(numbers);
        System.out.println("Max number: " + maxNumber.orElse("Numbers are missing"));
    }

    private static Optional<String> findMaxNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Optional.empty();
        }

        int max = Arrays.stream(numbers)
                .max()
                .orElseThrow();

        return Optional.of(Integer.toString(max));
    }
}