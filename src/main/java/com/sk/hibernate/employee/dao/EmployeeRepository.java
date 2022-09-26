package com.sk.hibernate.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.hibernate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
