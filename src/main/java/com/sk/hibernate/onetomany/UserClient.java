package com.sk.hibernate.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	private String clientName;

	@OneToMany(mappedBy = "userClient", cascade = CascadeType.ALL)
	private Set<PhoneNumber> phoneNumbers;

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		if (phoneNumber != null) {
			if (phoneNumbers == null) {
				phoneNumbers = new HashSet<>();
			}
			phoneNumbers.add(phoneNumber);
		}
	}
}
