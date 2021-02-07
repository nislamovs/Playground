package com.exectime.measurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MeasurementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeasurementApplication.class, args);
	}

}
