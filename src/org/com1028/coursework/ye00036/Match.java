package org.com1028.coursework.ye00036;

public class Match {

	private Team homeTeam;
	private Team awayTeam;
	private int homeScore;
	private int awayScore;
	private Stadium stadium;

	/**
	 * Constructor taking in 2 teams to create a match and settings the stadium as
	 * the base of the home team.
	 * 
	 * @param homeTeam
	 *            the team to play at home.
	 * @param awayTeam
	 *            the team to play away.
	 */
	public Match(Team homeTeam, Team awayTeam) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.stadium = homeTeam.getStadium();
	}

	// Getter for the home team score.
	public int getHomeScore() {
		return homeScore;
	}

	// Setter for the home team score.
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	// Getter for the away team score.
	public int getAwayScore() {
		return awayScore;
	}

	// Setter for the away team score.
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	// Getter for the home team.
	public Team getHomeTeam() {
		return homeTeam;
	}

	// Getter for the away team.
	public Team getAwayTeam() {
		return awayTeam;
	}

	// Getter for the stadium which is the base of the home team.
	public Stadium getStadium() {
		return stadium;
	}

}