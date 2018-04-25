package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

//JUnit tests for the Team class
public class TeamTest {

	private static Team team;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Stadium teamStadium = new Stadium("TeamStadium", 40000);
		team = new Team("Team1", teamStadium);
	}

	@Test
	public void getTeamNameTest() {
		String teamName = team.getName();
		assertEquals("Team1", teamName);
	}

	@Test
	public void getTeamWinsTest() {
		team.setWins(2);
		int teamWins = team.getWins();
		assertEquals(2, teamWins);
	}

	@Test
	public void getTeamDrawsTest() {
		team.setDraws(5);
		int teamDraws = team.getDraws();
		assertEquals(5, teamDraws);
	}

	@Test
	public void getTeamLossesTest() {
		team.setLosses(1);
		int teamLosses = team.getLosses();
		assertEquals(1, teamLosses);
	}

	@Test
	public void getGoalsForTest() {
		Stadium teamStadium = new Stadium("TeamStadium", 40000);
		team = new Team("Team1", teamStadium);
		team.setGoalsFor(5);
		int teamGoalsFor = team.getGoalsFor();
		assertEquals(5, teamGoalsFor);
	}

	@Test
	public void getGoalsAgainstTest() {
		team.setGoalsAgainst(3);
		int teamGoalsAgainst = team.getGoalsAgainst();
		assertEquals(3, teamGoalsAgainst);
	}

	@Test
	public void getGoalDifferenceTest() {
		team.setGoalsFor(12);
		team.setGoalsAgainst(6);
		int teamGoalDifference = team.getGoalDifference();
		assertEquals(6, teamGoalDifference);
	}

}
