package org.com1028.coursework.ye00036;

import javax.swing.JFrame;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FillFixturesUI {
	private JFrame frame;
	private JTable table;
	private JTextField homeTeam1;
	private JTextField awayTeam1;
	private JTextField homeTeam2;
	private JTextField awayTeam2;
	private JTextField homeTeam3;
	private JTextField awayTeam3;
	private JTextField homeTeam4;
	private JTextField awayTeam6;
	private JTextField homeTeam5;
	private JTextField homeTeam6;
	private JTextField awayTeam5;
	private JTextField awayTeam4;
	private JTextField homeTeam8;
	private JTextField awayTeam7;
	private JTextField awayTeam8;
	private JTextField homeTeam7;
	private JButton backtomenubtn;

	// Method to run the createLeagueUI.
	public void runFillFixturesUI() {
		try {
			FillFixturesUI fillFixturesUI = new FillFixturesUI();
			fillFixturesUI.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Constructor for the class.
	public FillFixturesUI() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 902, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 487, 214);
		frame.getContentPane().add(scrollPane);
		// Table to show the teams playing each match.
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowSelectionAllowed(false);
		table.setRowHeight(24);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Home Team", "Away Team" }));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// ComboBox that allows the selection of a fixture to fill the matches for.
		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		comboBox.setBounds(168, 70, 83, 27);
		comboBox.setSelectedIndex(-1);
		frame.getContentPane().add(comboBox);

		JLabel fixtureLabel = new JLabel("Select a Fixture");
		fixtureLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		fixtureLabel.setBounds(10, 70, 161, 27);
		frame.getContentPane().add(fixtureLabel);

		JLabel fillFixtureLabel = new JLabel("Fill Fixtures");
		fillFixtureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fillFixtureLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
		fillFixtureLabel.setBounds(272, 11, 307, 60);
		frame.getContentPane().add(fillFixtureLabel);

		JLabel hometeamlbl = new JLabel("Home Team Score");
		hometeamlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hometeamlbl.setBounds(506, 104, 124, 27);
		frame.getContentPane().add(hometeamlbl);

		JLabel awayteamlbl = new JLabel("Away Team Score");
		awayteamlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		awayteamlbl.setBounds(674, 104, 124, 27);
		frame.getContentPane().add(awayteamlbl);

		homeTeam1 = new JTextField();
		homeTeam1.setBounds(541, 124, 37, 27);
		frame.getContentPane().add(homeTeam1);
		homeTeam1.setColumns(10);

		awayTeam1 = new JTextField();
		awayTeam1.setColumns(10);
		awayTeam1.setBounds(712, 124, 37, 27);
		frame.getContentPane().add(awayTeam1);

		homeTeam2 = new JTextField();
		homeTeam2.setColumns(10);
		homeTeam2.setBounds(541, 147, 37, 27);
		frame.getContentPane().add(homeTeam2);

		awayTeam2 = new JTextField();
		awayTeam2.setColumns(10);
		awayTeam2.setBounds(712, 147, 37, 27);
		frame.getContentPane().add(awayTeam2);

		homeTeam3 = new JTextField();
		homeTeam3.setColumns(10);
		homeTeam3.setBounds(541, 170, 37, 27);
		frame.getContentPane().add(homeTeam3);

		awayTeam3 = new JTextField();
		awayTeam3.setColumns(10);
		awayTeam3.setBounds(712, 170, 37, 27);
		frame.getContentPane().add(awayTeam3);

		homeTeam4 = new JTextField();
		homeTeam4.setColumns(10);
		homeTeam4.setBounds(541, 193, 37, 27);
		frame.getContentPane().add(homeTeam4);

		awayTeam6 = new JTextField();
		awayTeam6.setColumns(10);
		awayTeam6.setBounds(712, 240, 37, 27);
		frame.getContentPane().add(awayTeam6);

		homeTeam5 = new JTextField();
		homeTeam5.setColumns(10);
		homeTeam5.setBounds(541, 216, 37, 27);
		frame.getContentPane().add(homeTeam5);

		homeTeam6 = new JTextField();
		homeTeam6.setColumns(10);
		homeTeam6.setBounds(541, 240, 37, 27);
		frame.getContentPane().add(homeTeam6);

		awayTeam5 = new JTextField();
		awayTeam5.setColumns(10);
		awayTeam5.setBounds(712, 216, 37, 27);
		frame.getContentPane().add(awayTeam5);

		awayTeam4 = new JTextField();
		awayTeam4.setColumns(10);
		awayTeam4.setBounds(712, 193, 37, 27);
		frame.getContentPane().add(awayTeam4);

		homeTeam8 = new JTextField();
		homeTeam8.setColumns(10);
		homeTeam8.setBounds(541, 285, 37, 27);
		frame.getContentPane().add(homeTeam8);

		awayTeam7 = new JTextField();
		awayTeam7.setColumns(10);
		awayTeam7.setBounds(712, 263, 37, 27);
		frame.getContentPane().add(awayTeam7);

		awayTeam8 = new JTextField();
		awayTeam8.setColumns(10);
		awayTeam8.setBounds(712, 285, 37, 27);
		frame.getContentPane().add(awayTeam8);

		homeTeam7 = new JTextField();
		homeTeam7.setColumns(10);
		homeTeam7.setBounds(541, 263, 37, 27);
		frame.getContentPane().add(homeTeam7);

		JButton fillFixturesBtn = new JButton("Fill Fixture");
		// Listener for the fill fixture button in order to save the match scores for
		// the fixture. Includes validation.
		fillFixturesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fixtureChosen = Integer.parseInt(comboBox.getSelectedItem().toString());
				if (!checkFields()) {
					JOptionPane.showMessageDialog(null,
							"Invalid scores entered. Scores must be numbers in the range of 0-15", "Invalid Scores",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (fixtureChosen > 1) {
					if (!checkFixtureFinished(fixtureChosen - 1)) {
						JOptionPane.showMessageDialog(null,
								"You cannot fill the results for this fixture because a previous fixture hasn't been played yet",
								"Previous Fixtures Unfinished", JOptionPane.INFORMATION_MESSAGE);

					} else if (checkFixtureFinished(fixtureChosen)) {
						JOptionPane.showMessageDialog(null,
								"The matches for this fixture have already been set. Please select a different fixture",
								"Fixture already filled", JOptionPane.INFORMATION_MESSAGE);
					} else {
						fillFixture(fixtureChosen);
					}
				} else if (checkFixtureFinished(fixtureChosen)) {
					JOptionPane.showMessageDialog(null,
							"The matches for this fixture have already been set. Please select a different fixture",
							"Fixture already filled", JOptionPane.INFORMATION_MESSAGE);
				} else {
					fillFixture(fixtureChosen);
				}
			}
		});
		fillFixturesBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		fillFixturesBtn.setBounds(520, 361, 257, 60);
		frame.getContentPane().add(fillFixturesBtn);

		backtomenubtn = new JButton("Back To Admin Menu");
		// Back to admin menu button listener.
		backtomenubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenuUI adminMenu = new AdminMenuUI();
				adminMenu.getFrame().setVisible(true);
				frame.setVisible(false);
				frame.dispose();

			}
		});
		backtomenubtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backtomenubtn.setBounds(181, 363, 307, 58);
		frame.getContentPane().add(backtomenubtn);

		JButton lazyFillBtn = new JButton("Lazy Result Generator");
		// Listener for the lazy fill button. Generating scores for all matches of all
		// fixtures.
		lazyFillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Team t : LeagueManager.getInstance().getTeams()) {
					t.setWins(0);
					t.setDraws(0);
					t.setLosses(0);
					t.setGoalsFor(0);
					t.setGoalsAgainst(0);
				}
				SQLiteClass.resetTeams();
				for (Fixture f : LeagueManager.getInstance().getFixtures()) {
					f.setFinished(true);
					for (int i = 0; i < 8; i++) {
						int homeScoreGenerated = ThreadLocalRandom.current().nextInt(0, 16);
						int awayScoreGenerated = ThreadLocalRandom.current().nextInt(0, 16);
						f.getMatches().get(i).setHomeScore(homeScoreGenerated);
						f.getMatches().get(i).setAwayScore(awayScoreGenerated);
						f.getMatches().get(i).getHomeTeam().setGoalsFor(homeScoreGenerated);
						f.getMatches().get(i).getAwayTeam().setGoalsFor(awayScoreGenerated);
						f.getMatches().get(i).getHomeTeam().setGoalsAgainst(awayScoreGenerated);
						f.getMatches().get(i).getAwayTeam().setGoalsAgainst(homeScoreGenerated);

						int homeScore = f.getMatches().get(i).getHomeScore();
						int awayScore = f.getMatches().get(i).getAwayScore();
						Team homeTeam = f.getMatches().get(i).getHomeTeam();
						Team awayTeam = f.getMatches().get(i).getAwayTeam();
						if (homeScore > awayScore) {
							homeTeam.setWins(homeTeam.getWins() + 1);
							awayTeam.setLosses(awayTeam.getLosses() + 1);
						} else if (awayScore > homeScore) {
							awayTeam.setWins(awayTeam.getWins() + 1);
							homeTeam.setLosses(homeTeam.getLosses() + 1);
						} else {
							homeTeam.setDraws(homeTeam.getDraws() + 1);
							awayTeam.setDraws(awayTeam.getDraws() + 1);
						}
						SQLiteClass.updateScore(homeTeam, awayTeam, homeScore, awayScore);

					}
				}
				JOptionPane.showMessageDialog(null, "All match results for all fixtures have been generated.",
						"Fixtures filled", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lazyFillBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lazyFillBtn.setBounds(607, 20, 257, 60);
		frame.getContentPane().add(lazyFillBtn);
		// ComboBox listener to alter the table appropriately when a fixture is chosen.
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fixtureChosen = Integer.parseInt(comboBox.getSelectedItem().toString());
				if (checkFixtureFinished(fixtureChosen)) {
					JOptionPane.showMessageDialog(null,
							"The matches for this fixture have already been set. Please select a different fixture",
							"Fixture already filled", JOptionPane.INFORMATION_MESSAGE);
				} else {
					showFixtureMatches(model, fixtureChosen);
				}
			}
		});

	}

	/**
	 * Method to show the matches of a given fixture.
	 * 
	 * @param model
	 *            used to display each match in the table.
	 * @param fixture
	 *            chosen to show the matches for.
	 */
	public void showFixtureMatches(DefaultTableModel model, int fixture) {
		model.setRowCount(0);
		for (Fixture f : LeagueManager.getInstance().getFixtures()) {
			if (f.getFixtureNumber() == fixture) {
				for (int i = 0; i < f.getMatches().size(); i++) {
					String homeTeam = f.getMatches().get(i).getHomeTeam().getName();
					String awayTeam = f.getMatches().get(i).getAwayTeam().getName();
					Object[] match = { homeTeam, awayTeam };
					model.addRow(match);
				}
			}
		}
	}

	/**
	 * Method to fill match reults for a fixture.
	 * 
	 * @param fixture
	 *            used to fill the match results for.
	 */
	public void fillFixture(int fixture) {
		JTextField[] fields = { homeTeam1, awayTeam1, homeTeam2, awayTeam2, homeTeam3, awayTeam3, homeTeam4, awayTeam4,
				homeTeam5, awayTeam5, homeTeam6, awayTeam6, homeTeam7, awayTeam7, homeTeam8, awayTeam8 };
		for (Fixture f : LeagueManager.getInstance().getFixtures()) {
			if (f.getFixtureNumber() == fixture) {
				f.setFinished(true);
				for (int i = 1; i < 9; i++) {
					f.getMatches().get(i - 1).setHomeScore(Integer.parseInt(fields[i * 2 - 2].getText()));
					f.getMatches().get(i - 1).setAwayScore(Integer.parseInt(fields[i * 2 - 1].getText()));
					f.getMatches().get(i - 1).getHomeTeam().setGoalsFor(Integer.parseInt(fields[i * 2 - 2].getText()));
					f.getMatches().get(i - 1).getAwayTeam().setGoalsFor(Integer.parseInt(fields[i * 2 - 1].getText()));
					f.getMatches().get(i - 1).getHomeTeam()
							.setGoalsAgainst(Integer.parseInt(fields[i * 2 - 1].getText()));
					f.getMatches().get(i - 1).getAwayTeam()
							.setGoalsAgainst(Integer.parseInt(fields[i * 2 - 2].getText()));

					int homeScore = f.getMatches().get(i - 1).getHomeScore();
					int awayScore = f.getMatches().get(i - 1).getAwayScore();
					Team homeTeam = f.getMatches().get(i - 1).getHomeTeam();
					Team awayTeam = f.getMatches().get(i - 1).getAwayTeam();
					if (homeScore > awayScore) {
						homeTeam.setWins(homeTeam.getWins() + 1);
						awayTeam.setLosses(awayTeam.getLosses() + 1);
					} else if (awayScore > homeScore) {
						awayTeam.setWins(awayTeam.getWins() + 1);
						homeTeam.setLosses(homeTeam.getLosses() + 1);
					} else {
						homeTeam.setDraws(homeTeam.getDraws() + 1);
						awayTeam.setDraws(awayTeam.getDraws() + 1);
					}
					SQLiteClass.updateScore(homeTeam, awayTeam, homeScore, awayScore);
				}
			}
		}
		JOptionPane.showMessageDialog(null, "The matches for this fixture have been successfully filled.",
				"Fixture filled", JOptionPane.INFORMATION_MESSAGE);
		for (int i = 0; i < fields.length; i++) {
			fields[i].setText("");
		}
	}

	/**
	 * Method to check if all fields have appropriate input in order to fill match
	 * scores.
	 * 
	 * @return true if inputs are valid.
	 */
	public boolean checkFields() {
		boolean toReturn = false;
		JTextField[] fields = { homeTeam1, awayTeam1, homeTeam2, awayTeam2, homeTeam3, awayTeam3, homeTeam4, awayTeam4,
				homeTeam5, awayTeam5, homeTeam6, awayTeam6, homeTeam7, awayTeam7, homeTeam8, awayTeam8 };

		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getText().matches("\\b(\\d|1[0-5])\\b")) {
				toReturn = true;
			} else {
				toReturn = false;
				break;
			}
		}
		return toReturn;
	}

	/**
	 * Method to check if a given fixture is finished.
	 * 
	 * @param fixtureNumber
	 *            to check if finished.
	 * @return true if finished.
	 */
	public boolean checkFixtureFinished(int fixtureNumber) {
		boolean toReturn = false;
		for (Fixture f : LeagueManager.getInstance().getFixtures()) {
			if (f.getFixtureNumber() == fixtureNumber) {
				toReturn = f.isFinished();
			}
		}
		return toReturn;
	}
}