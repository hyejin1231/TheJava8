package com.myJava.practice.ch1;

import java.util.function.*;

// 람다 표현식
public class RunSomething4 {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum = (a, b) -> a+ b;
        System.out.println("sum = " + sum.apply(1, 2));

        //                              타입을 적어줘도 된다. (굳이 안적어도 줘도 됨)
        BinaryOperator<Integer> sum2 = (Integer a, Integer b) -> a + b;



    }

}
