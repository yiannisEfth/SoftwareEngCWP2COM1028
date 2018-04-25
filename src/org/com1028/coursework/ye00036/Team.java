package org.com1028.coursework.ye00036;

public class Team {

	private String name;
	private int wins;
	private int draws;
	private int losses;
	private int goalsFor;
	private int goalsAgainst;
	private Stadium stadium;

	/**
	 * Constructor for a Team object taking in a name for the team and a stadium as
	 * its home base.
	 * 
	 * @param name
	 *            of the team.
	 * @param stadium
	 *            of the team.
	 */
	public Team(String name, Stadium stadium) {
		super();
		this.name = name;
		this.stadium = stadium;
	}

	// Getter for the wins of the team.
	public int getWins() {
		return wins;
	}

	// Setter for the wins of the team.
	public void setWins(int wins) {
		this.wins = wins;
	}

	// Getter for the draws of the team.
	public int getDraws() {
		return draws;
	}

	// Setter for the draws of the team.
	public void setDraws(int draws) {
		this.draws = draws;
	}

	// Getter for the losses of the team.
	public int getLosses() {
		return losses;
	}

	// Setter for the draws of the team.
	public void setLosses(int losses) {
		this.losses = losses;
	}

	// Getter for the goals scored by the team.
	public int getGoalsFor() {
		return goalsFor;
	}

	// Setter for the goals scored by the team.
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = this.getGoalsFor() + goalsFor;
	}

	// Getter for the goals scored against the team.
	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	// Setter for the goals scored against the team.
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = this.getGoalsAgainst() + goalsAgainst;
	}

	// Getter for the goal difference of a team.
	public int getGoalDifference() {
		return this.getGoalsFor() - this.getGoalsAgainst();
	}

	// Getter for the team's name.
	public String getName() {
		return name;
	}

	// Getter for the team's stadium.
	public Stadium getStadium() {
		return stadium;
	}

	// Get the points of the team.
	public int getPoints() {
		return (getWins() * 3 + getDraws());
	}

}