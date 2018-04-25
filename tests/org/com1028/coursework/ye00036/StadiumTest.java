package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

//JUnit tests for the Stadium class
public class StadiumTest {

	private static Stadium stadium;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stadium = new Stadium("Big Stadium", 80000);
	}

	@Test
	public void getStadiumNameTtest() {
		String stadiumName = stadium.getName();
		assertEquals("Big Stadium", stadiumName);
	}

	@Test
	public void getStadiumCapacityTtest() {
		int stadiumCapacity = stadium.getCapacity();
		assertEquals(80000, stadiumCapacity);
	}

}
