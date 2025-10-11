package com.springboot.prep.prep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "base")
public class SpPrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpPrepApplication.class, args);
	}

}
