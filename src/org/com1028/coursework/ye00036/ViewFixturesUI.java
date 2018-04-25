package org.com1028.coursework.ye00036;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewFixturesUI {

	private JFrame frame;
	private LeagueManager leagueManager = null;
	private JTable table;

	// Method to run the TeamStatsUI.
	public void runViewFixturesUI() {
		try {
			ViewFixturesUI fixturesUI = new ViewFixturesUI(leagueManager);
			fixturesUI.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Constructor for the class.
	public ViewFixturesUI(final LeagueManager leagueManager) {
		this.leagueManager = leagueManager;
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel viewfixtureslbl = new JLabel("View Fixtures");
		viewfixtureslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		viewfixtureslbl.setHorizontalAlignment(SwingConstants.CENTER);
		viewfixtureslbl.setBounds(270, 6, 226, 66);
		frame.getContentPane().add(viewfixtureslbl);

		JLabel selectfixturelbl = new JLabel("Select a fixture:");
		selectfixturelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		selectfixturelbl.setBounds(225, 61, 195, 30);
		frame.getContentPane().add(selectfixturelbl);
		// ComboBox used to select for which fixture to see the matches for.
		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		comboBox.setBounds(168, 70, 83, 27);
		comboBox.setBounds(415, 66, 76, 27);
		comboBox.setSelectedIndex(-1);
		frame.getContentPane().add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 112, 762, 217);
		frame.getContentPane().add(scrollPane);
		// Table used to display the matches for a selected fixture.
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setRowHeight(24);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Home Team", "Away Team", "Home Score", "Away Score", "Stadium" }));

		JButton backtoadminmenulbl = new JButton("Back To Menu");
		// Listener for the back to menu button.
		backtoadminmenulbl.addActionListener(new ActionListener() {
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
		backtoadminmenulbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		backtoadminmenulbl.setBounds(489, 25, 205, 36);
		frame.getContentPane().add(backtoadminmenulbl);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// ComboBox listener to get the fixture chosen to view the matches for.
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fixtureChosen = Integer.parseInt(comboBox.getSelectedItem().toString());
				fillTable(model, fixtureChosen);
			}
		});
	}

	/**
	 * Method used to fill the table with the matches of a fixture. Showing the
	 * results of each match. If the fixture still hasn't been played. The user is
	 * notified through the table.
	 * 
	 * @param model
	 * @param fixtureNumber
	 */
	public void fillTable(DefaultTableModel model, int fixtureNumber) {
		model.setRowCount(0);
		for (Fixture f : leagueManager.getFixtures()) {
			if (f.getFixtureNumber() == fixtureNumber) {
				if (f.isFinished()) {
					for (Match m : f.getMatches()) {
						String homeTeam = m.getHomeTeam().getName();
						String awayTeam = m.getAwayTeam().getName();
						int homeScore = m.getHomeScore();
						int awayScore = m.getAwayScore();
						String stadium = m.getHomeTeam().getStadium().getName();
						Object[] data = { homeTeam, awayTeam, homeScore, awayScore, stadium };
						model.addRow(data);
					}
				} else {
					for (Match m : f.getMatches()) {
						String homeTeam = m.getHomeTeam().getName();
						String awayTeam = m.getAwayTeam().getName();
						String homeScore = "Not yet played";
						String awayScore = "Not yet played";
						String stadium = m.getHomeTeam().getStadium().getName();
						Object[] data = { homeTeam, awayTeam, homeScore, awayScore, stadium };
						model.addRow(data);
					}
				}
			}
		}
	}
}
