package com.sk.hibernate.onetoone;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@SqlResultSetMapping(name = "LicenseIdAndTypeByValidFrom", classes = {
		@ConstructorResult(targetClass = License.class, columns = { @ColumnResult(name = "id"),
				@ColumnResult(name = "type") }) })
@NamedNativeQueries({
		@NamedNativeQuery(name = "License.getAllIdAndTypeByValidFrom", query = "Select id, type from License where valid_from >= :validFrom", resultSetMapping = "LicenseIdAndTypeByValidFrom"),
		@NamedNativeQuery(name = "License.getByValidFrom", query = "select * from License where VALID_FROM =:validFrom", resultClass = License.class) })
@NamedQuery(name = "License.getByType", query = "select l from License l where l.type=:type")
@NoArgsConstructor
@AllArgsConstructor
public class License {

	public License(int id, String type) {
		this.id = id;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private Date validFrom;
	private Date validTo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

}
