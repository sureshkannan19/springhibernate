package com.sk.hibernate.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class BankApplicationTests {

	@Autowired
	BankRepository bankRepository;

	@Test
	public void test_PagingAndSorting() {
		// 6 records present --> page number starts from 0, 1, 2.. and records size is
		// given as 3
		// so 3 records per page,
		// so page 0 has first 3 records, and page 1 has second 3 records,
		// when given page 2 , which does not have any records, hence displayed empty

		System.out.println("***** Page zero *****");
		bankRepository.findAll(PageRequest.of(0, 3, Sort.by(Direction.ASC, "accNum"))).forEach(System.out::println);

		System.out.println("***** Page one *****");
		bankRepository.findAll(PageRequest.of(1, 3, Sort.by(Direction.ASC, "accNum"))).forEach(System.out::println);

		System.out.println("***** Page two *****");
		bankRepository.findAll(PageRequest.of(2, 3, Sort.by(Direction.ASC, "accNum"))).forEach(System.out::println);
	}

	@Test
	public void test_Paging() {
		bankRepository.findAll(PageRequest.of(0, 3)).forEach(System.out::println);
	}

	@Test
	public void test_Sorting() {
		bankRepository.findAll(Sort.by(Direction.ASC, "accNum")).forEach(System.out::println);
	}

	@Test
	public void test_pageableInCustomerFinderMethod() {
		Pageable pageable = PageRequest.of(0, 3);
		bankRepository.findByAccNumBetween(3, 8, pageable).forEach(System.out::println);
	}

}
