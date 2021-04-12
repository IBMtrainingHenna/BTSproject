package com.ibm.bugBts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class BugApplication {
	public static void main(String[] args) {
		SpringApplication.run(BugApplication.class, args);
	}

}
