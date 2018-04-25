package org.com1028.coursework.ye00036;

import java.util.List;

public class Fixture {
	private List<Match> matches;
	private int fixtureNumber;
	private boolean finished;

	/**
	 * Constructor to create a fixture object containing a list of matches and the
	 * fixture number and also settings the fixture finished attribute to false.
	 * 
	 * @param matches
	 *            list of matches for the fixture.
	 * @param fixtureNumber
	 *            the number of the fixture.
	 */
	public Fixture(List<Match> matches, int fixtureNumber) {
		super();
		this.matches = matches;
		this.fixtureNumber = fixtureNumber;
		this.finished = false;
	}

	// Returns the list of the fixture's matches.
	public List<Match> getMatches() {
		return matches;
	}

	// Getter for the fixture number.
	public int getFixtureNumber() {
		return fixtureNumber;
	}

	// Check if the fixture is finished or not.
	public boolean isFinished() {
		return finished;
	}

	// Set the fixture to finished or unfinished.
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}