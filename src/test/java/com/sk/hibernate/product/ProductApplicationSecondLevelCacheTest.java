package com.sk.hibernate.product;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.sk.hibernate.entity.Product;

@SpringBootTest(args = "--spring.profiles.active=int" )
@Sql(scripts = { "/db/data/product-int.sql" })
public class ProductApplicationSecondLevelCacheTest {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EntityManager entityManager;

	/**
	 * Even after evicting cache from session, using SecondLevelCache data is
	 * fetched from cache instead of db and updated the FirstLevelCache
	 */
	@Test
	@Transactional
	public void secondLevelCache_test() {
		Session session = entityManager.unwrap(Session.class);
		Product product = productRepository.findById(1).get(); // fetch from db and result is cached
		session.evict(product);
		productRepository.findById(1); // fetch from cache
	}

	/**
	 * Explored ehcache.xml 
	 */
	@Test
	@Transactional
	public void secondLevelCache_timeToIdleSeconds_test() {
		// Fetched and evicted from Cache and timeToIdleSeconds is set as X (i.e 5) seconds, 
		// so after 5 seconds cache will be cleared 
		// and data is fetched from DB instead of Cache
		Session session = entityManager.unwrap(Session.class);
		Product product = productRepository.findById(1).get(); // fetch from db and result is cached
		session.evict(product); // result is evicted
		try {
			Thread.currentThread().sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			productRepository.findById(1); // fetch from DB
		}
	}
	
}
