package com.sk.hibernate.onetoone;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
@Sql("/db/data/license.sql")
public class NamedAndNativeQueryExecutionTest {

	@Autowired
	LicenseRepository licenseRepository;

	@Test
	public void test_namedQueryExecution() {

		List<License> result = licenseRepository.getByType("Car");
		result.forEach(System.out::println);
	}

	@Test
	public void test_nativeQueryExecution() {
		LocalDate validFrom = LocalDate.of(2022, 1, 1);
		List<License> result = licenseRepository.getByValidFrom(Date.valueOf(validFrom));
		result.forEach(System.out::println);
	}
}
