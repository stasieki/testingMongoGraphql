package com.example.testingMongoGraphql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingMongoGraphqlApplication  { //implements CommandLineRunner

	public static void main(String[] args) {
		SpringApplication.run(TestingMongoGraphqlApplication.class, args);
		System.out.println("Hello!");
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Hello2");
//	}
}
