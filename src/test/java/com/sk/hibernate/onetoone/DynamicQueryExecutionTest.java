package com.sk.hibernate.onetoone;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest("--spring.profiles.active=int")
@Sql("/db/data/license.sql")
public class DynamicQueryExecutionTest {

	@Autowired
	LicenseRepository licenseRepository;

	@Test
	public void test_dynamicQueryExecution() {

		LocalDate validFrom = LocalDate.of(2022, 1, 1);
		License license = new License();
		license.setType("Car");
		license.setValidFrom(Date.valueOf(validFrom));
		license.setValidTo(Date.valueOf(validFrom.plusYears(8)));

		Person person = new Person();
		person.setId(1);
		license.setPerson(person);

		Specification<License> specification = new Specification<License>() {

			@Override
			public Predicate toPredicate(Root<License> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				Path<Integer> personId = root.get("person").get("id");
				Path<String> type = root.get("type");
				Path<String> validFrom = root.get("validFrom");
				Path<String> validTo = root.get("validTo");

				if (license.getPerson() != null) {
					predicates.add(criteriaBuilder.equal(personId, license.getPerson().getId()));
				}

				if (license.getType() != null) {
					predicates.add(criteriaBuilder.equal(type, license.getType()));
				}

				if (license.getValidFrom() != null) {
					predicates.add(criteriaBuilder.equal(validFrom, license.getValidFrom()));
				}

				if (license.getValidTo() != null) {
					predicates.add(criteriaBuilder.equal(validTo, license.getValidTo()));
				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

		};

		/**
		 * Hibernate: select license0_.id as id1_0_, license0_.person_id as
		 * person_i5_0_, license0_.type as type2_0_, license0_.valid_from as
		 * valid_fr3_0_, license0_.valid_to as valid_to4_0_ from license license0_ 
		 * where
		 * license0_.person_id=1 and license0_.type=? and license0_.valid_from=? and
		 * license0_.valid_to=?
		 *
		 */
		List<License> result = licenseRepository.findAll(specification);
		result.forEach(System.out::println);
	}
}
