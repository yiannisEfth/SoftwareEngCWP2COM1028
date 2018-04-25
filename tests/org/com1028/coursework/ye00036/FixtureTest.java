package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

//JUnit tests for the Fixture class
public class FixtureTest {

	private static List<Match> fixture1Matches;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Stadium stadium1 = new Stadium("Team1Stadium", 25000);
		Stadium stadium2 = new Stadium("Team2Stadium", 10000);
		Team team1 = new Team("Team1", stadium1);
		Team team2 = new Team("Team2", stadium2);
		Match match1 = new Match(team1, team2);
		Match match2 = new Match(team2, team1);
		fixture1Matches = new ArrayList<Match>();
		fixture1Matches.add(match1);
		fixture1Matches.add(match2);
	}

	@Test
	public void getFixtureNumberTest() {
		Fixture fixture1 = new Fixture(fixture1Matches, 1);
		assertEquals(1, fixture1.getFixtureNumber());
	}

	@Test
	public void fixtureFinishedFalseTest() {
		Fixture fixture1 = new Fixture(fixture1Matches, 1);
		assertEquals(false, fixture1.isFinished());
	}

	@Test
	public void fixtureFinishedTrueTest() {
		Fixture fixture1 = new Fixture(fixture1Matches, 1);
		fixture1.setFinished(true);
		assertEquals(true, fixture1.isFinished());
	}

	@Test
	public void getFromListTest1() {
		Fixture fixture1 = new Fixture(fixture1Matches, 1);
		String teamName = fixture1.getMatches().get(0).getHomeTeam().getName();
		assertEquals("Team1", teamName);
	}

	@Test
	public void getFromListTest2() {
		Fixture fixture1 = new Fixture(fixture1Matches, 1);
		String teamName = fixture1.getMatches().get(1).getAwayTeam().getName();
		assertEquals("Team1", teamName);
	}

}
