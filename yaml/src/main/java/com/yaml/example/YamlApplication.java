package com.yaml.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class YamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(YamlApplication.class, args);

		ProcessYaml.presetBookDataCollection();
	}

}
