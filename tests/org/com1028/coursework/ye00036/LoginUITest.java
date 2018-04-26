package org.com1028.coursework.ye00036;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;

//JUnit tests for the Login GUI.
public class LoginUITest {

	@Test
	public void testUICreation() {
		LoginUI loginUI = new LoginUI();
		assertNotNull(loginUI);
	}

	@Test
	public void testGetFrame() {
		LoginUI loginUI = new LoginUI();
		JFrame frame = loginUI.getFrame();
		assertNotNull(frame);
	}
}
