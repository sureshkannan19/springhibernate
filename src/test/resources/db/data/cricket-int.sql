delete from player;
delete from player_aud;
delete from ICCRanking;
delete from ICCRanking_AUD;
insert into ICCRanking (TEAM_NAME , RANKING , MATCH_FORMAT) values ('INDIA', 1, 'ODI');
insert into ICCRanking (TEAM_NAME , RANKING , MATCH_FORMAT) values ('ENGLAND', 2, 'ODI');
insert into player ( PLAYER_NAME, TEAM_NAME, T20_RANKING, ODI_RANKING, TEST_RANKING ) 
			values ( 'MSD', 'INDIA', 7, 7, 7 );
insert into player ( PLAYER_NAME, TEAM_NAME, T20_RANKING, ODI_RANKING, TEST_RANKING ) 
			values ( 'RAINA', 'INDIA', 5 , 8, 10 );
insert into player ( PLAYER_NAME, TEAM_NAME, T20_RANKING, ODI_RANKING, TEST_RANKING ) 
			values ( 'KOHLI', 'INDIA', 1, 1, 1 );
insert into CRIC_MATCH (MATCH_FORMAT, NO_OF_OVERS) values ('ODI', 50);
insert into CRIC_MATCH (MATCH_FORMAT, NO_OF_OVERS) values ('T20', 20);
insert into CRIC_MATCH (MATCH_FORMAT, NO_OF_OVERS) values ('TEST', 90);