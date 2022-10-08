package com.sk.hibernate.componentmapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
public class CustomerApplicationTest {

	@Autowired
	CustomerRepository repository;

	@Test
	public void createCustomer() {
		Customer customer = new Customer();
		Address address = new Address();
		address.setCity("Chennai");
		address.setCountry("India");
		address.setState("Tamil Nadu");
		address.setZipCode("600015");
		address.setStreetAddress("SK");
		
		customer.setAddress(address);
		customer.setName("JonSnow");
		repository.save(customer);

		Customer actual = repository.findById(customer.getId()).get();
		assertEquals(customer, actual);
	}
}
