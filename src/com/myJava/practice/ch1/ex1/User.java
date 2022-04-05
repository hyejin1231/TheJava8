package com.myJava.practice.ch1.ex1;

public class User {
    private String name;

    public User() {

    }
    public User(String name) {
        this.name = name;
    }

    public String printUserName(String name) {
        return "username: " + name;
    }

    public String getName() {
        return name;
    }

    public static String HelloUserName(String name) {
        return "hello: " + name;
    }

}
