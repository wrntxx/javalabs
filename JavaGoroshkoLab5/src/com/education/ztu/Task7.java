package com.education.ztu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 6);

        System.out.println("Array before sorting: " + numbers);

        Collections.sort(numbers);

        System.out.println("Array after sorting: " + numbers);

        int index = Collections.binarySearch(numbers, 6);
        System.out.println("Index of element 6 after sorting: " + index);

        Collections.reverse(numbers);
        System.out.println("Array after reversing: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Array after shuffling: " + numbers);

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);

        List<Integer> copy = Arrays.asList(new Integer[numbers.size()]);
        Collections.copy(copy, numbers);
        System.out.println("Copy of the array: " + copy);

        Collections.fill(numbers, 10);
        System.out.println("Array after filling with 10: " + numbers);

        Collections.rotate(copy, 2);
        System.out.println("Array after rotating by 2 positions: " + copy);

        try {
            ArrayList rawList = new ArrayList();

            Collection<String> checkedCollection = Collections.checkedCollection(rawList, String.class);

            rawList.add("One");
            rawList.add("Two");
            rawList.add(3);

            checkedCollection.add("Three");
            checkedCollection.add("Four");
            // checkedCollection.add(5);

            checkedCollection.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int frequency = Collections.frequency(numbers, 10);
        System.out.println("Frequency of 10 in the array: " + frequency);
    }
}