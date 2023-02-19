package com.sk.hibernate.onetoone;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.sk.hibernate.annotation.SpringBootTestByProfile;
import com.sk.hibernate.onetoone.LicenseRepository.LicenseMapping;

@SpringBootTestByProfile
@Sql("/db/data/license.sql")
public class NamedAndNativeQueryExecutionTest {

	@Autowired
	LicenseRepository licenseRepository;

	@Autowired
	EntityManagerFactory entityManagerFactory;

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

	@Test
	public void test_Tuple() {
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<Tuple> query = em.createQuery("SELECT e.id, e.type FROM License e", Tuple.class);
		List<Tuple> result = query.getResultList();
//		 Id : 1 Type : Car
		result.forEach(r -> System.out.println(" Id : " + r.get(0) + " Type : " + r.get(1)));
	}
	
	@Test
	public void test_InterfaceProjectionsMapping() {
		Date validTo = Date.valueOf(LocalDate.of(2023, 02, 19));
		List<LicenseMapping> result = licenseRepository.getAllIdAndTypeByValidTo(validTo);
		result.forEach(r -> System.out.println(" Id : " + r.getId() + " Type : " + r.getType()));
	}
	
	@Test
	public void test_SqlResultsetMapping() {
		Date validFrom = Date.valueOf(LocalDate.of(2021, 02, 19));
		List<License> result = licenseRepository.getAllIdAndTypeByValidFrom(validFrom);
		result.forEach(r -> System.out.println(" Id : " + r.getId() + " Type : " + r.getType() + " Valid From : " + r.getValidFrom()));
	}
}
