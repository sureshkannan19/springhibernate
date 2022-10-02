package com.sk.hibernate.payment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sk.hibernate.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	@Query(value = "Select p.P_MODE from Payment p where p.id = :id", nativeQuery = true)
	String findPModeById(@Param("id") int id);
}
