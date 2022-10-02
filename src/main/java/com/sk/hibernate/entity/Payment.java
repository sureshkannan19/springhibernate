package com.sk.hibernate.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@DiscriminatorColumn(name = "P_MODE", discriminatorType = DiscriminatorType.STRING)
public abstract class Payment {

	@Id
	private int id;
	private int amount;

}
