package com.sk.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableGenerator(name = "EMPLOYEE_GEN", table = "MY_SEQUENCES", pkColumnName = "SEQ_NAME", pkColumnValue = "NEXT_VAL", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "EMPLOYEE_GEN")
	@Column(name = "EMP_ID")
	private int id;
	private String name;

}
