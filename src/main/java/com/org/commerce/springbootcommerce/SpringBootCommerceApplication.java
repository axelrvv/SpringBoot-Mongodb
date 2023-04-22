package com.org.commerce.springbootcommerce;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class SpringBootCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCommerceApplication.class, args);
	}

}
