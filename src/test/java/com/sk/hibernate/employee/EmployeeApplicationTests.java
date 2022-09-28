package com.sk.hibernate.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sk.hibernate.employee.dao.EmployeeRepository;
import com.sk.hibernate.entity.Employee;

@SpringBootTest
@ActiveProfiles("dev")
public class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createProduct() {
		Employee employee = new Employee();
		employee.setName("JonSnow");
		employeeRepository.save(employee);

		Employee actual = employeeRepository.findById(employee.getId()).get();
		assertEquals(employee, actual);
	}
}
