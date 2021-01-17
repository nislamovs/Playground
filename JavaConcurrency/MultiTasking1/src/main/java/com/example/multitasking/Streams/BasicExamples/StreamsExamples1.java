package com.example.multitasking.Streams.BasicExamples;

import java.util.Arrays;
import java.util.List;

public class StreamsExamples1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        System.out.println("Data : " + integers);
        Integer result = integers.stream().reduce(0, (a, b) -> (a + b));
        System.out.println("Result : " + result);
    }
}
