package com.sk.hibernate.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sk.hibernate.entity.Employee;

@SpringBootTest(args = "--spring.profiles.active=int")
public class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void createProduct() {
		Employee employee = new Employee();
		employee.setName("JonSnow");
		employeeRepository.save(employee);

		Employee actual = employeeRepository.findById(employee.getId()).get();
		assertEquals(employee, actual);
	}
}
