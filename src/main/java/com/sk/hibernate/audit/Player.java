package com.sk.hibernate.audit;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Player {

	@Id
	@Column(name = "PLAYER_NAME")
	private String playerName;

	@Column(name = "T20_RANKING")
	private Integer t20Ranking;

	@Column(name = "ODI_RANKING")
	private Integer odiRanking;

	@Column(name = "TEST_RANKING")
	private Integer testRanking;

	@ManyToOne
	@JoinColumn(name = "TEAM_NAME")
	@ToString.Exclude
	private ICCRanking iccRanking;

}
