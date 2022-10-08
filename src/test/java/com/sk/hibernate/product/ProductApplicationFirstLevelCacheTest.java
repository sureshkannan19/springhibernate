package com.sk.hibernate.product;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.sk.hibernate.entity.Product;

/**
 * Note: 
 * 1. Without @Transactional FirstLevelCache will not work, since the cache works at session level only.
 * 2. Disabled SecondLevelCache inorder to witness the FirstLevelCache working.
 * 3. Enable/Add --> spring.jpa.show-sql=true, to witness the working of FirstLevelCache, check
 * the logs(Hint : Check the number of times SQL query is printed) in
 * console.
 * 
 */
@SpringBootTest(args = { "--spring.profiles.active=int",
		"--spring.jpa.properties.hibernate.cache.use_second_level_cache=false" })
@Sql(scripts = { "/db/data/product-int.sql" })
public class ProductApplicationFirstLevelCacheTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EntityManager entityManager;

	@Test
	@Transactional // Without @Transactional FirstLevelCache will not work.
	public void test_firstLevelCache() {
		productRepository.findById(1); // fetch from db and result is cached
		productRepository.findById(1); // check in cache, if present fetch from cache else fetch from db
	}

	/**
	 * After evicting the session, in cache data is not present hence fetch from db
	 * Query exeucted twice 
	 */
	@Test
	@Transactional
	public void test_firstLevelCacheBy_EvictingTheCachedData_FromSession() {
		Session session = entityManager.unwrap(Session.class);
		Product product = productRepository.findById(1).get(); // fetch from db and result is cached
		session.evict(product);
		productRepository.findById(1); // fetch from db
	}
	
}
