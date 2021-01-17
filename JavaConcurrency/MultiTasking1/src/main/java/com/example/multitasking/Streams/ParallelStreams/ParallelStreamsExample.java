package com.example.multitasking.Streams.ParallelStreams;

import java.util.stream.IntStream;

public class ParallelStreamsExample {

    public static void main(String[] args) {
        System.out.println("Sum sequential: " + sumSequentialStream());
        System.out.println("Sum parallel: " + sumParallellStream());
    }

    public static int sumParallellStream() {
        return IntStream.rangeClosed(0, 50000).sum();
    }

    public static int sumSequentialStream() {
        return IntStream.rangeClosed(0, 50000).parallel().sum();
    }
}
