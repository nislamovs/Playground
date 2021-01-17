package com.example.multitasking.LambdaExpressions.runnable;

public class RunnableExample {

    public static void main(String[] args) {
        //Runnable traditional example
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum +=i;
                }
                System.out.println("Traditional : " + sum );
            }
        };
        new Thread(runnable).start();

        //Implement using lambda

        Runnable runnable1 = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum +=i;
            }
            System.out.println("Runnable lambda : " + sum );
        };

        new Thread(runnable1).start();


        //Implement using thread with lambda

        new Thread(() ->{
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum +=i;
            }
            System.out.println("Thread lambda : " + sum );
        }).start();

    }
}
