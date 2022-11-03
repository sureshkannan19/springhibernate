package com.sk.hibernate.audit;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ICCRanking")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable("ICCRanking_AUD")
public class ICCRanking {

	@Id
	private String teamName;
	private int ranking;

	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED) // unidirectional relationship
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MATCH_FORMAT")
	private Match match;

	// @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED) // will not work for bidrectional relationship
	@OneToMany(mappedBy = "iccRanking", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	private Set<Player> players;

	public void addPlayer(Player player) {
		if (players == null) {
			players = new HashSet<>();
		}
		players.add(player);
	}

}
