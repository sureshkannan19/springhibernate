package com.sk.hibernate.onetoone;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("--spring.profiles.active=int")
public class LicenseApplicationTest {

	@Autowired
	LicenseRepository licenseRepository;

	@Test
	public void testOnetoOne() {
		LocalDate current = LocalDate.now();
		License license = new License();
		license.setType("Car");
		license.setValidFrom(Date.valueOf(current));
		license.setValidTo(Date.valueOf(current.plusYears(2)));

		Person person = new Person();
		person.setFirstName("S");
		person.setLastName("K");
		person.setAge(24);

		license.setPerson(person);

		licenseRepository.save(license);
	}
}
