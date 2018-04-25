package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

//JUnit tests for the Match class
public class MatchTest {

	private static Match match;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Stadium team1Stadium = new Stadium("T1S", 25000);
		Team team1 = new Team("Team1", team1Stadium);
		Stadium team2Stadium = new Stadium("T2S", 50000);
		Team team2 = new Team("Team2", team2Stadium);
		match = new Match(team1, team2);
	}

	@Test
	public void getTeamNameTest() {
		String teamName = match.getHomeTeam().getName();
		assertEquals("Team1", teamName);
	}

	@Test
	public void getTeamStadiumTest() {
		String matchStadium = match.getStadium().getName();
		assertEquals("T1S", matchStadium);
	}

	@Test
	public void setHomeScoreTest() {
		match.setHomeScore(1);
		assertEquals(1, match.getHomeScore());
	}

	@Test
	public void setAwayScoreTest() {
		match.setAwayScore(4);
		assertEquals(4, match.getAwayScore());
	}

}
