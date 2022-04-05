package com.myJava.practice;

public class Foo2 {

    public static void main(String[] args) {

        RunSomething2 runSomething1 = (number) -> number + 1;

        System.out.println(runSomething1.doIt(10));


        // 상태값을 가지고 있기 때문에 순수함수라고 보기 어렵다.
        int baseNumber = 10;
        RunSomething2 runSomething2 = new RunSomething2() {
            @Override
            public int doIt(int num) {
                return num + baseNumber;
            }
        };

//        baseNumber ++; ERROR! 함수밖의 값을 참조하면 이를 변경하려고 하면 안된다!
    }
}
