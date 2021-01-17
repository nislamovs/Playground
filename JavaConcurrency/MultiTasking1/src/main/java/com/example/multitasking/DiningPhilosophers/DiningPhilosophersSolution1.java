package com.example.multitasking.DiningPhilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Using reentrantLocks

public class DiningPhilosophersSolution1 {

    static Lock fork1 = new ReentrantLock();
    static Lock fork2 = new ReentrantLock();
    static Lock fork3 = new ReentrantLock();
    static Lock fork4 = new ReentrantLock();
    static Lock fork5 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread (() -> {
            System.out.println("Philosopher 1 is thinking");
            fork2.lock();
            System.out.println("Philosopher 1 picked up left fork");
            fork1.lock();
            System.out.println("Philosopher 1 picked up right fork");
            System.out.println("Philosopher 1 is eating");
            fork1.unlock();
            fork2.unlock();
        }).start();

        new Thread (() -> {
            System.out.println("Philosopher 2 is thinking");
            fork3.lock();
            System.out.println("Philosopher 2 picked up left fork");
            fork2.lock();
            System.out.println("Philosopher 2 picked up right fork");
            System.out.println("Philosopher 2 is eating");
            fork3.unlock();
            fork2.unlock();
        }).start();

        new Thread (() -> {
            System.out.println("Philosopher 3 is thinking");
            fork4.lock();
            System.out.println("Philosopher 3 picked up left fork");
            fork3.lock();
            System.out.println("Philosopher 3 picked up right fork");
            System.out.println("Philosopher 3 is eating");
            fork3.unlock();
            fork4.unlock();
        }).start();

        new Thread (() -> {
            System.out.println("Philosopher 4 is thinking");
            fork5.lock();
            System.out.println("Philosopher 4 picked up left fork");
            fork4.lock();
            System.out.println("Philosopher 4 picked up right fork");
            System.out.println("Philosopher 4 is eating");
            fork5.unlock();
            fork4.unlock();
        }).start();

        new Thread (() -> {
            System.out.println("Philosopher 5 is thinking");
            fork1.lock();
            System.out.println("Philosopher 5 picked up left fork");
            fork5.lock();
            System.out.println("Philosopher 5 picked up right fork");
            System.out.println("Philosopher 5 is eating");
            fork5.unlock();
            fork1.unlock();
        }).start();
    }

}
