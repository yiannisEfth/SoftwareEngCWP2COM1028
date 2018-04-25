package org.com1028.coursework.ye00036;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class TeamStatsUI {

	private JFrame frame;
	private LeagueManager leagueManager = null;
	private JTable table;
	private JLabel teamnamebox;
	private JLabel winsbox;
	private JLabel drawsbox;
	private JLabel lossesbox;
	private JLabel goalsforbox;
	private JLabel goalsagainstbox;
	private JLabel goaldifferencebox;
	private JLabel pointsbox;
	private JLabel stadiumbox;
	private JLabel capacitybox;

	// Method to run the TeamStatsUI.
	public void runTeamStatsUI() {
		try {
			TeamStatsUI tsUI = new TeamStatsUI(leagueManager);
			tsUI.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Constructor for the class.
	public TeamStatsUI(final LeagueManager leagueManager) {
		this.leagueManager = leagueManager;
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 739, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel titlelbl = new JLabel("View Team Statistics");
		titlelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		titlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		titlelbl.setBounds(242, 6, 302, 60);
		frame.getContentPane().add(titlelbl);

		JLabel selectteamlbl = new JLabel("Select a team:");
		selectteamlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		selectteamlbl.setBounds(260, 59, 133, 36);
		frame.getContentPane().add(selectteamlbl);
		// ComboBox used to select a team to view the statistics for.
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(394, 68, 133, 27);
		frame.getContentPane().add(comboBox);

		JLabel teamnamelbl = new JLabel("Name:");
		teamnamelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		teamnamelbl.setBounds(97, 107, 77, 27);
		frame.getContentPane().add(teamnamelbl);

		teamnamebox = new JLabel("");
		teamnamebox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		teamnamebox.setBounds(186, 109, 183, 27);
		frame.getContentPane().add(teamnamebox);

		JLabel lblWins = new JLabel("Wins:");
		lblWins.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblWins.setBounds(109, 165, 65, 27);
		frame.getContentPane().add(lblWins);

		winsbox = new JLabel("");
		winsbox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		winsbox.setBounds(186, 165, 65, 27);
		frame.getContentPane().add(winsbox);

		drawsbox = new JLabel("");
		drawsbox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		drawsbox.setBounds(186, 218, 65, 27);
		frame.getContentPane().add(drawsbox);

		JLabel drawslbl = new JLabel("Draws:");
		drawslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		drawslbl.setBounds(92, 218, 89, 27);
		frame.getContentPane().add(drawslbl);

		JLabel losseslbl = new JLabel("Losses:");
		losseslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		losseslbl.setBounds(88, 268, 89, 27);
		frame.getContentPane().add(losseslbl);

		lossesbox = new JLabel("");
		lossesbox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lossesbox.setBounds(186, 268, 65, 27);
		frame.getContentPane().add(lossesbox);

		JLabel goalsforlbl = new JLabel("Goals For:");
		goalsforlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		goalsforlbl.setBounds(467, 117, 121, 27);
		frame.getContentPane().add(goalsforlbl);

		goalsforbox = new JLabel("");
		goalsforbox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		goalsforbox.setBounds(592, 119, 71, 27);
		frame.getContentPane().add(goalsforbox);

		JLabel lblGoalsAgainst = new JLabel("Goals Against:");
		lblGoalsAgainst.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblGoalsAgainst.setBounds(413, 165, 175, 27);
		frame.getContentPane().add(lblGoalsAgainst);

		goalsagainstbox = new JLabel("");
		goalsagainstbox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		goalsagainstbox.setBounds(592, 165, 71, 27);
		frame.getContentPane().add(goalsagainstbox);

		JLabel goaldifferencelbl = new JLabel("Goal Difference:");
		goaldifferencelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		goaldifferencelbl.setBounds(393, 218, 195, 27);
		frame.getContentPane().add(goaldifferencelbl);

		goaldifferencebox = new JLabel("");
		goaldifferencebox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		goaldifferencebox.setBounds(592, 218, 71, 27);
		frame.getContentPane().add(goaldifferencebox);

		JLabel pointslbl = new JLabel("Points:");
		pointslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		pointslbl.setBounds(506, 268, 82, 27);
		frame.getContentPane().add(pointslbl);

		pointsbox = new JLabel("");
		pointsbox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		pointsbox.setBounds(592, 268, 65, 27);
		frame.getContentPane().add(pointsbox);

		JLabel stadiumlbl = new JLabel("Stadium:");
		stadiumlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		stadiumlbl.setBounds(73, 320, 106, 27);
		frame.getContentPane().add(stadiumlbl);

		stadiumbox = new JLabel("");
		stadiumbox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		stadiumbox.setBounds(186, 320, 207, 27);
		frame.getContentPane().add(stadiumbox);

		JLabel capacitylbl = new JLabel("Capacity:");
		capacitylbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		capacitylbl.setBounds(477, 320, 111, 27);
		frame.getContentPane().add(capacitylbl);

		capacitybox = new JLabel("");
		capacitybox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		capacitybox.setBounds(592, 320, 96, 27);
		frame.getContentPane().add(capacitybox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 359, 666, 242);
		frame.getContentPane().add(scrollPane);
		// Table used to display the match played each fixture for the selected team.
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(20);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Fixture", "Home Team", "Away Team", "Home Score", "Away Score", "Stadium" }));

		JButton backtomenubtn = new JButton("Back To Menu");
		// Listener for the back to menu button.
		backtomenubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (leagueManager.getIsAdmin()) {
					AdminMenuUI adminMenu = new AdminMenuUI(leagueManager);
					adminMenu.getFrame().setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				} else {
					GuestMenuUI gmUI = new GuestMenuUI(leagueManager);
					gmUI.runGuestMenuUI();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		backtomenubtn.setBounds(53, 25, 168, 36);
		frame.getContentPane().add(backtomenubtn);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// Adds the names of each team as comboBox items to be selected by the user.
		for (Team t : leagueManager.getTeams()) {
			comboBox.addItem(t.getName());
		}
		comboBox.setSelectedIndex(-1);
		// Listener for the comboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedTeam = comboBox.getSelectedItem().toString();
				model.setRowCount(0);
				updateLabels(selectedTeam);
				fillTable(model, selectedTeam);
			}
		});
	}

	/**
	 * Method used to fill the table with the selected team's matches. If the
	 * fixture isn't played yet, let the user know.
	 * 
	 * @param model
	 *            used to display the data into the table.
	 * @param selectedTeam
	 *            the team name fetched from the comboBox to view the matches for.
	 */
	public void fillTable(DefaultTableModel model, String selectedTeam) {
		for (Fixture f : leagueManager.getFixtures()) {
			for (Match m : f.getMatches()) {
				if (m.getHomeTeam().getName() == selectedTeam || m.getAwayTeam().getName() == selectedTeam) {
					if (f.isFinished()) {
						int fixture = f.getFixtureNumber();
						String homeTeam = m.getHomeTeam().getName();
						String awayTeam = m.getAwayTeam().getName();
						int homeScore = m.getHomeScore();
						int awayScore = m.getAwayScore();
						String stadium = m.getHomeTeam().getStadium().getName();
						Object[] data = { fixture, homeTeam, awayTeam, homeScore, awayScore, stadium };
						model.addRow(data);
					} else {
						int fixture = f.getFixtureNumber();
						String homeTeam = m.getHomeTeam().getName();
						String awayTeam = m.getAwayTeam().getName();
						String homeScore = "Not yet played";
						String awayScore = "Not yet played";
						String stadium = m.getHomeTeam().getStadium().getName();
						Object[] data = { fixture, homeTeam, awayTeam, homeScore, awayScore, stadium };
						model.addRow(data);
					}
				}
			}
		}
	}

	/**
	 * Method used to populate the fields used with appropriate information for the
	 * selected team.
	 * 
	 * @param selectedTeam
	 *            team selected from the comboBox to display the statistics for.
	 */
	public void updateLabels(String selectedTeam) {
		for (Team t : leagueManager.getTeams()) {
			if (t.getName() == selectedTeam) {
				teamnamebox.setText(t.getName());
				winsbox.setText(String.valueOf(t.getWins()));
				drawsbox.setText(String.valueOf(t.getDraws()));
				lossesbox.setText(String.valueOf(t.getLosses()));
				goalsforbox.setText(String.valueOf(t.getGoalsFor()));
				goalsagainstbox.setText(String.valueOf(t.getGoalsAgainst()));
				goaldifferencebox.setText(String.valueOf(t.getGoalDifference()));
				pointsbox.setText(String.valueOf(t.getPoints()));
				stadiumbox.setText(String.valueOf(t.getStadium().getName()));
				capacitybox.setText(String.valueOf(t.getStadium().getCapacity()));
			}
		}
	}
}
