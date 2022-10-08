package com.sk.hibernate.manytomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
public class ProgrammerApplicationTest {

	@Autowired
	ProgrammerRepository programmerRepository;

	@Test
	public void test() {
		Programmer programmer = new Programmer();
		programmer.setName("SK");
		Project project = new Project();
		project.setName("SpringBatch");
		programmer.addProject(project);
		
		programmerRepository.save(programmer);
	}
}
