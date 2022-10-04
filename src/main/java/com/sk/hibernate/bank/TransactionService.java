package com.sk.hibernate.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.hibernate.entity.BankAccount;

@Service
public class TransactionService {

	@Autowired
	private BankJpaRepository bankJpaRepository;

	@Transactional
	public void testSave() {
		BankAccount bankAccount = bankJpaRepository.findById(1).get(); // fetch from db and result is cached

		String expectedFName = "pinkman";
		String actualFName = bankAccount.getFirstName();

		System.out.println("Before Save : " + expectedFName.equals(actualFName)); // True
		bankAccount.setFirstName("Jackson");

		bankJpaRepository.save(bankAccount);

		BankAccount result = bankJpaRepository.findById(1).get();
		expectedFName = "Jackson";
		actualFName = result.getFirstName();

		System.out.println("After Save : " + expectedFName.equals(actualFName)); // True
	}

	@Transactional
	public void testSaveAndFlush() {
		BankAccount bankAccount = bankJpaRepository.findById(1).get(); // fetch from db and result is cached

		String expectedFName = "pinkman";
		String actualFName = bankAccount.getFirstName();

		System.out.println("Before Save : " + expectedFName.equals(actualFName)); // True
		bankAccount.setFirstName("Jackson");

		bankJpaRepository.saveAndFlush(bankAccount);

		BankAccount result = bankJpaRepository.findById(1).get();
		expectedFName = "Jackson";
		actualFName = result.getFirstName();

		System.out.println("After Save : " + expectedFName.equals(actualFName)); // True
	}
}
