package com.heaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.heaven")
public class EmpGuidApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpGuidApplication.class, args);
	}

}
