package com.myJava.practice.ch1;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

// 람다 표현식
public class Foo3 {

    public static void main(String[] args) {
        Foo3 foo3 = new Foo3();
        foo3.run();
    }

    private void run() {
        final int baseNumber = 10; // final 키워드 생략 가능 ( 이 변수가 사실상 final인 경우에는 생략 가능하다.)
        // baseNumber ++; ERROR! (사실상 final이라 변수를 변경 못함)

        // 로컬함수
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println("baseNumber = " + baseNumber); // result 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11;
                System.out.println("baseNumber = " + baseNumber); // result 11
            }
        };

        /**
         * 로컬 함수, 익명 클래스 vs 람다 함수
         * -> 쉐도잉 이슈
         * 로컬 함수 ,익명 클래스 -> 함수 내 scope
         * 람다 함수 -> run()과 같은 scope
         */


        // 람다 함수
        // IntConsumer -> Consumer<Integer>
        IntConsumer printInt = (i) -> System.out.println("i + baseNumber = " + (i + baseNumber)); // 람다에서 local variable 변수 참조하고 있음

        printInt.accept(20);
    }
}
