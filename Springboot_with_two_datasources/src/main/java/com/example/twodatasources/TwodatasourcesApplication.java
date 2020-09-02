package com.example.twodatasources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
public class TwodatasourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwodatasourcesApplication.class, args);
	}

}
