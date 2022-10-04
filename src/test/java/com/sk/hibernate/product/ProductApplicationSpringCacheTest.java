package com.sk.hibernate.product;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(args = "--spring.profiles.active=int")
@Sql(scripts = { "/db/data/product-int.sql" })
public class ProductApplicationSpringCacheTest {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void springCache_test() {
		productRepository.findByIdIn(Arrays.asList(1, 2)); // fetch from db and result is cached
		productRepository.findByIdIn(Arrays.asList(1, 2)); // fetch from spring cache
	}

	/**
	 * Unless - Cache is implemented based on the result of the method execution,
	 * vetoed every records satisfy the condition
	 */
	@Test
	public void springCache_unless_FetchFromCache_onSecondCall_test() {
		// @Cacheable(value = "findByName", unless = "#result.name != 'RealMe'")
		// Result is cache, since records are returned
		productRepository.findByName("RealMe"); // fetch from db and result is cached
		productRepository.findByName("RealMe"); // fetch from spring cache
	}

	@Test
	public void springCache_unless_FetchFromDb_onSecondCall_test() {
		// @Cacheable(value = "findByName", unless = "#result.name != 'RealMe'")
		// Result is not cached, since results other than RealMe are vetoed
		productRepository.findByName("Calculator"); // fetch from db and result is not cached
		productRepository.findByName("Calculator"); // fetch from db
	}

	/**
	 * condition - Cache is implemented based on the input argument to the method
	 * execution, stores every records satisfy the condition
	 */
	@Test
	public void springCache_condition_FetchFromCache_onSecondCall_test() {
		// @Cacheable(value = "findByPrice", condition = "#price<6")
		productRepository.findByPrice(5); // fetch from db and result is cached
		productRepository.findByPrice(5); // fetch from cache
	}

	@Test
	public void springCache_condition_FetchFromDb_onSecondCall_test() {
		// @Cacheable(value = "findByPrice", condition = "#price<6")
		// Result is not cached, since results other than price >= 6 are vetoed(not
		// cache)
		productRepository.findByPrice(15999); // fetch from db and result is not cached
		productRepository.findByPrice(15999); // fetch from db
	}

}
