package com.sk.hibernate.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.hibernate.entity.Product;

@Service
public class TransactionService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void testSave() {
		Product product = productRepository.findById(1).get(); // fetch from db and result is cached

		String expectedDesc = "To solve problems";
		String actualDesc = product.getDescription();

		System.out.println("Before Save : " + expectedDesc.equals(actualDesc)); // True
		product.setDescription("Edited");

		productRepository.save(product);

		Product result = productRepository.findById(1).get();
		expectedDesc = "Edited";
		actualDesc = result.getDescription();

		System.out.println("After Save : " + expectedDesc.equals(actualDesc)); // True
	
	}

	@Transactional
	public void testSaveAndFlush() {
		Product product = productRepository.findById(1).get(); // fetch from db and result is cached

		String expectedDesc = "To solve problems";
		String actualDesc = product.getDescription();

		System.out.println("Before Save : " + expectedDesc.equals(actualDesc)); // True
		product.setDescription("Edited");

		productRepository.saveAndFlush(product);

		Product result = productRepository.findById(1).get();
		expectedDesc = "Edited";
		actualDesc = result.getDescription();

		System.out.println("After Save : " + expectedDesc.equals(actualDesc)); // True
		
		/**
		 * Hibernate: select product0_.product_id as product_1_2_0_,
		 * product0_.description as descript2_2_0_, product0_.name as name3_2_0_,
		 * product0_.price as price4_2_0_ from product product0_ where
		 * product0_.product_id=?
		 * 
		 * Before Save : true 
		 *  
		 * Hibernate: update product set description=?, name=?, price=? where
		 * product_id=?
		 * 
		 * After Save : true
		 */

	}
}
