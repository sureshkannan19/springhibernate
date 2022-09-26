package com.sk.hibernate.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.sk.hibernate.product.ProductApplication;

@SpringBootApplication
@EntityScan("com.sk.hibernate.entity")
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
