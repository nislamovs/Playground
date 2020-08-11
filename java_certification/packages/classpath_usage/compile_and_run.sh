#!/usr/bin/env bash

mkdir -p build

#Compile
javac -d build ./libFolder1/com/example/transport/Truck.java
javac -d build ./libFolder2/com/example/util/VINFormatter.java
javac -classpath "./libFolder1:./libFolder2" -d build ./com/example/inventory/InventoryManager.java


#Run
java -cp "./build" com.example.inventory.InventoryManager


