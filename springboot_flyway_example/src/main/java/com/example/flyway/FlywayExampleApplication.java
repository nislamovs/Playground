package com.example.flyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FlywayExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayExampleApplication.class, args);
    }

}
