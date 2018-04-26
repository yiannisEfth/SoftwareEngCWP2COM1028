package org.com1028.coursework.ye00036;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Collections;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestMenuUI {

	private JFrame frame;

	// Method to run the runGuestMenuUI.
	public void runGuestMenuUI() {
		try {
			GuestMenuUI gmUI = new GuestMenuUI();
			gmUI.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Constructor for the class.
	public GuestMenuUI() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 555, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel welcomeGuestLbl = new JLabel("Welcome Guest");
		welcomeGuestLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeGuestLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		welcomeGuestLbl.setBounds(124, 6, 319, 54);
		frame.getContentPane().add(welcomeGuestLbl);

		JLabel selectOptionLbl = new JLabel("Please Choose An Option");
		selectOptionLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		selectOptionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		selectOptionLbl.setBounds(119, 94, 324, 54);
		frame.getContentPane().add(selectOptionLbl);

		JButton viewFixturesBtn = new JButton("View Fixtures");
		// Listener for the view fixtures button.
		viewFixturesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist.", "League doesn't exist",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					ViewFixturesUI fixturesUI = new ViewFixturesUI();
					fixturesUI.runViewFixturesUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		viewFixturesBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		viewFixturesBtn.setBounds(129, 155, 297, 54);
		frame.getContentPane().add(viewFixturesBtn);
		// Listener for the view standings button.
		JButton viewStandingsBtn = new JButton("View Standings");
		viewStandingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist.", "League doesn't exist",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					LeagueStandingsUI lsUI = new LeagueStandingsUI();
					lsUI.runLeagueStandingsUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		viewStandingsBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		viewStandingsBtn.setBounds(129, 225, 297, 54);
		frame.getContentPane().add(viewStandingsBtn);
		// Listener for the view team statistics button.
		JButton viewTeamStatsBtn = new JButton("View Team Statistics");
		viewTeamStatsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist.", "League doesn't exist",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					TeamStatsUI tsUI = new TeamStatsUI();
					tsUI.runTeamStatsUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		viewTeamStatsBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		viewTeamStatsBtn.setBounds(129, 291, 297, 54);
		frame.getContentPane().add(viewTeamStatsBtn);
		// Listener for the exit to login button.
		JButton btnExitToLogin = new JButton("Exit To Login");
		btnExitToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI login = new LoginUI();
				login.getFrame().setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnExitToLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnExitToLogin.setBounds(129, 357, 297, 54);
		frame.getContentPane().add(btnExitToLogin);
		// Check if fixture 30 is finished therefore declaring a champion and displaying
		// it to the user.
		if (SQLiteClass.checkIfFixtureFinished(30)) {
			Collections.sort(LeagueManager.getInstance().getTeams(), new CustomTeamComparator());
			JLabel league_finished_label = new JLabel(
					"The league has finished the champion is: " + LeagueManager.getInstance().getTeams().get(0).getName());
			league_finished_label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			league_finished_label.setBounds(40, 45, 490, 54);
			frame.getContentPane().add(league_finished_label);
		}
	}
}
