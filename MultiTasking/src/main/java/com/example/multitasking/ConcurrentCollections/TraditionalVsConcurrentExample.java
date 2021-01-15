package com.example.multitasking.ConcurrentCollections;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class TraditionalVsConcurrentExample {

    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        concurrentModificationArrayList();
    }

    public static void concurrentModificationArrayList() throws BrokenBarrierException, InterruptedException {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 100000; i++) {
            list.add(i);
        }

        new Thread (() -> {
            //Commenting this try/catch raises ConcurrentModificationException (if cyclic barrier will be datached)
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            ////////////////////////////////////////////////////////////////////
            try {
                System.out.println("Adding 5000 to the list");
                cyclicBarrier.await();
                list.add(5000);
            } catch (ConcurrentModificationException | InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        Iterator<Integer> it = list.iterator();
        boolean flag = false;
        while(it.hasNext()) {
            it.next();
            if (!flag) {
                cyclicBarrier.await();
                flag = true;
            }
        }

    }
}
