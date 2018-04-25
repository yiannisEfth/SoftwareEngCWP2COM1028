package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

//JUnit test for the LeagueManager class
public class LeagueManagerTest {

	private static LeagueManager leagueManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String[] teamNames = { "team1", "team2", "team3", "team4", "team5", "team6", "team7", "team8", "team9",
				"team10", "team11", "team12", "team13", "team14", "team15", "team16" };
		Stadium stadium = new Stadium("CommonStadium", 25000);
		leagueManager = new LeagueManager();
		for (int i = 0; i < teamNames.length; i++) {
			Team team = new Team(teamNames[i], stadium);
			leagueManager.insertTeam(team);
		}
		leagueManager.generateFixtures();
	}

	@Test
	public void getMatchFromFixture() {
		String homeTeamName = leagueManager.getFixtures().get(0).getMatches().get(0).getHomeTeam().getName();
		assertEquals("team2", homeTeamName);
	}

	@Test
	public void getStadiumFromFixture() {
		String homeTeamStadium = leagueManager.getFixtures().get(1).getMatches().get(3).getStadium().getName();
		assertEquals("CommonStadium", homeTeamStadium);
	}

	@Test
	public void getTeamFromLeague() {
		String teamName = leagueManager.getTeams().get(5).getName();
		assertEquals("team6", teamName);
	}

	@Test
	public void getLeagueExistsFalse() {
		LeagueManager lm = new LeagueManager();
		assertEquals(false, lm.isLeagueExists());
	}

	@Test
	public void getLeagueExistsTrue() {
		leagueManager.setLeagueExists(true);
		assertEquals(true, leagueManager.isLeagueExists());
	}

	@Test
	public void getIsAdminFalse() {
		assertEquals(false, leagueManager.getIsAdmin());
	}

	@Test
	public void getIsAdminTrue() {
		LeagueManager lm2 = new LeagueManager();
		lm2.setIsAdmin(true);
		assertEquals(true, lm2.getIsAdmin());
	}

	@Test
	public void getScoreFromFixtureMatch() {
		leagueManager.getFixtures().get(24).getMatches().get(3).setHomeScore(5);
		int homeScore = leagueManager.getFixtures().get(24).getMatches().get(3).getHomeScore();
		assertEquals(5, homeScore);
	}

	@Test
	public void getFixtureNumber() {
		int fixtureNumber = leagueManager.getFixtures().get(6).getFixtureNumber();
		assertEquals(4, fixtureNumber);
	}

	@Test
	public void getFixtureFinishedFalse() {
		assertEquals(false, leagueManager.getFixtures().get(2).isFinished());
	}

	@Test
	public void getFixtureFinishedTrue() {
		leagueManager.getFixtures().get(0).setFinished(true);
		assertEquals(true, leagueManager.getFixtures().get(0).isFinished());
	}

	@Test
	public void getClearedLists() {
		LeagueManager lm3 = new LeagueManager();
		Stadium stadium = new Stadium("CommonStadium", 25000);
		Team team1 = new Team("tool", stadium);
		Team team2 = new Team("tool2", stadium);
		lm3.insertTeam(team1);
		lm3.insertTeam(team2);
		Match match1 = new Match(team1, team2);
		List<Match> fixtureMatch = new ArrayList<Match>();
		fixtureMatch.add(match1);
		Fixture fixture = new Fixture(fixtureMatch, 1);
		lm3.insertFixture(fixture);
		assertEquals(2, lm3.getTeams().size());
		assertEquals(1, lm3.getFixtures().size());
		lm3.clearList();
		assertEquals(0, lm3.getTeams().size());
		assertEquals(0, lm3.getFixtures().size());
	}

}
