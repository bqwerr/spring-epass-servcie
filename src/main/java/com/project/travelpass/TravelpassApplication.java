package com.project.travelpass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync // for async processing
public class TravelpassApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelpassApplication.class, args);
	}

}
