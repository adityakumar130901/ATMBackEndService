package com.turvo.teller.atm;

import dbobject.LocalAccountDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) {
	    // Initialize account data.
        LocalAccountDetails.getInstance();
		SpringApplication.run(AtmApplication.class, args);
	}

}
