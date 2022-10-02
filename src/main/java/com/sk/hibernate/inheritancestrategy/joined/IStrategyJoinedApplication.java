package com.sk.hibernate.inheritancestrategy.joined;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.sk.hibernate.entity")
public class IStrategyJoinedApplication {

	public static void main(String[] args) {
		SpringApplication.run(IStrategyJoinedApplication.class, args);
	}

}
