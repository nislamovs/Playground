package com.example.multitasking.concurrentUtilities.CountDownLatch;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SumOfNumbersUsingLatch {
    public static int[] array = IntStream.rangeClosed(0, 5000).toArray();
    final static int total = IntStream.rangeClosed(0, 5000).sum();
    final static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable1 = () -> {
           int sum = 0;
            for (int i = 0; i < array.length/2; i++) {
                sum = sum + array[i];
            }
            countDownLatch.countDown();
            return sum;
        };

        Callable callable2 = () -> {
            int sum = 0;
            for (int i = array.length/2; i < array.length; i++) {
                sum = sum + array[i];
            }
            countDownLatch.countDown();

            return sum;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> sum1 = executorService.submit(callable1);
        Future<Integer> sum2 = executorService.submit(callable2);

        System.out.println("Count down latch count before calling await: " + countDownLatch.getCount());
        countDownLatch.await();     //wait till latch will count down to zero
        System.out.println("Count down latch count after calling await: " + countDownLatch.getCount());

        int sum = sum1.get() + sum2.get();
        System.out.println("Sum from the thread is: " + sum);
        System.out.println("Correct sum is: " + total);
    }
}
