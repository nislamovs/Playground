package com.example.stats.services;

import io.micrometer.core.annotation.Counted;
import org.springframework.stereotype.Component;

@Component
public class NumberRegister {

//  public void checkNumber(int number) {
//
//    registerNumber(number);
//    if (number % 2 == 0) {
//      registerEven(number);
//    } else {
//      registerOdd(number);
//    }
//  }

  @Counted(description = "processed numbers total count", value = "processed-numbers")
  public void registerNumber(int number) {
    System.out.println("Number : " + number + " is registered");
    return;
  }

  @Counted(description = "even number total count", value = "even-number")
  public void registerEven(int number) {
    System.out.println("Number : " + number + " is even");                      //it's better to write here something, because otherwise jvm will optimize method without functionality
    return;
  }

  @Counted(description = "odd number total count", value = "odd-number")
  public void registerOdd(int number) {
    System.out.println("Number : " + number + " is odd");
    return;
  }
}
