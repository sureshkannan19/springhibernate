package com.sk.hibernate.inheritancestrategy.tableperclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class IStrategyTablePerClassApplicationTest {

	@Autowired
	IStrategyTablePerClassRepository repository;

	@Test
	public void test_tataNexon() {
		TataNexon car = new TataNexon();
		car.setRegisterId("TN09CH0001");
		car.setFuelType("Electric");
		car.setPricePerUnit(5d);

		repository.save(car);

		Car result = repository.findById("TN09CH0001").get();
		assertEquals(car, result);
	}

	@Test
	public void test_maruthiSwift() {
		MaruthiSwift car = new MaruthiSwift();
		car.setRegisterId("TN09CH0002");
		car.setFuelType("Diesel");
		car.setPricePerLitre(100d);

		repository.save(car);

		Car result = repository.findById("TN09CH0002").get();
		assertEquals(car, result);
	}
}
