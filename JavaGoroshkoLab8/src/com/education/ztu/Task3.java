package com.education.ztu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Task3 {
    public static void main(String[] args) throws Exception {
        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        Predicate<String> isPositive = str -> Double.parseDouble(str) > 0;
        Predicate<String> isPositiveNumber = isNumeric.and(isPositive);

        System.out.println(isPositiveNumber.test("42"));
        System.out.println(isPositiveNumber.test("-5"));
        System.out.println(isPositiveNumber.test("as"));
        System.out.println();

        Consumer<String> classSchedule = period -> {
            System.out.println("The class started at 8:30 a.m.");
            System.out.println("The class ended at 9:50 a.m.");
        };

        Consumer<String> printClassSchedule = classSchedule
                .andThen(s -> System.out.println("More information: " + s));

        printClassSchedule.accept("Lecture on programming");
        System.out.println();

        Supplier<String> uppercaseSentence = () -> "hello world!!!".toUpperCase();

        System.out.println(uppercaseSentence.get());
        System.out.println();

        Function<String, Integer> productOfNumbers = str -> Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);

        System.out.println(productOfNumbers.apply("2 3 5"));
    }
}