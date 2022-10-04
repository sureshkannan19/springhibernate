package com.sk.hibernate.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(args = "--spring.profiles.active=int")
@Sql(scripts = { "/db/data/bank-int.sql" })
public class SaveVsSaveAndFlushOnRollBack {

	@Autowired
	SaveVsSaveAndFlush saveVsSaveAndFlush;

	@Test
	public void testSaveAndFlush_notRollBackedOnException() {
		saveVsSaveAndFlush.testSaveAndFlush_notRollBackedOnException();
	}

	@Test
	public void testSave_rolledBackOnException() {
		saveVsSaveAndFlush.testSave_rolledBackOnException();
	}
}
