package com.example.multitasking.ForkJoin;


import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ForkJoinSum extends RecursiveAction {

    public static long total = 0;
    private static final int CALCULATE_SUM_THRESHOLD = 5;

    private List<Long> data;

    public ForkJoinSum(List<Long> data) {
        this.data = data;
    }

    @Override
    protected void compute() {
        if (data.size() <= CALCULATE_SUM_THRESHOLD) {
            long sum = computeSumDirectly();
            System.out.println("sum of: " + data.toString() + " is: " + sum);
        } else {
            int mid = data.size()/2;
            ForkJoinSum firstSubTask = new ForkJoinSum(data.subList(0, mid));
            ForkJoinSum secondSubTask = new ForkJoinSum(data.subList(mid, data.size()));

            firstSubTask.fork(); //queuing the first task
            secondSubTask.compute();
            firstSubTask.join();
        }
    }

    private long computeSumDirectly() {
        long sum = 0;
        for (Long value : data) {
            sum = sum + value;
        }
        total = total + sum;
        return sum;
    }

    public static void main(String[] args) {
        int end = 5000;
        List<Long> data = LongStream.rangeClosed(0, end).boxed().collect(Collectors.toList());
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Pool parallelism: " + pool.getParallelism());
        ForkJoinSum task = new ForkJoinSum(data);
        pool.invoke(task);
        System.out.println("Total is : " + total + " and correct sum calculated using stream is : " + LongStream.rangeClosed(0,end).sum());
    }
}
