package com.sk.hibernate.payment;

import org.springframework.data.repository.CrudRepository;

import com.sk.hibernate.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
