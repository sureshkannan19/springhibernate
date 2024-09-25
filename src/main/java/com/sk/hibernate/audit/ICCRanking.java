package com.sk.hibernate.audit;

import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
	@NotAudited
	private int ranking;

	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED) // unidirectional relationship
//	@NotAudited
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MATCH_FORMAT")
	private Match match;

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
