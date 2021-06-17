package com.example.stats.services;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfigService {

    private final NumberRegister numberRegister;

    @Timed(description = "TPS measurement point [service #1]", value = "example.tps.service1", extraTags = {"tps", "service1"})
    public void launch() {
        System.out.println("service #1 launched!");
    }

    @Counted(description = "requests", value = "requests")
    public void launch2() {
        System.out.println("service #2 launched!");
    }


    public void checkNumber(int number) {

        numberRegister.registerNumber(number);
        if (number % 2 == 0) {
            numberRegister.registerEven(number);
        } else {
            numberRegister.registerOdd(number);
        }
    }

//    this shit works only if it is placed in separate spring component

//    @Counted(description = "processed numbers total count", value = "processed-numbers")
//    private void registerNumber(int number) {
//        System.out.println("Number : " + number + " is registered");
//        return;
//    }
//
//    @Counted(description = "even number total count", value = "even-number")
//    private void registerEven(int number) {
//        System.out.println("Number : " + number + " is even");                      //it's better to write here something, because otherwise jvm will optimize method without functionality
//        return;
//    }
//
//    @Counted(description = "odd number total count", value = "odd-number")
//    private void registerOdd(int number) {
//        System.out.println("Number : " + number + " is odd");
//        return;
//    }


}
