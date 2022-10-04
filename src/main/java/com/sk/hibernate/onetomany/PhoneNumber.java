package com.sk.hibernate.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private int id;
	@EqualsAndHashCode.Include
	private int number;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private UserClient userClient;
	
	public PhoneNumber(UserClient userClient) {
		this.userClient = userClient;
	}

}
