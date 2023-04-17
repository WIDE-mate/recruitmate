package com.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecruitmateApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecruitmateApplication.class, args);

		System.out.println("http://localhost:8080");
		System.out.println("http://localhost:8080/main");
	}
}
