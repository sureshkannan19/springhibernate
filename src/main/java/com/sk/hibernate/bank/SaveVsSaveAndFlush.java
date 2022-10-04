package com.sk.hibernate.bank;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.hibernate.entity.BankAccount;

@Service
public class SaveVsSaveAndFlush {

	@Autowired
	private BankJpaRepository bankJpaRepository;
	
	@Autowired
	private EntityManager em;

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
	
	@Transactional
	public void testSave_whenCacheEvicted_fetchFromDb_doesNotHaveLatestChanges() {
		BankAccount bankAccount = bankJpaRepository.findById(1).get(); // fetch from db and result is cached

		String expectedFName = "pinkman";
		String actualFName = bankAccount.getFirstName();

		// Modify Data
		System.out.println("Before Save : " + expectedFName.equals(actualFName)); // True
		bankAccount.setFirstName("Jackson");

		// update in db and cache
		bankJpaRepository.save(bankAccount);

		// evicted from Cache 
		Session session = em.unwrap(Session.class);
		session.evict(bankAccount); 

		// fetch from db
		BankAccount result = bankJpaRepository.findById(1).get();
		expectedFName = "Jackson";
		actualFName = result.getFirstName();
		
		// data does not match, even after executing save, becoz data is not committed in db
		System.out.println("After Save : " + expectedFName.equals(actualFName)); // True
	}
	
	@Transactional
	public void testSaveAndFlush_whenCacheEvicted_fetchFromDb_hasLatestChanges() {
		BankAccount bankAccount = bankJpaRepository.findById(1).get(); // fetch from db and result is cached

		String expectedFName = "pinkman";
		String actualFName = bankAccount.getFirstName();

		// Modify Data
		System.out.println("Before Save : " + expectedFName.equals(actualFName)); // True
		bankAccount.setFirstName("Jackson");

		// update in db and cache
		bankJpaRepository.saveAndFlush(bankAccount);

		// evicted from Cache
		Session session = em.unwrap(Session.class);
		session.evict(bankAccount);

		// fetch from db
		BankAccount result = bankJpaRepository.findById(1).get();
		expectedFName = "Jackson";
		actualFName = result.getFirstName();

		// data does match, even after executing saveAndFlush, becoz data is committed in db
		System.out.println("After Save : " + expectedFName.equals(actualFName)); // True
	}
	
	
	@Transactional
	public void testSaveAndFlush_notRollBackedOnException() {
		BankAccount bankAccount = bankJpaRepository.findById(1).get(); // fetch from db and result is cached

		String expectedFName = "pinkman";
		String actualFName = bankAccount.getFirstName();

		// Modify Data
		System.out.println("Before Save : " + expectedFName.equals(actualFName)); // True
		bankAccount.setFirstName("Jackson");

		// update in db and cache
		bankJpaRepository.saveAndFlush(bankAccount);

		if (true) {
			try {
				throw new RuntimeException();
			} catch (Exception ex) {
				System.out.println(
						"Error thrown Intentionally to show data is not rolled Back on exception, since data is committed.");
			} finally {
				// evicted from Cache to do actually db class
				Session session = em.unwrap(Session.class);
				session.evict(bankAccount);

				BankAccount result = bankJpaRepository.findById(1).get();
				expectedFName = "Jackson";
				actualFName = result.getFirstName();
				// data matched, even after executing saveAndFlush, becoz data is committed in
				// db
				System.out.println("After Save : " + expectedFName.equals(actualFName)); // True
			}
		}

	}
	
	@Transactional
	public void testSave_rolledBackOnException() {
		BankAccount bankAccount = bankJpaRepository.findById(1).get(); // fetch from db and result is cached

		String expectedFName = "pinkman";
		String actualFName = bankAccount.getFirstName();

		// Modify Data
		System.out.println("Before Save : " + expectedFName.equals(actualFName)); // True
		bankAccount.setFirstName("Jackson");

		// update in db and cache
		bankJpaRepository.save(bankAccount);

		if (true) {
			try {
				throw new RuntimeException();
			} catch (Exception ex) {
				System.out.println(
						"Error thrown Intentionally to show data is rolled Back on exception, since data is not committed.");
			} finally {
				// evicted from Cache to do actually db class
				Session session = em.unwrap(Session.class);
				session.evict(bankAccount);

				BankAccount result = bankJpaRepository.findById(1).get();
				expectedFName = "Jackson";
				actualFName = result.getFirstName();
				// data matched, even after executing saveAndFlush, becoz data is committed in
				// db
				System.out.println("After Save : " + expectedFName.equals(actualFName)); // True
			}
		}

	}
}
