package com.example.multitasking.LambdaExpressions.functionalInterface;


public class ConcatenateLambda {

    public static void main(String[] args) {
        ConcatenateInterface concatenateInterface = (a, b) -> a+b;
        System.out.println(concatenateInterface.concatenate("Hello", "world!"));
    }
}
