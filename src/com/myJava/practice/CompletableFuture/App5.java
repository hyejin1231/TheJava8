package com.myJava.practice.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Callable과 Future
 * Callable : Runnable과 유사하지만 작업의 결과를 받을 수 있다.
 * Future :  비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다.
 */
public class App5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException { // main Thread
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 싱글쓰레드면 다른 결과가 출력됨

        Callable<String> hello = () -> {
            Thread.sleep(3000L);
            return "hello";
        };

        Callable<String> java  = () -> {
            Thread.sleep(2000L);
            return "java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000L);
            return "spring";
        };

       // invokeAny ->  동시에 실행한 작업 중에 제일 짧게 걸리는 작업 만큼 시간이 걸린다.
        String s = executorService.invokeAny(Arrays.asList(hello, java, spring));
        System.out.println("s = " + s);

        executorService.shutdown();

    }


}
