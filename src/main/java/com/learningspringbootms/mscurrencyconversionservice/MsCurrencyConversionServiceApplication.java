package com.learningspringbootms.mscurrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsCurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCurrencyConversionServiceApplication.class, args);
	}

}
