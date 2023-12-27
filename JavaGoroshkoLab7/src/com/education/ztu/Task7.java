package com.education.ztu;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task7 {
    private static final int ARRAY_SIZE = 1000000;

    public static void main(String[] args) throws Exception {
        int[] array = generateRandomArray(ARRAY_SIZE);

        long startTime = System.currentTimeMillis();
        long sum = calculateSumSingleThreaded(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded: Sum = " + sum + ", Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        sum = calculateSumMultiThreaded(array);
        endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded: Sum = " + sum + ", Time: " + (endTime - startTime) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static long calculateSumSingleThreaded(int[] array) {
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    private static long calculateSumMultiThreaded(int[] array) {
        int threadCount = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        int chunkSize = array.length / threadCount;
        long[] partialSums = new long[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int startIndex = i * chunkSize;
            final int endIndex = (i == threadCount - 1) ? array.length : (i + 1) * chunkSize;

            executorService.execute(() -> {
                long partialSum = 0;
                for (int j = startIndex; j < endIndex; j++) {
                    partialSum += array[j];
                }
                partialSums[startIndex / chunkSize] = partialSum;
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated());

        long totalSum = 0;
        for (long partialSum : partialSums) {
            totalSum += partialSum;
        }

        return totalSum;
    }
}