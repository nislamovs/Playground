package com.example.multitasking.LambdaExpressions.functionalInterface;


public class ConcatenateTraditional implements ConcatenateInterface {

    @Override
    public String concatenate(String s1, String s2) {
        return s1+s2;
    }

    public static void main(String[] args) {
        ConcatenateTraditional concatenateTraditional = new ConcatenateTraditional();
        System.out.println(concatenateTraditional.concatenate("Hello", "world!"));
    }
}
