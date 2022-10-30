package com.sk.hibernate.audit;

import javax.persistence.EntityManagerFactory;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
@Sql(scripts = { "/db/data/cricket-int.sql" })
public class CricketMatchApplicationTest {

	@Autowired
	PointsTableRepository pointsTableRepository;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Test
	public void create() {
		PointsTable pointsTable = new PointsTable("INDIA", 2, 5d);
		pointsTableRepository.save(pointsTable);

		AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
		pointsTable = reader.find(PointsTable.class, "INDIA", 1l);

		System.out.println(pointsTable);
	}

	@Test
	public void modify() {
		PointsTable result = pointsTableRepository.findById("INDIA").get();
		result.setPoints(6);
		pointsTableRepository.save(result);

		AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

		PointsTable pointsTable = reader.find(PointsTable.class, "INDIA", 1l);
		System.out.println(pointsTable);
	}
}
