package com.example.multitasking.LambdaExpressions.helloworld;

public class HelloWorldLambda {
    public static void main(String[] args) {
        //implementing sayHelloWorld Using Lambda

        //Also working version
//        HelloWorldInterface helloWorldInterface = () -> {
//            return "Hello World";
//        }

        HelloWorldInterface helloWorldInterface = () -> "Hello World";


        System.out.println(helloWorldInterface.sayHelloWorld());
    }
}
