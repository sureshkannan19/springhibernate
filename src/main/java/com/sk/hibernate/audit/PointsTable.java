package com.sk.hibernate.audit;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

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
@Audited
@AuditTable("POINTS_TABLE_AUD")
public class PointsTable {

	@Id
	private String teamName;
	private int points;
	private double runRate;

}
