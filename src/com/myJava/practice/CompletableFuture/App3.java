package com.myJava.practice.CompletableFuture;

import java.util.concurrent.*;

/**
 * Callable과 Future
 * Callable : Runnable과 유사하지만 작업의 결과를 받을 수 있다.
 * Future :  비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다.
 */
public class App3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException { // main Thread
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!!");

        String s = helloFuture.get();
        System.out.println("s = " + s);

//        helloFuture.cancel(false); cancel 하고 나면 값을 가져올 수 없다.

        System.out.println(helloFuture.isDone());
        System.out.println("End!!");
        executorService.shutdown();
    }


}
