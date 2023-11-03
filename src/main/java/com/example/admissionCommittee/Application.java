package com.example.admissionCommittee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.admissionCommittee")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
