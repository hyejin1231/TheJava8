package com.myJava.practice.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Stream
// 스트림은 데이터를 담고 있는 저장소가 아니고 스트림으로 처리하는 데이터는 오직 한번만 처리한다!
public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("hyejin");
        names.add("foo");
        names.add("kim");
        names.add("lee");

        names.stream().map(s -> s.toUpperCase()); // 스트림은 데이터를 변경하지 않는다. 한번 처리하고 끝!
        names.forEach(System.out::println);

        // 중개 오퍼레이션 .map()
        // 스트림을 리턴한다.
        names.stream().map(s -> {
            System.out.println("s = " + s);
            return s.toUpperCase();
        }); // 이거 실행해도 아무값도 출력되지 않는다.

        // 종료 오퍼레이션
        // 스트림 말고 다른 값을 리턴한다.
        System.out.println("=================================");
        List<String> collect = names.stream().map(s -> {
            System.out.println("s = " + s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);


        System.out.println("=================================");
        List<String> collect2 = names.parallelStream().map(s -> {
            System.out.println("s = " + s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect2.forEach(System.out::println);



    }
}
