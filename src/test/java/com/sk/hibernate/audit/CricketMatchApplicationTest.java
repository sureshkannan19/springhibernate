package com.sk.hibernate.audit;

import javax.persistence.EntityManagerFactory;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
@Sql(scripts = { "/db/data/cricket-int.sql" })
public class CricketMatchApplicationTest {

	@Autowired
	ICCRankingRepository iccRankingRepository;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Test
	public void test() {
		ICCRanking indIccRanking = iccRankingRepository.findById("INDIA").get();
		// update iccranking set match_format=?, ranking=? where team_name=?
		// insert into iccranking_aud (revtype, ranking, match_format, team_name, rev) values (?, ?, ?, ?, ?)
		indIccRanking.setRanking(2);  
		
		int rank = 10;
		for (Player player : indIccRanking.getPlayers()) { // 3 players
			// executed thrice --> 3 * update player set team_name=?, odi_ranking=?, t20_ranking=?, test_ranking=? where player_name=?
			// executed thrice --> 3 * insert into player_aud (revtype, odi_ranking, t20_ranking, test_ranking, team_name, player_name, rev) values (?, ?, ?, ?, ?, ?, ?)
			player.setT20Ranking(rank--); 
		}
		
		// insert into revinfo (rev, revtstmp) values (default, ?)
        // db operations in tables --> PLAYER, ICCRanking, REVINFO, ICCRanking_AUD, PLAYER_AUD
		// CRIC_MATCH is excluded due to @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
		iccRankingRepository.save(indIccRanking);

		// Using Revision Id, primary Key --> Persisted data for that revision (transaction) can be found
		AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
		indIccRanking = reader.find(ICCRanking.class, "INDIA", 1l);

		System.out.println(indIccRanking);
	}

}
