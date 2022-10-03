package com.sk.hibernate.componentmapping;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Embeddable
public class Address {

	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipCode;

}
