package com.myJava.practice.ch2;


public class App {
    public static void main(String[] args) {
        GreetingInterface greetingInterface = new DefaultFoo("hyejin");

        greetingInterface.printName();
        greetingInterface.printNameUpperCase();

        GreetingInterface.printAnything();

    }
}
