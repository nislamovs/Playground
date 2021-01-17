package com.example.multitasking.Streams.ParallelStreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamPerformanceExample {

    public static void main(String[] args) {

        int loop = 20;
        long result = measurePerformance(StreamPerformanceExample::sumSequentialStream, loop);
        System.out.println("Time taken to process sum in sequential: " + result + " [msecs]");
        result = measurePerformance(StreamPerformanceExample::sumSequentialStream, loop);
        System.out.println("Time taken to process sum in parallel: " + result + " [msecs]");
    }

    public static long measurePerformance(Supplier<Integer> supplier, int numberOfTimes) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfTimes; i++) {
            supplier.get();
        }

        return System.currentTimeMillis() - startTime;
    }

    public static int sumParallellStream() {
        return IntStream.rangeClosed(0, 50000).sum();
    }

    public static int sumSequentialStream() {
        return IntStream.rangeClosed(0, 50000).parallel().sum();
    }
}
