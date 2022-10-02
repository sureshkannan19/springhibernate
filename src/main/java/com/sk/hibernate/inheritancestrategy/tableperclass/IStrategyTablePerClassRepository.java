package com.sk.hibernate.inheritancestrategy.tableperclass;

import org.springframework.data.repository.CrudRepository;

public interface IStrategyTablePerClassRepository extends CrudRepository<Car, String> {

}
