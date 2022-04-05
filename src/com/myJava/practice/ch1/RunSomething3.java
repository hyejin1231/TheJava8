package com.myJava.practice.ch1;

import java.util.function.*;

// 자바에서 제공하는 함수형 인터페이스
public class RunSomething3 {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        Integer apply = plus10.apply(1);
        System.out.println("apply = " + apply);


        Function<Integer, Integer> plus10_1 = (i) -> i + 10;
        Function<Integer, Integer> multiple2 = (i) -> i * 2;
        System.out.println("plus10_1 = " + plus10_1.apply(1));

        // Function<T,R> - compose
        Function<Integer, Integer> compose = plus10_1.compose(multiple2);
        System.out.println("compose = " + compose.apply(10)); // result 30

        // Function<T,R> - andThen
        Function<Integer, Integer> andThen = plus10_1.andThen(multiple2);
        System.out.println("andThen = " + andThen.apply(10)); // result 40

        // Cosumer<T>
        Consumer<Integer> printT = (i) -> System.out.println("i= " + i);
        printT.accept(10); // result 10

        // Supplier<T>
        Supplier<Integer> get10 = () -> 10;

        // Predicate<T> 리턴값 boolean
        Predicate<String> startsWith_s = (s) -> s.startsWith("hyejin");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        System.out.println(startsWith_s.test("hyejin1231")); // result true
        System.out.println(isEven.test(5)); // result false



        // UnaryOperator<T>
        UnaryOperator<Integer>  unaryOperator = (i) -> i + 10;
        UnaryOperator<Integer> unaryOperator1 = (i) -> i * 2;
        System.out.println(unaryOperator.apply(5)); // result 15
        System.out.println(unaryOperator1.apply(3)); // result 6

        Integer apply1 = unaryOperator.andThen(unaryOperator1).apply(10);
        System.out.println(apply1);


    }

}
