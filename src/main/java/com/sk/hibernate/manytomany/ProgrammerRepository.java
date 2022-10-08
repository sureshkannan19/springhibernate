package com.sk.hibernate.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer, Integer> {

}
