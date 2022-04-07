package com.myJava.practice.CompletableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Excutors
public class App2 {
    public static void main(String[] args) throws InterruptedException { // main Thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });

        executorService.shutdown(); // 처리중인 작업을 기다렸다가 종료
//        executorService.shutdownNow(); // 당장 종료

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("Hello"));
        executorService1.submit(getRunnable("hyejin"));
        executorService1.submit(getRunnable("The"));
        executorService1.submit(getRunnable("Java"));
        executorService1.submit(getRunnable("Thread"));

        executorService1.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("Hi~~"), 3, TimeUnit.SECONDS);

        ScheduledExecutorService scheduledExecutorService2 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService2.scheduleAtFixedRate(getRunnable("Delay"), 1, 2, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }

}
