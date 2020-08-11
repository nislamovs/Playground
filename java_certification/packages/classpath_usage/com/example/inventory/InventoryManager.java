package com.example.inventory;


import com.example.transport.Truck;
import com.example.util.VINFormatter;

public class InventoryManager {
    private static Truck truck;
    private static VINFormatter formatter;

    static {
        truck = new Truck();
        formatter = new VINFormatter();
    }

    // ... more code
    public static void main(String[] args) {

        System.out.println(truck.asString());
        System.out.println(formatter.asString());
    }
}