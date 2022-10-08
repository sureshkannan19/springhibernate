package com.sk.hibernate.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
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
