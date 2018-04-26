package org.com1028.coursework.ye00036;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.util.Collections;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeagueStandingsUI {

	private JFrame frame;
	private JTable table;

	// Method to run the LeagueStandingsUI.
	public void runLeagueStandingsUI() {
		try {
			LeagueStandingsUI lsUI = new LeagueStandingsUI();
			lsUI.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Constructor for the class.
	public LeagueStandingsUI() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 948, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel leaguestandingslbl = new JLabel("League Standings");
		leaguestandingslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		leaguestandingslbl.setHorizontalAlignment(SwingConstants.CENTER);
		leaguestandingslbl.setBounds(294, 6, 293, 55);
		frame.getContentPane().add(leaguestandingslbl);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 89, 936, 411);
		frame.getContentPane().add(scrollPane);
		// Table used to display the league standings, showing each team's stats.
		table = new JTable();
		table.setEnabled(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setRowSelectionAllowed(false);
		table.setRowHeight(24);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "#", "Name", "Points", "Wins", "Draws",
				"Losses", "Goals For", "Goals Against", "Goal Difference" }));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);

		JButton backtomenubtn = new JButton("Back To Menu");
		// Listener for the back to menu button.
		backtomenubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LeagueManager.getInstance().getIsAdmin()) {
					AdminMenuUI adminMenu = new AdminMenuUI();
					adminMenu.getFrame().setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				} else {
					GuestMenuUI gmUI = new GuestMenuUI();
					gmUI.runGuestMenuUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		backtomenubtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		backtomenubtn.setBounds(587, 22, 222, 36);
		frame.getContentPane().add(backtomenubtn);
		// Sorting the teams using the custom comparator and then displaying them in the
		// standings table.
		Collections.sort(LeagueManager.getInstance().getTeams(), new CustomTeamComparator());
		int i = 1;
		for (Team t : LeagueManager.getInstance().getTeams()) {
			Object[] team = { i, t.getName(), t.getPoints(), t.getWins(), t.getDraws(), t.getLosses(), t.getGoalsFor(),
					t.getGoalsAgainst(), t.getGoalDifference() };
			model.addRow(team);
			i++;
		}
	}

}
