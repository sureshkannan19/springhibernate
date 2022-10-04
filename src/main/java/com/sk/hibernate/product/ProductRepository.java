package com.sk.hibernate.product;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sk.hibernate.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByDescription(String desc);

	List<Product> findByNameAndDescription(String name, String desc);
	
	@Cacheable("findByProductIds")
	List<Product> findByIdIn(List<Integer> ids);
	
	@Cacheable(value = "findByName", unless ="#result.name!='RealMe'")
	Product findByName(String name);
	
	@Cacheable(value = "findByPrice", condition = "#price<6")
	Product findByPrice(double price);
	
	@Modifying
	@Query("update Product set  description = :description where id = :productId")
	void updateProduct(@Param("description") String description, @Param("productId") int productId);
}
