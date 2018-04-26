package org.com1028.coursework.ye00036;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Class responsible for all commands to be executed in the database
public class SQLiteClass {
	// FOR WINDOWS USE: jdbc:sqlite:D:/sqlite/dbs/FLMS.db
	// FOR MAC USE:
	// jdbc:sqlite:/Users/yiannisefthyvoulou/Documents/SQLiteDbs/FLMS.db
	private static String url = "jdbc:sqlite:/Users/yiannisefthyvoulou/Documents/SQLiteDbs/FLMS.db";

	// Create the database method
	public static void createDB() {

		String createTeamTable = "CREATE TABLE \"Teams\" ( `name` TEXT NOT NULL UNIQUE, `wins` INTEGER, `draws` INTEGER, `losses` INTEGER, "
				+ "`goals_for` INTEGER, `goals_against` INTEGER, PRIMARY KEY(`name`) )";

		String createStadiumTable = "CREATE TABLE \"Stadiums\" ( `name` TEXT NOT NULL, `capacity` INTEGER NOT NULL, `owned_by` TEXT NOT NULL, "
				+ "`ID` INTEGER NOT NULL, FOREIGN KEY(`owned_by`) REFERENCES `Teams`(`name`), PRIMARY KEY(`ID`) )";

		String createMatchTable = "CREATE TABLE \"Matches\" ( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `home_team` TEXT NOT NULL, "
				+ "`away_team` TEXT NOT NULL, `home_team_goals` INTEGER, `away_team_goals` INTEGER, `stadium` TEXT NOT NULL, `fixture` INTEGER NOT NULL, "
				+ "`is_played` INTEGER NOT NULL, FOREIGN KEY(`home_team`) REFERENCES `Teams`(`name`), FOREIGN KEY(`away_team`) REFERENCES `Teams`(`name`) )";

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.execute(createTeamTable);
				stmt.execute(createStadiumTable);
				stmt.execute(createMatchTable);
				stmt.close();
				conn.close();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// FOR WINDOWS USE: D:/sqlite/dbs/FLMSdb.db
	// FOR MAC USE: /Users/yiannisefthyvoulou/Documents/SQLiteDbs/FLMS.db
	// Check if the database exists in order to decide whether to create the tables
	// or not.
	public static boolean checkIfDbExists() {
		File dbFile = new File("/Users/yiannisefthyvoulou/Documents/SQLiteDbs/FLMS.db");
		if (dbFile.exists()) {
			return true;
		} else {
			return false;
		}
	}

	// Method to check if the league exists.
	public static boolean checkIfLeagueExists() {
		int rowCount = 0;
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Teams");
			rs.next();
			rowCount = rs.getInt(1);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rowCount == 16) {
			return true;
		} else {
			return false;
		}
	}

