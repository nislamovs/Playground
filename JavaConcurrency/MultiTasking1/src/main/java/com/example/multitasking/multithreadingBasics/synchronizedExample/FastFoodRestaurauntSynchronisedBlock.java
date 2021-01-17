package com.example.multitasking.multithreadingBasics.synchronizedExample;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter @Setter
public class FastFoodRestaurauntSynchronisedBlock {

    private String lastClientName;
    private int numberOfBurgersSold;

    public void buyBurger(String clientName) {
        alongRunningProcess();
        System.out.println(clientName + " bought a burger");
        synchronized (this) {
            this.lastClientName = clientName;
            numberOfBurgersSold++;
        }
    }

    public void alongRunningProcess() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FastFoodRestaurauntSynchronisedBlock fastFoodRestauraunt = new FastFoodRestaurauntSynchronisedBlock();

        Thread t1 = new Thread(() -> {
           fastFoodRestauraunt.buyBurger("Mike [1]");
        });

        Thread t2 = new Thread(() -> {
            fastFoodRestauraunt.buyBurger("Elise [2]");
        });

        Thread t3 = new Thread(() -> {
            fastFoodRestauraunt.buyBurger("Jane [3]");
        });

        Thread t4 = new Thread(() -> {
            fastFoodRestauraunt.buyBurger("Robert [4]");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Total number of burgers sold: " + fastFoodRestauraunt.getNumberOfBurgersSold());
        System.out.println("The last name of client is: " + fastFoodRestauraunt.getLastClientName());
        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + " in msec");
    }
}
