package org.com1028.coursework.ye00036;

import java.util.ArrayList;
import java.util.List;

public class LeagueManager {
	private static LeagueManager instance = null;
	private static final int TOTAL_TEAMS = 16;
	private static final int TOTAL_ROUNDS = 15;
	private static final int MATCHES_PER_ROUND = 8;
	private List<Team> teams = new ArrayList<Team>();
	private List<Fixture> fixtures = new ArrayList<Fixture>();
	private boolean leagueExists = false;
	private boolean isAdmin = false;

	/**
	 * Constructor for the LeagueManager class initialising the list and existence
	 * of league.
	 */
	protected LeagueManager() {
		
	}

	public static LeagueManager getInstance() {
		if(instance == null) {
			instance =  new LeagueManager();
		}
		return instance;
	}
	// Method to get the list of teams in the league.
	public List<Team> getTeams() {
		return teams;
	}

	// Method to get the list of fixtures in the league.
	public List<Fixture> getFixtures() {
		return fixtures;
	}

	// Method to check if the league exists.
	public boolean isLeagueExists() {
		return leagueExists;
	}

	// Setter for the existence of a league.
	public void setLeagueExists(boolean leagueExists) {
		this.leagueExists = leagueExists;
	}

	/**
	 * Method used to add a team to the list of teams.
	 * 
	 * @param team
	 *            object to be inserted into the list of teams in the league.
	 */
	public void insertTeam(Team team) {
		teams.add(team);
	}

	/**
	 * Method used to add a fixture in the list of fixtures in the league.
	 * 
	 * @param fixture
	 *            object to be added in the fixture list.
	 */
	public void insertFixture(Fixture fixture) {
		fixtures.add(fixture);
	}

	// Method to clear both lists.
	public void clearList() {
		this.teams.clear();
		this.fixtures.clear();
	}

	/**
	 * Setter to choose whether the user is an admin or a guest.
	 * 
	 * @param isAdmin
	 *            true or false depending on the user.
	 */
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	// Return the boolean value whether the user is an admin or a guest.
	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	/**
	 * Method that contains an algorithm used to generate fixtures for the league.
	 * The fixtures are generated in such a way that the matches between teams are
	 * balanced and meet the requirements of a regular football league.
	 */
	public void generateFixtures() {
		for (int round = 1; round <= TOTAL_ROUNDS; round++) {
			List<Match> matches = new ArrayList<Match>();
			List<Match> matchesReverse = new ArrayList<Match>();
			for (int match = 0; match < MATCHES_PER_ROUND; match++) {
				int home = (round + match) % (TOTAL_TEAMS - 1);
				int away = (TOTAL_TEAMS - 1 - match + round) % (TOTAL_TEAMS - 1);
				// Last team stays in the same place while the others
				// rotate around it.
				if (match == 0) {
					away = TOTAL_TEAMS - 1;
				}
				// Add one so teams are number 1 to teams not 0 to teams - 1
				// upon display.
				Match matchMade = new Match(teams.get(home), teams.get(away));
				SQLiteClass.insertMatch(teams.get(home), teams.get(away), round);
				;
				matches.add(matchMade);
				Match matchMadeReverse = new Match(teams.get(away), teams.get(home));
				SQLiteClass.insertMatch(teams.get(away), teams.get(home), round + 15);
				;
				matchesReverse.add(matchMadeReverse);

			}
			Fixture fixture = new Fixture(matches, round);
			fixtures.add(fixture);
			Fixture fixtureRematch = new Fixture(matchesReverse, round + 15);
			fixtures.add(fixtureRematch);
		}
	}

}