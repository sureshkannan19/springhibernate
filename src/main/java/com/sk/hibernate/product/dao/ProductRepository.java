package com.sk.hibernate.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.hibernate.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByDescription(String desc);

	List<Product> findByNameAndDescription(String name, String desc);
}
