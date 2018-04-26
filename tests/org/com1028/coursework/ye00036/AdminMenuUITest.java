package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;

//JUnit tests for the Admin Menu GUI.
public class AdminMenuUITest {

	@Test
	public void testUICreation() {
		AdminMenuUI amUI = new AdminMenuUI();
		assertNotNull(amUI);
	}

	@Test
	public void testGetFrame() {
		AdminMenuUI amUI = new AdminMenuUI();
		JFrame frame = amUI.getFrame();
		assertNotNull(frame);
	}
}
