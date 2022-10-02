package com.sk.hibernate.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sk.hibernate.entity.Card;
import com.sk.hibernate.entity.Check;

@SpringBootTest
@ActiveProfiles("dev")
public class PaymentApplicationTest {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	public void test_paymentModeByCard() {
		Card card = new Card();
		card.setAmount(2);
		card.setCardNum(20);

		paymentRepository.save(card);
		
		String paymentMode = paymentRepository.findPModeById(card.getId());
		assertEquals("CC", paymentMode);
	}

	@Test
	public void test_paymentModeByCheck() {
		Check check = new Check();
		check.setAmount(2);
		check.setCheckNum(20);

		paymentRepository.save(check);
		
		String paymentMode = paymentRepository.findPModeById(check.getId());
		assertEquals("CH", paymentMode);
	}
}
