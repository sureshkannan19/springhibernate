package com.sk.hibernate.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sk.hibernate.annotation.SpringBootTestByProfile;
import com.sk.hibernate.entity.Product;

@SpringBootTestByProfile
public class ProductApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void createProduct() {
		Product product = new Product(1, "RealMe", "Mobile", 15999d);
		productRepository.save(product);

		Product actual = productRepository.findById(1).get();
		assertEquals(product, actual);
	}

	@Test
	public void findByDescription_Test() {
		Product product = new Product(1, "RealMe", "Mobile", 15999d);
		productRepository.save(product);

		Product actual = productRepository.findByDescription("Mobile").get(0);
		assertEquals(product, actual);
	}

	@Test
	public void findByNameAndDescription_Test() {
		Product product = new Product(1, "RealMe", "Mobile", 15999d);
		productRepository.save(product);

		List<Product> result = productRepository.findByNameAndDescription("RealMe", "Mobile");
		Product actual = result.get(0);
		assertEquals(product, actual);

		result = productRepository.findByNameAndDescription("OnePlus", "Mobile");
		assertTrue(result.isEmpty()); // No record is present with OnePlus as name
	}
}
