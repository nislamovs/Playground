package com.example.multitasking.multithreadingBasics.Executors;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorCallable {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable = () -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Current time is: " + LocalDateTime.now();
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> taskList = Arrays.asList(callable, callable);

        System.out.println("First example using invokeAll()");
        List<Future<String>> results = executor.invokeAll(taskList);            //blocking

        for (Future<String> result: results) {
            System.out.println(result.get());
        }

        System.out.println("Executing callable using submit");
        Future<String> result = executor.submit(callable);                      //non blocking
        while(!result.isDone()) {
            System.out.println("The method return value is : " + result.get());
        }

        executor.shutdown();

    }

}
