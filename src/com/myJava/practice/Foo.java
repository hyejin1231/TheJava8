package com.myJava.practice;

public class Foo {

    public static void main(String[] args) {

        // 익명 내부 함수
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {

            }
        };

        // 람다 함수 (익명 내부 함수를 좀 더 간단하게 사용하기 위해서)
        // 함수형 인터페이스
        RunSomething runSomething1 = () -> System.out.println("hi");
        runSomething1.doIt();
    }
}
