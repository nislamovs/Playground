package com.example.aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDeveloperRunner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("aop-developer-config.xml");
        Developer developer = (Developer) context.getBean("developer");

        System.out.println(developer);
        developer.throwSomeMysticException();
    }
}
