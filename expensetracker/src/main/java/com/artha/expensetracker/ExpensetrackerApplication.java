package com.artha.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpensetrackerApplication {

	public static void main(String[] args) {
		System.out.println("DB URL: " + System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/" + System.getenv("DB_NAME"));
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}

}
