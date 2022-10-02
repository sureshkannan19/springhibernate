package com.sk.hibernate.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sk.hibernate.entity.Card;

@SpringBootTest
@ActiveProfiles("dev")
public class PaymentApplicationTest {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	public void test_paymentModeByCard() {
		Card card = new Card();
		card.setId(1);
		card.setAmount(2);
		card.setCardNum(19);

		paymentRepository.save(card);
	}
}
