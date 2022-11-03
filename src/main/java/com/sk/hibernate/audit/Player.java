package com.sk.hibernate.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	public Player(ICCRanking iccRanking) {
		this.iccRanking = iccRanking;
	}
}
