package com.myJava.practice.CompletableFuture;

// Concurrent
public class App {
    public static void main(String[] args) throws InterruptedException { // main Thread
        MyThread myThread = new MyThread();
        myThread.start();


        // 2. 쓰레드 만드는 방법 : Runnable 구현
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2: " + Thread.currentThread().getName());
        });
        thread.start();

        // 쓰레드 깨우는 방법
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("thread3 = " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }
        });
        thread1.start();

        Thread.sleep(3000L);
        thread1.interrupt(); // 쓰레드 깨움

        // 쓰레드 기다리기
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread2.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        thread2.join();
        System.out.println(thread2 + " is finished");
    }

    // 1. 쓰레드 만드는 방법 : Thread 상속 받아 작성
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());

        }
    }

}
