package com.example.multitasking.concurrentUtilities.BlockingQueue;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

public class DelayQueueExample {

    static int taskCount;

    public static void main(String[] args) {

        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();

        Runnable producer = () -> {
            while (true) {
                long delayTime = new Random().nextInt(10000);
                //
                Date expirationTime = new Date(System.currentTimeMillis() + delayTime);
                String taskName = "Task " + taskCount++;
                delayQueue.put(new DelayTask(taskName, delayTime));
                System.out.println("Producing task : " + taskName + " with expiration time of : " + expirationTime);
                try {
                    TimeUnit.MILLISECONDS.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                DelayTask poll;
                try {
                    poll = delayQueue.take();
                    System.out.println("Consumed task: " + poll.getName() + " with expiration of: " + new Date(poll.getDelayTime()));
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(consumer);
        executorService.submit(producer);

        executorService.shutdown();
    }
}

@Getter
@Setter
class DelayTask implements Delayed {

    private String name;
    private long delayTime;

    public DelayTask (String name, long delayTime) {
        this.name = name;
        this.delayTime = System.currentTimeMillis() + delayTime;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long difference = delayTime - System.currentTimeMillis();
        return timeUnit.convert(difference, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        if (this.delayTime < ((DelayTask)delayed).delayTime)
            return -1;
        if (this.delayTime > ((DelayTask)delayed).delayTime)
            return 1;

        return 0;
    }
}
