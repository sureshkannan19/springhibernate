package com.sk.hibernate.onetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = "--spring.profiles.active=int")
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
}
