package com.sk.hibernate.product;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.sk.hibernate.entity.Product;
import com.sk.hibernate.product.dao.ProductRepository;

/**
 * Disabled SecondLevelCache
 */
@SpringBootTest(args = "--spring.jpa.properties.hibernate.cache.use_second_level_cache=false")
@ActiveProfiles("dev")
public class ProductApplicationFirstLevelCacheTest {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}

	/**
	 * Enable/Add --> spring.jpa.show-sql=true, to witness the working of
	 * FirstLevelCache. In logs, below SQL is printed only once, since SQL executed
	 * only once.
	 *
	 * Eg : Hibernate: select product0_.product_id as product_1_1_0_,
	 * product0_.description as descript2_1_0_, product0_.name as name3_1_0_,
	 * product0_.price as price4_1_0_ from product product0_ where
	 * product0_.product_id=?
	 * 
	 * Note: By commenting @Transactional, execute the test method, inorder to fetch
	 * from db instead of cache at the second time.
	 */
	@Test
	@Transactional // Without @Transactional FirstLevelCache will not work.
	public void firstLevelCache_test() {
		productRepository.findById(1); // fetch from db and result is cached
		productRepository.findById(1); // check in cache, if present fetch from cache else fetch from db
	}

	/**
	 * After evicting the session, in cache data is not present hence fetch from db
	 */
	@Test
	@Transactional
	public void firstLevelCache_sessionEvict_test() {
		Session session = entityManager.unwrap(Session.class);
		Product product = productRepository.findById(1).get(); // fetch from db and result is cached
		session.evict(product);
		productRepository.findById(1); // fetch from db
	}
}
