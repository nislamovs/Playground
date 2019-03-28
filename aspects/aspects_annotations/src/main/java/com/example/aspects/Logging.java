package com.example.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Pointcut("execution(* com.example.aspects.*.*(..))")
    public void selectAllMethodsAvaliable() {

    }

    @Before("selectAllMethodsAvaliable()")
    public void beforeAdvice() {
        System.out.println("Now we are going to initiate developer's profile.");
    }

    @After("selectAllMethodsAvaliable()")
    public void afterAdvice() {
        System.out.println("Developer's profile has been initiated.");
    }

    @AfterReturning(pointcut = "selectAllMethodsAvaliable()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        System.out.println("Value: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "selectAllMethodsAvaliable()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        System.out.println("We have an exception here: " + e.toString());
    }

}
