package com.myJava.practice.ex1;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//  메서드 레퍼런스
public class Example1 {
    public static void main(String[] args) {
        User user = new User();

        // static 메서드 참조하여 객체 생성
        UnaryOperator<String> print = user::printUserName;
        UnaryOperator<String> hello = User::HelloUserName;

        // 매개변수 없는 생성자 참조
        Supplier<User> constructorUser = User::new;

        // 매개변수 있는 생성자 참조
        Function<String, User> constructorUser1 = User::new;
        User aaa = constructorUser1.apply("aaa");
        System.out.println(aaa.getName());

    }
}
