package com.sk.hibernate.inheritancestrategy.single;

import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue("CC")
public class Card extends Payment {

	private int cardNum;

}
