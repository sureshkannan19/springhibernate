package com.sk.hibernate.bank;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sk.hibernate.entity.BankAccount;

public interface BankRepository extends PagingAndSortingRepository<BankAccount, Integer> {

	List<BankAccount> findByAccNumBetween(int start, int end, Pageable pageable);
}
