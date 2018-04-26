package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

//JUnit test for the LeagueManager class
public class LeagueManagerTest {

	@Before
	public void setUpBefore() throws Exception {
		String[] teamNames = { "team1", "team2", "team3", "team4", "team5", "team6", "team7", "team8", "team9",
				"team10", "team11", "team12", "team13", "team14", "team15", "team16" };
		Stadium stadium = new Stadium("CommonStadium", 25000);
		for (int i = 0; i < teamNames.length; i++) {
			Team team = new Team(teamNames[i], stadium);
			LeagueManager.getInstance().insertTeam(team);
		}
		LeagueManager.getInstance().generateFixturesForTesting();
	}

	@Test
	public void getMatchFromFixture() {
		String homeTeamName = LeagueManager.getInstance().getFixtures().get(0).getMatches().get(0).getHomeTeam()
				.getName();
		assertEquals("team2", homeTeamName);
	}

	@Test
	public void getStadiumFromFixture() {
		String homeTeamStadium = LeagueManager.getInstance().getFixtures().get(1).getMatches().get(3).getStadium()
				.getName();
		assertEquals("CommonStadium", homeTeamStadium);
	}

	@Test
	public void getTeamFromLeague() {
		String teamName = LeagueManager.getInstance().getTeams().get(5).getName();
		assertEquals("team6", teamName);
	}

	@Test
	public void getLeagueExistsFalse() {
		LeagueManager.getInstance().setLeagueExists(false);
		assertEquals(false, LeagueManager.getInstance().isLeagueExists());
	}

	@Test
	public void getLeagueExistsTrue() {
		LeagueManager.getInstance().setLeagueExists(true);
		assertEquals(true, LeagueManager.getInstance().isLeagueExists());
	}

	@Test
	public void getIsAdminFalse() {
		assertEquals(false, LeagueManager.getInstance().getIsAdmin());
	}

	@Test
	public void getIsAdminTrue() {
		LeagueManager.getInstance().setIsAdmin(true);
		assertEquals(true, LeagueManager.getInstance().getIsAdmin());
	}

	@Test
	public void getScoreFromFixtureMatch() {
		LeagueManager.getInstance().getFixtures().get(24).getMatches().get(3).setHomeScore(5);
		int homeScore = LeagueManager.getInstance().getFixtures().get(24).getMatches().get(3).getHomeScore();
		assertEquals(5, homeScore);
	}

	@Test
	public void getFixtureNumber() {
		int fixtureNumber = LeagueManager.getInstance().getFixtures().get(6).getFixtureNumber();
		assertEquals(4, fixtureNumber);
	}

	@Test
	public void getFixtureFinishedFalse() {
		assertEquals(false, LeagueManager.getInstance().getFixtures().get(2).isFinished());
	}

	@Test
	public void getFixtureFinishedTrue() {
		LeagueManager.getInstance().getFixtures().get(0).setFinished(true);
		assertEquals(true, LeagueManager.getInstance().getFixtures().get(0).isFinished());
	}

	@Test
	public void getClearedLists() {
		Stadium stadium = new Stadium("CommonStadium", 25000);
		LeagueManager.getInstance().clearList();
		Team team1 = new Team("tool", stadium);
		Team team2 = new Team("tool2", stadium);
		LeagueManager.getInstance().insertTeam(team1);
		LeagueManager.getInstance().insertTeam(team2);
		Match match1 = new Match(team1, team2);
		List<Match> fixtureMatch = new ArrayList<Match>();
		fixtureMatch.add(match1);
		Fixture fixture = new Fixture(fixtureMatch, 1);
		LeagueManager.getInstance().insertFixture(fixture);
		assertEquals(2, LeagueManager.getInstance().getTeams().size());
		assertEquals(1, LeagueManager.getInstance().getFixtures().size());
		LeagueManager.getInstance().clearList();
		assertEquals(0, LeagueManager.getInstance().getTeams().size());
		assertEquals(0, LeagueManager.getInstance().getFixtures().size());
	}

}
