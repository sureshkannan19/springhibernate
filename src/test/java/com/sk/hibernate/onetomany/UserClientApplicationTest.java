package com.sk.hibernate.onetomany;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(args = "--spring.profiles.active=int")
@Sql(scripts = {"/db/data/userClient.sql"})
public class UserClientApplicationTest {

	@Autowired
	UserClientRepository repository;

	@Test
	public void createClient() {

		UserClient userClient = new UserClient();
		userClient.setClientName("JonSnow");

		PhoneNumber phoneNumber = new PhoneNumber(userClient);
		phoneNumber.setNumber(987654321);
		phoneNumber.setType("Mobile");

		userClient.addPhoneNumber(phoneNumber);

		repository.save(userClient);
	}
	
	@Test
	@Transactional
	public void fetchClient() {
		UserClient userClient = repository.findById(1).get();
		System.out.println("Fetched Client");
		Set<PhoneNumber> phoneNumbers = userClient.getPhoneNumbers();
		if (!phoneNumbers.isEmpty()) {
			System.out.println("Data present.");
		}
	}
}

