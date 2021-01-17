package com.example.multitasking.Streams.NumericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MathOperationsExample {

    public static void main(String[] args) {
        System.out.println("------------------------------------------");
// sum
        int sum = IntStream.rangeClosed(0, 1000).sum();
        System.out.println("Sum of 1000 numbers: " +  sum);

        System.out.println("------------------------------------------");
// max
        OptionalInt max = IntStream.rangeClosed(0, 1000).max();
        System.out.println("Max number of 1000 numbers: " +  max);

        System.out.println("------------------------------------------");
// min
        OptionalInt min = IntStream.rangeClosed(0, 1000).min();
        System.out.println("Min number of 1000 numbers: " +  min);

        System.out.println("------------------------------------------");
// avg
        OptionalDouble average = LongStream.rangeClosed(0, 1000).asDoubleStream().average();
        System.out.println("Average number of 1000 numbers: " +  (average.isPresent() ? average.getAsDouble() : 0.0));

        System.out.println("------------------------------------------");
    }
}
