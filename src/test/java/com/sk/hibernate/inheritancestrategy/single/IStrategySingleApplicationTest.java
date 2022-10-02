package com.sk.hibernate.inheritancestrategy.single;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sk.hibernate.entity.Card;
import com.sk.hibernate.entity.Check;

@SpringBootTest
@ActiveProfiles("dev")
public class IStrategySingleApplicationTest {

	@Autowired
	IStrategySingleRepository repository;

	@Test
	public void test_paymentModeByCard() {
		Card card = new Card();
		card.setAmount(2);
		card.setCardNum(20);

		repository.save(card);

		String paymentMode = repository.findPModeById(card.getId());
		assertEquals("CC", paymentMode);
	}

	@Test
	public void test_paymentModeByCheck() {
		Check check = new Check();
		check.setAmount(2);
		check.setCheckNum(20);

		repository.save(check);

		String paymentMode = repository.findPModeById(check.getId());
		assertEquals("CH", paymentMode);
	}
}
