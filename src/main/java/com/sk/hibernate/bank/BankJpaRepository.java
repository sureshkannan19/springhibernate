package com.sk.hibernate.bank;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.hibernate.entity.BankAccount;

public interface BankJpaRepository extends JpaRepository<BankAccount, Integer> {

}
