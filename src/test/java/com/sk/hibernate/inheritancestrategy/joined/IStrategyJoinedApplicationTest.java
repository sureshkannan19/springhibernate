package com.sk.hibernate.inheritancestrategy.joined;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
public class IStrategyJoinedApplicationTest {

	@Autowired
	IStrategyJoinedRepository repository;

	@Test
	public void test_boyz() {
		Boyz boyz = new Boyz();
		boyz.setName("Jonsnow");
		boyz.setNoOfSubjectsFailed(3);

		repository.save(boyz);

		Student result = repository.findById(boyz.getId()).get();
		assertEquals(result, boyz);
	}

	@Test
	public void test_girlz() {

		Girlz girlz = new Girlz();
		girlz.setName("Danerys");
		girlz.setNoOfSubjectsPassed(5);

		repository.save(girlz);

		Student result = repository.findById(girlz.getId()).get();
		assertEquals(result, girlz);
	}

}
