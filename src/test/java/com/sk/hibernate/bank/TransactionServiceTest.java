package com.sk.hibernate.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(args = "--spring.profiles.active=int" )
@Sql(scripts = { "/db/data/bank-int.sql" })
public class TransactionServiceTest {

	@Autowired
	TransactionService transactionService;
	
	@Test
	public void testSave() {
		// Order of logs printed :
		/**
		 * 1: select bankaccoun0_.acc_num as acc_num1_0_0_, bankaccoun0_.balance
		 * as balance2_0_0_, bankaccoun0_.first_name as first_na3_0_0_,
		 * bankaccoun0_.last_name as last_nam4_0_0_ from bank_account bankaccoun0_ where
		 * bankaccoun0_.acc_num=?
		 * 
		 * 2. Before Save : true
		 * 3. After Save : true
		 * 
		 * 4. update bank_account set balance=?, first_name=?, last_name=? where
		 * acc_num=?
		 * 
		 */

		transactionService.testSave();
		
		// Points to Note:
		/**
		 * Save - will commit data to db at the end of the transaction, for performance reason
		 * Entity Update - while save method is executed, entity is updated in first level cache instead of db.
		 * commit in db - at the end of method execution, data is persisted in db 
		 */
	}

	@Test
	public void testSaveAndFlush() {
		
		// Order of logs printed :
		/**
		 * 1. select bankaccoun0_.acc_num as acc_num1_0_0_, bankaccoun0_.balance
		 * as balance2_0_0_, bankaccoun0_.first_name as first_na3_0_0_,
		 * bankaccoun0_.last_name as last_nam4_0_0_ from bank_account bankaccoun0_ where
		 * bankaccoun0_.acc_num=?
		 * 
		 * 2. Before Save : true
		 * 
		 * 3. update bank_account set balance=?, first_name=?, last_name=? where
		 * acc_num=?
		 * 
		 * 4. After Save : true
		 */

		// Points to Note:
		/**
		 * Save - will flush(not committed yet) data to db and update in first level cache right away
		 * Entity Update - while save method is executed, entity is updated in
		 * first level cache and in db. 
		 * commit in db- at the end of method execution, data is updated in db
		 */
		transactionService.testSaveAndFlush();
	}
	
	@Test
	public void testSaveAndFlush_whenCacheIsEvicted_fetchFromDb_hasLatestChanges() {
		transactionService.testSaveAndFlush_whenCacheEvicted_fetchFromDb_hasLatestChanges();
	}

	@Test
	public void testSave_whenCacheIsEvicted_fetchFromDb_doesNotHaveLatestChanges() {
		transactionService.testSave_whenCacheEvicted_fetchFromDb_doesNotHaveLatestChanges();
	}

}
