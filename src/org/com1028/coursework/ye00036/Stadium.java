package org.com1028.coursework.ye00036;

public class Stadium {

	private String name;
	private int capacity;

	/**
	 * Constructor for the Stadium class taking in a name for the stadium and its
	 * capacity.
	 * 
	 * @param name
	 *            of the stadium.
	 * @param capacity
	 *            of the stadium.
	 */
	public Stadium(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	// Getter for the stadium's name.
	public String getName() {
		return name;
	}

	// Getter for the stadium's capacity.
	public int getCapacity() {
		return capacity;
	}

}