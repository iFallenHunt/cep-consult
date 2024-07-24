package com.tech.postal_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjectApplication.class, args);
	}
}