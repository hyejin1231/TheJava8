package com.myJava.practice.CompletableFuture;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * CompletableFuture
 */
public class App6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.complete("hyejin");
//
//        String s = future.get();
//        System.out.println("s = " + s);

        // runAsync -> 리턴타입이 없는 경우
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());

        });

        // supplyAsync -> 리턴값이 있는 경우
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> { // 리턴값을 받아서 다른 값으로 바꾸는 콜백
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        }); // 전에는 get 호출전에 이렇게 콜백을 할 수 없었는데 CompletableFuture에서는 가능!

        future1.get();

        // thenAccept : 리턴값을 또 다른 작업을 처리하는 콜백 (리턴없이)
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello2";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        future2.get();

        // thenRun(Runnable) : 리턴값 받지 다른 작업을 처리하는 콜백
        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello2";
        }).thenRun(() -> System.out.println(Thread.currentThread().getName()));

        future3.get();
    }


}