	// Method to return the number of teams currently in the table.
	public static int getNumberOfTeams() {
		int count = 0;
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT COUNT(*) FROM Teams");
			while (res.next()) {
				count = res.getInt(1);
			}
			st.close();
			res.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * Method to insert a team into the Team table.
	 * 
	 * @param teamName
	 *            to be entered in the table
	 * @param stadiumName
	 *            to be entered in the table
	 * @param stadiumCapacity
	 *            to be entered in the table.
	 */
	public static void insertTeam(String teamName, String stadiumName, int stadiumCapacity) {
		String insertTeamQuery = "INSERT INTO Teams (name) values(?)";
		String insertStadiumQuery = "INSERT INTO Stadiums (name, capacity, owned_by) values(?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pst = conn.prepareStatement(insertTeamQuery);
			pst.setString(1, teamName);
			pst.execute();
			pst = conn.prepareStatement(insertStadiumQuery);
			pst.setString(1, stadiumName);
			pst.setInt(2, stadiumCapacity);
			pst.setString(3, teamName);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to fill the list of teams for an unfinished league.
	 */
	public static void fillTeamsUnfinishedLeague() {
		String getTeamsQuery = "SELECT * FROM Teams";
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(getTeamsQuery);
			while (rs.next()) {
				String teamName = rs.getString("name");
				Team team = new Team(teamName, getStadiumOfTeam(teamName));
				LeagueManager.getInstance().insertTeam(team);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get the stadium of a given team.
	 * 
	 * @param teamName
	 *            the given name of the team to get its stadium.
	 * @return the stadium object that the team has as home base.
	 */
	public static Stadium getStadiumOfTeam(String teamName) {
		Stadium stadium = null;
		try {
			String getStadiumQuery = "SELECT * FROM Stadiums WHERE owned_by = ?";
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stadiumstmt = conn.prepareStatement(getStadiumQuery);
			stadiumstmt.setString(1, teamName);
			ResultSet stadiumRs = stadiumstmt.executeQuery();
			stadiumRs.next();
			String stadiumName = stadiumRs.getString("name");
			int stadiumCapacity = stadiumRs.getInt("capacity");
			stadium = new Stadium(stadiumName, stadiumCapacity);
			stadiumRs.close();
			stadiumstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stadium;
	}

	/**
	 * Method to insert a match into the Matches table.
	 * 
	 * @param home
	 *            the team to play at home.
	 * @param away
	 *            the team to play away.
	 * @param fixture
	 *            the fixture that the match will be played in.
	 */
	public static void insertMatch(Team home, Team away, int fixture) {
		String insertMatchQuery = "INSERT INTO Matches (home_team, away_team, stadium, fixture, is_played) values(?,?,?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pst = conn.prepareStatement(insertMatchQuery);
			pst.setString(1, home.getName());
			pst.setString(2, away.getName());
			pst.setString(3, home.getStadium().getName());
			pst.setInt(4, fixture);
			pst.setInt(5, 0);
			pst.execute();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method used to set the score of an already created match.
	 * 
	 * @param homeTeam
	 *            the home team to search for in the database.
	 * @param awayTeam
	 *            the away team to search for in the database.
	 * @param homeScore
	 *            the score to be set for the home team.
	 * @param awayScore
	 *            the score to be set for the away team.
	 */
	public static void updateScore(Team homeTeam, Team awayTeam, int homeScore, int awayScore) {
		String insertScore = "UPDATE Matches SET home_team_goals = ?, away_team_goals = ?, is_played = ? WHERE home_team = ? AND away_team = ?";

		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pst = conn.prepareStatement(insertScore);
			pst.setInt(1, homeScore);
			pst.setInt(2, awayScore);
			pst.setInt(3, 1);
			pst.setString(4, homeTeam.getName());
			pst.setString(5, awayTeam.getName());
			pst.execute();

			if (homeScore > awayScore) {
				String home = "UPDATE Teams SET wins = ?, goals_for = ?, goals_against = ? WHERE name = ?";
				String away = "UPDATE Teams SET losses = ?, goals_for = ?, goals_against = ? WHERE name = ?";

				int homeWins = homeTeam.getWins();
				int homeGoalsFor = homeTeam.getGoalsFor();
				int homeGoalsAgainst = homeTeam.getGoalsAgainst();

				int awayLosses = awayTeam.getLosses();
				int awayGoalsFor = awayTeam.getGoalsFor();
				int awayGoalsAgainst = awayTeam.getGoalsAgainst();

				pst = conn.prepareStatement(home);
				pst.setInt(1, homeWins);
				pst.setInt(2, homeGoalsFor);
				pst.setInt(3, homeGoalsAgainst);
				pst.setString(4, homeTeam.getName());
				pst.execute();

				pst = conn.prepareStatement(away);
				pst.setInt(1, awayLosses);
				pst.setInt(2, awayGoalsFor);
				pst.setInt(3, awayGoalsAgainst);
				pst.setString(4, awayTeam.getName());
				pst.execute();
			} else if (awayScore > homeScore) {
				pst.close();
				String away = "UPDATE Teams SET wins = ?, goals_for = ?, goals_against = ? WHERE name = ?";
				String home = "UPDATE Teams SET losses = ?, goals_for = ?, goals_against = ? WHERE name = ?";

				int awayWins = awayTeam.getWins();
				int awayGoalsFor = awayTeam.getGoalsFor();
				int awayGoalsAgainst = awayTeam.getGoalsAgainst();

				int homeLosses = homeTeam.getLosses();
				int homeGoalsFor = homeTeam.getGoalsFor();
				int homeGoalsAgainst = homeTeam.getGoalsAgainst();
				pst = conn.prepareStatement(away);
				pst.setInt(1, awayWins);
				pst.setInt(2, awayGoalsFor);
				pst.setInt(3, awayGoalsAgainst);
				pst.setString(4, awayTeam.getName());
				pst.execute();

				pst = conn.prepareStatement(home);
				pst.setInt(1, homeLosses);
				pst.setInt(2, homeGoalsFor);
				pst.setInt(3, homeGoalsAgainst);
				pst.setString(4, homeTeam.getName());
				pst.execute();
			}

			else {
				pst.close();
				String draw = "UPDATE Teams SET draws = ?, goals_for = ?, goals_against = ? WHERE name = ?";
				int homeGoalsFor = homeTeam.getGoalsFor();
				int homeGoalsAgainst = homeTeam.getGoalsAgainst();
				int homeDraws = homeTeam.getDraws();

				int awayGoalsFor = awayTeam.getGoalsFor();
				int awayGoalsAgainst = awayTeam.getGoalsAgainst();
				int awayDraws = awayTeam.getDraws();

				pst = conn.prepareStatement(draw);
				pst.setInt(1, homeDraws);
				pst.setInt(2, homeGoalsFor);
				pst.setInt(3, homeGoalsAgainst);
				pst.setString(4, homeTeam.getName());
				pst.execute();

				pst.setInt(1, awayDraws);
				pst.setInt(2, awayGoalsFor);
				pst.setInt(3, awayGoalsAgainst);
				pst.setString(4, awayTeam.getName());
				pst.execute();
			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method used to check if a given fixture is finished or not.
	 * 
	 * @param fixture
	 *            number to check if finished.
	 * @return true for finished, false for unfinished.
	 */
	public static boolean checkIfFixtureFinished(int fixture) {
		int rowCount = 0;
		String checkFixture = "SELECT COUNT (*) FROM Matches WHERE fixture = ? AND is_played = 1";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmt = conn.prepareStatement(checkFixture);
			stmt.setInt(1, fixture);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			rowCount = rs.getInt(1);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method used to fill the teams of a league if the league exists on startup.
	 */
	public static void loginFillTeams() {
		String selectTeams = "SELECT * FROM Teams";

		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmt = conn.prepareStatement(selectTeams);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				Stadium stadium = getStadiumOfTeam(name);
				int wins = rs.getInt("wins");
				int draws = rs.getInt("draws");
				int losses = rs.getInt("losses");
				int goalsFor = rs.getInt("goals_for");
				int goalsAgainst = rs.getInt("goals_against");
				Team team = new Team(name, stadium);
				team.setWins(wins);
				team.setDraws(draws);
				team.setLosses(losses);
				team.setGoalsFor(goalsFor);
				team.setGoalsAgainst(goalsAgainst);
				LeagueManager.getInstance().insertTeam(team);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method used to fill the fixtures of a league if it exists on startup.
	 */
	public static void loginFillFixtures() {
		String selectMatches = "SELECT * FROM Matches WHERE fixture = ?";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement stmt = conn.prepareStatement(selectMatches);
			for (int i = 1; i <= 30; i++) {
				List<Match> matches = new ArrayList<Match>();
				int isFixtureFinished = -1;
				stmt.setInt(1, i);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Team homeTeam = null;
					Team awayTeam = null;
					String homeTeamName = rs.getString("home_team");
					String awayTeamName = rs.getString("away_team");

					for (Team t : LeagueManager.getInstance().getTeams()) {
						if (homeTeamName.equals(t.getName())) {
							homeTeam = t;
						}
						if (awayTeamName.equals(t.getName())) {
							awayTeam = t;
						}
					}
					isFixtureFinished = rs.getInt("is_played");
					Match match = new Match(homeTeam, awayTeam);
					if (isFixtureFinished == 1) {
						int homeScore = rs.getInt("home_team_goals");
						int awayScore = rs.getInt("away_team_goals");
						match.setHomeScore(homeScore);
						match.setAwayScore(awayScore);
						matches.add(match);
					} else {
						matches.add(match);
					}
				}
				Fixture fixture = new Fixture(matches, i);
				if (isFixtureFinished == 1) {
					fixture.setFinished(true);
					LeagueManager.getInstance().insertFixture(fixture);
				} else {
					LeagueManager.getInstance().insertFixture(fixture);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method used to disband the league. Dropping all the tables from the database.
	 */
	public static void disbandLeague() {
		String dropTeamsTable = "DROP TABLE Teams";
		String dropStadiumsTable = "DROP TABLE Stadiums";
		String dropMatchesTable = "DROP TABLE Matches";

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.execute(dropStadiumsTable);
				stmt.execute(dropMatchesTable);
				stmt.execute(dropTeamsTable);
				stmt.close();
				conn.close();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}