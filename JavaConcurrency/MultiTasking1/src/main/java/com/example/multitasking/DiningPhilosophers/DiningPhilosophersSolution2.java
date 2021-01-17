package com.example.multitasking.DiningPhilosophers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.currentTimeMillis;

//using synchronised

public class DiningPhilosophersSolution2 {

    public static void main(String[] args) {

        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[5];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[ ( i + 1 ) % forks.length ];
            philosophers[i] = new Philosopher(leftFork, rightFork);
            Thread thread = new Thread(philosophers[i], "Philosohper " + (i+1));
            thread.start();
        }
    }
}

@AllArgsConstructor
class Philosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    @Override
    public void run() {
        while(true) {
            doWork(currentTimeMillis() + " : Thinking");
            synchronized (leftFork){
                doWork(currentTimeMillis() + " : Picked up left fork");
                synchronized (rightFork){
                    doWork(currentTimeMillis() + " : Picked up right fork and eating");
                }
                doWork(currentTimeMillis() + ": Put down right fork");
            }
            doWork(currentTimeMillis() + ": Put down left fork and back to thinking");
        }
    }

    @SneakyThrows
    private void doWork(Object str) {
        System.out.println(Thread.currentThread().getName() + " : " + str.toString());
        Thread.sleep((int) (Math.random() * 100));
    }
}