package com.myJava.practice;

@FunctionalInterface // 자바에서 제공하는 어노테이션
public interface RunSomething {

    void doIt(); // 함수형 인터페이스 (추상메서드가 1개만 있을때) abstract 생략

//    void getAge(); ERROR

    static void printName() {
        System.out.println("hyejin");
    } // 이렇게 다른 메서드가 존재한다고 해도 추상메서드가 1개면 함수형 인터페이스이다!

}
