package com.sk.hibernate.inheritancestrategy.tableperclass;

import org.springframework.data.repository.CrudRepository;

import com.sk.hibernate.entity.Car;

public interface IStrategyTablePerClassRepository extends CrudRepository<Car, String> {

}
