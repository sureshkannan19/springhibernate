package com.sk.hibernate.onetomany;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Configuration
public class TransactionService {

	public void doSomething() {
		doSomething3();
	}

	@Transactional
	public void doSomething2() {
		doSomething3();
	}

	@Transactional
	public void doSomething3() {
		TransactionStatus status = null;
		try {
			status = TransactionAspectSupport.currentTransactionStatus();
		} catch (NoTransactionException e) {
			System.err.println(e);
		}
		System.out.println(status != null ? "active transaction" : "no transaction");

	}
}
