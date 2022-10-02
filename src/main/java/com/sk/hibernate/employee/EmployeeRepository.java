package com.sk.hibernate.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.hibernate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
