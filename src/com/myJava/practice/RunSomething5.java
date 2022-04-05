package com.myJava.practice;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//  메서드 레퍼런스
public class RunSomething5 {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();

        UnaryOperator<String> hi = Greeting::hi; // static 메서드 참조
        UnaryOperator<String> hello = greeting::hello; // 인스턴스 메서드 참조
        System.out.println(hello.apply("hyejin"));

        // 매개변수가 없는 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();

        // 매개변수가 있는 생성자 참조
        Function<String, Greeting> newGreeting2 = Greeting::new;
        Greeting hyejin = newGreeting2.apply("hyejin");
        System.out.println(hyejin.getName());

        String[] list = {"abcd", "efg", "aaa"};
        Arrays.sort(list, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(list));
    }

}
