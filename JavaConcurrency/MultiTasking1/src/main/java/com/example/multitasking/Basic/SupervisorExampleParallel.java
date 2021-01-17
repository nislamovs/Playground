package com.example.multitasking.Basic;

//Parallel processing example

import lombok.SneakyThrows;

public class SupervisorExampleParallel {

    public static void main(String[] args) {
        ParallelWorker1 worker1 = new ParallelWorker1();
        ParallelWorker2 worker2 = new ParallelWorker2();

        worker1.start();
        worker2.start();
    }

}

class ParallelWorker1 extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            Thread.sleep(100);
            System.out.println("Worker 1 is executing task#" + i);
        }
    }
}

class ParallelWorker2 extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            Thread.sleep(100);
            System.out.println ("Worker 2 is executing task#" + i);
        }
    }
}
