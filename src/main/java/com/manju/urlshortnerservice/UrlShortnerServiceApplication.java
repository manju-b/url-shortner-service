package com.manju.urlshortnerservice;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrlShortnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortnerServiceApplication.class, args);
		
		
	}
	
	@Bean
	public UrlValidator getURLValidator() {
		return new UrlValidator();
	}
}
