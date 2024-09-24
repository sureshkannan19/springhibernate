package com.sk.hibernate.audit;

import com.sk.hibernate.annotation.SpringBootTestByProfile;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityManagerFactory;

@SpringBootTestByProfile
@Sql(scripts = { "/db/data/cricket-int.sql" , "/db/data/customers-int.sql" })
public class CricketMatchApplicationTest {

	@Autowired
	ICCRankingRepository iccRankingRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Test
	public void test() {
		ICCRanking indIccRanking = iccRankingRepository.findById("INDIA").get();
		// update iccranking set match_format=?, ranking=? where team_name=?
		// insert into iccranking_aud (revtype, ranking, match_format, team_name, rev) values (?, ?, ?, ?, ?)
		indIccRanking.setRanking(2);
		indIccRanking.setMatch(new Match("T20", 1));
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


	@Test
	public void test_new() {
		Customers cust = new Customers();
		cust.setCustomerId(1L);
		cust.setCustomerName("SK");
		cust.setSocialSecurityNum(12345L);
		cust.setPayment(new Payments("UPI", "IND"));

		customerRepository.save(cust);

		// Using Revision Id, primary Key --> Persisted data for that revision (transaction) can be found
		AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
		cust = reader.find(Customers.class, 1l, 1l);

		System.out.println(cust);
	}
}
