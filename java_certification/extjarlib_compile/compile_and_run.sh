#!/usr/bin/env bash


#Compile
javac -cp ".:./jars/commons-lang3-3.11.jar" Test.java

#Run
java -cp ".:./jars/commons-lang3-3.11.jar" Test
