package com.myJava.practice.other;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Parallel 정렬 알고리즘
public class App {
    public static void main(String[] args) {
        int size=  1500;
        int[] numbers = new int[size];
        Random random = new Random();
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());

        long start = System.nanoTime();
        Arrays.sort(numbers); // 최대한 정렬 알고리즘, singleThread -> 그래서 한계는 있음
        System.out.println("serial sorting took " + (System.nanoTime() - start));


        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers); // Parallel 정렬 알고리즘 -> 이게 훨 빠르다!! -> 근데 정렬하는 배열의 크기에 따라서도 달라질 수 있다.
        System.out.println("parallel sorting took "  + (System.nanoTime() -start));
    }
}
