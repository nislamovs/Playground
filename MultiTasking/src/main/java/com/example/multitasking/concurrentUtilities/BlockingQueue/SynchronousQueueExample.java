package com.example.multitasking.concurrentUtilities.BlockingQueue;

import java.util.concurrent.*;

public class SynchronousQueueExample {

    public static void main(String[] args) {
        final String[] names = {"Mike", "Joe", "Jeany", "Dmitry", "Alex", "Kate"};
        final SynchronousQueue<String> queue = new SynchronousQueue<>();


        Runnable producer = () -> {
          for(String name: names) {
              try {
                  System.out.println("Put name : " + name);
                  queue.put(name);
                  TimeUnit.MILLISECONDS.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };

        Runnable consumer = () -> {
            while(true) {
                try {
                    System.out.println("Retrieved name : " + queue.take());
                    TimeUnit.MILLISECONDS.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.shutdown();

    }
}
