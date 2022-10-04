package com.sk.hibernate.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(args = { "--spring.jpa.properties.hibernate.cache.use_second_level_cache=false",
		"--spring.profiles.active=int" })
@Sql(scripts = { "/db/data/product-int.sql" })
public class ProductApplicationTransactionServiceTest {

	@Autowired
	TransactionService transactionService;
	
	@Test
	public void testSave() {
		// Order of SQL's executed :
		/**
		 * SQL 1 : Hibernate: select product0_.product_id as product_1_2_0_,
		 * product0_.description as descript2_2_0_, product0_.name as name3_2_0_,
		 * product0_.price as price4_2_0_ from product product0_ where
		 * product0_.product_id=?
		 * 
		 * SQL 2 : Before Save : true 
		 * SQL 3 : After Save : true
		 * 
		 * SQL 4 : Hibernate: update product set description=?, name=?, price=? where
		 * product_id=?
		 */

		transactionService.testSave();
		
		// Points to Note:
		/**
		 * Save - will commit data to db at the end of the transaction, for performance reason
		 * Entity Update - while save method is called, entity is updated in first level cache instead of db.
		 * commit in db- at the end of method call, data is updated in db 
		 */
	}

	@Test
	public void testSaveAndFlush() {
		
		// Order of SQL's executed :

		/**
		 * SQL 1 : Hibernate: select product0_.product_id as product_1_2_0_,
		 * product0_.description as descript2_2_0_, product0_.name as name3_2_0_,
		 * product0_.price as price4_2_0_ from product product0_ where
		 * product0_.product_id=?
		 * 
		 * SQL 2 : Before Save : true 
		 * SQL 3 : Hibernate: update product set description=?, name=?, price=? where
		 * product_id=?
		 * 
		 * SQL 4 : After Save : true
		 */

		// Points to Note:
		/**
		 * Save - will flush(not committed yet) data to db and update in first level cache right away
		 * Entity Update - while save method is called, entity is updated in
		 * first level cache and in db. 
		 * commit in db- at the end of method call, data is updated in db
		 */
		transactionService.testSaveAndFlush();
	}

}
