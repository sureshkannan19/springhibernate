package com.sk.hibernate.entity;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
public class MaruthiSwift extends Car {

	private double pricePerLitre;
}
