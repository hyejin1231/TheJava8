package com.myJava.practice.ch2;


import com.myJava.practice.ch1.ex1.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

// 자바8 API의 기본 메소드와 스태틱 메소드
public class App2 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();

        name.add("hyejin");
        name.add("toby");
        name.add("foo");
        name.add("joo");


        // name.forEach(s -> System.out.println(s)); 줄임
//        for (String s : name) {
//            System.out.println(s);
//        } 이런 방법도 있는데 너무 코드 길어짐
        // iterable의 기본 메소드 - forEach()
        name.forEach(System.out::println);
        System.out.println("===================================");

        // iterable의 기본 메소드 - spliterator()
        Spliterator<String> spliterator = name.spliterator();// 쪼갤 수 있는 기능을 가진 iterator
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("===================================");


        Spliterator<String> stringSpliterator = name.spliterator();
        Spliterator<String> stringSpliterator1 = stringSpliterator.trySplit();
        while (stringSpliterator.tryAdvance(System.out::println));
        System.out.println("===================================");
        while (stringSpliterator1.tryAdvance(System.out::println)) ;


        System.out.println("===================================");
        // Collection의 기본 메소드 - stream()
        long h = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("H"))
                .count();
        System.out.println("h = " + h);


        System.out.println("===================================");
        // Collection의 기본 메소드 - removeIf()
        name.removeIf(s -> s.startsWith("j"));
        name.forEach(System.out::println);


        System.out.println("===================================");
        // Comparator의 기본 메소드 및 스태틱 메소드 - reversed()
        name.sort(String::compareToIgnoreCase); // 문자열 정렬
        name.forEach(System.out::println);

        System.out.println("===================================");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());

        name.forEach(System.out::println);


        System.out.println("===================================");
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            num.add(i);
        }

        num.sort(Comparator.reverseOrder()); // 역순
        num.forEach(System.out::println);

        System.out.println("===================================");
        num.sort(Comparator.naturalOrder());
        num.forEach(System.out::println);

        System.out.println("===================================");
        num.sort(Comparator.nullsFirst(Comparator.naturalOrder()));  // null 데이터는 맨 앞으로 정렬
        num.forEach(System.out::println);

        System.out.println("===================================");
        num.sort(Comparator.nullsLast(Comparator.reverseOrder())); // null 데이터는 맨 뒤뒤 정렬
        num.forEach(System.out::println);

        System.out.println("===================================");
        num.sort(Comparator.comparing(Integer::intValue));
        num.forEach(System.out::println);
    }
}
