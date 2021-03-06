package com.alem.palindrome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Alemberhan Getahun
 *
 */

@SpringBootApplication
public class SpringBootRestPalindromeApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootRestPalindromeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestPalindromeApplication.class, args);
	}
}
