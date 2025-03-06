package com.example.contact_records_keeping_app.contact_records_keeping_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactRecordsKeepingAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContactRecordsKeepingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application running on port 8081");
	}

}
