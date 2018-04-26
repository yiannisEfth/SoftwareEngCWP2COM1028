package org.com1028.coursework.ye00036;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class AdminMenuUI {
	private JFrame frame;

	// Method to run the admin menu UI.
	public void runAdminMenu() {
		AdminMenuUI adminMenu = new AdminMenuUI();
		adminMenu.frame.setVisible(true);

	}

	// Constructor for the class
	public AdminMenuUI() {
		initialize();
	}

	// Initialise the contents of the frame.
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 737, 545);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JLabel league_finished_label = new JLabel();

		JLabel create_league_label = new JLabel("Welcome Admin");
		create_league_label.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		create_league_label.setBounds(273, 19, 179, 34);
		getFrame().getContentPane().add(create_league_label);

		JLabel choose_option_label = new JLabel("Please Choose An Option");
		choose_option_label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		choose_option_label.setBounds(241, 92, 241, 34);
		getFrame().getContentPane().add(choose_option_label);

		JButton create_league_button = new JButton("Create League");
		// Listener for the create league button.
		create_league_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null,
							"A league already exists. Please fill the results or disband the league to start a new one.",
							"League already exists", JOptionPane.INFORMATION_MESSAGE);
				} else {
					CreateLeagueUI createLeague = new CreateLeagueUI();
					createLeague.runCreateLeagueView();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		create_league_button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		create_league_button.setBounds(40, 166, 304, 79);
		getFrame().getContentPane().add(create_league_button);

		JButton view_fixtures_button = new JButton("View Fixtures");
		// Listener for the view fixtures button.
		view_fixtures_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist. Please create a league first.",
							"League doesn't exist", JOptionPane.INFORMATION_MESSAGE);
				} else {
					ViewFixturesUI fixturesUI = new ViewFixturesUI();
					fixturesUI.runViewFixturesUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		view_fixtures_button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		view_fixtures_button.setBounds(393, 166, 304, 79);
		getFrame().getContentPane().add(view_fixtures_button);

		JButton fill_results_button = new JButton("Fill Results");
		fill_results_button.addActionListener(new ActionListener() {
			// Listener for the fill results button.
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist. Please create a league first.",
							"League doesn't exist", JOptionPane.INFORMATION_MESSAGE);
				} else if (SQLiteClass.checkIfFixtureFinished(30)) {
					JOptionPane.showMessageDialog(null, "The league has finished. No results to fill.",
							"League finished", JOptionPane.INFORMATION_MESSAGE);
				} else {
					FillFixturesUI ffui = new FillFixturesUI();
					ffui.runFillFixturesUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		fill_results_button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		fill_results_button.setBounds(40, 257, 304, 79);
		getFrame().getContentPane().add(fill_results_button);

		JButton view_team_statistics = new JButton("View Team Statistics");
		// Listener for the view team statistics button.
		view_team_statistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist. Please create a league first.",
							"League doesn't exist", JOptionPane.INFORMATION_MESSAGE);
				} else {
					TeamStatsUI tsUI = new TeamStatsUI();
					tsUI.runTeamStatsUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		view_team_statistics.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		view_team_statistics.setBounds(393, 257, 304, 79);
		getFrame().getContentPane().add(view_team_statistics);

		JButton view_standings_button = new JButton("View Standings");
		// Listener for the view standings button.
		view_standings_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist. Please create a league first.",
							"League doesn't exist", JOptionPane.INFORMATION_MESSAGE);
				} else {
					LeagueStandingsUI lsUI = new LeagueStandingsUI();
					lsUI.runLeagueStandingsUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		view_standings_button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		view_standings_button.setBounds(40, 348, 304, 79);
		getFrame().getContentPane().add(view_standings_button);

		JButton disband_league_button = new JButton("Disband League");
		// Listener for the disband league button.
		disband_league_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!SQLiteClass.checkIfLeagueExists()) {
					JOptionPane.showMessageDialog(null, "A league doesn't exist.", "League doesn't exist",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					int deleteLeague = JOptionPane.showConfirmDialog(null,
							"Are you sure you wish to delete the current league? All data will be lost.",
							"Delete League", JOptionPane.YES_NO_OPTION);
					if (deleteLeague == 0) {
						LeagueManager.getInstance().clearList();
						league_finished_label.setVisible(false);
						SQLiteClass.disbandLeague();
						SQLiteClass.createDB();
						JOptionPane.showMessageDialog(null, "The league has been deleted successfully",
								"League Deleted", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		disband_league_button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		disband_league_button.setBounds(393, 348, 304, 79);
		getFrame().getContentPane().add(disband_league_button);

		JButton exit_button = new JButton("Exit To Login");
		exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI login = new LoginUI();
				login.getFrame().setVisible(true);
				closeWindow();
			}
		});
		exit_button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		exit_button.setBounds(165, 438, 400, 50);
		getFrame().getContentPane().add(exit_button);
		// Display the league champion, if the league is finished.
		if (SQLiteClass.checkIfFixtureFinished(30)) {
			Collections.sort(LeagueManager.getInstance().getTeams(), new CustomTeamComparator());
			league_finished_label
					.setText("The league has finished the champion is: " + LeagueManager.getInstance().getTeams().get(0).getName());
			league_finished_label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			;
			league_finished_label.setBounds(130, 60, 680, 34);
			league_finished_label.setVisible(true);
			getFrame().getContentPane().add(league_finished_label);
		}
	}

	// Method to close the window.
	void closeWindow() {
		getFrame().setVisible(false);
		getFrame().dispose();
	}

	// Method to set the frame.
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	// Method to get the frame.
	public JFrame getFrame() {
		return frame;
	}
}