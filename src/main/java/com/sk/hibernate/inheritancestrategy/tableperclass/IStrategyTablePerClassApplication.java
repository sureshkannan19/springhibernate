package com.sk.hibernate.inheritancestrategy.tableperclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.sk.hibernate.entity")
public class IStrategyTablePerClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(IStrategyTablePerClassApplication.class, args);
	}
}
