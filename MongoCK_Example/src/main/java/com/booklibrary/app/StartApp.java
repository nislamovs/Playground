package com.booklibrary.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@SpringBootApplication
public class StartApp {

	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	}

}
