package com.sk.hibernate.inheritancestrategy.joined;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Girlz extends Student {

	private int noOfSubjectsPassed;
}
