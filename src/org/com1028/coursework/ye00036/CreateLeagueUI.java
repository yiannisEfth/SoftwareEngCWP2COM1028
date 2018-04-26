package org.com1028.coursework.ye00036;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class CreateLeagueUI {
	private JFrame frame;
	private JTextField teamNameInput;
	private JTextField StadiumInput;
	private JTextField capacityInput;
	private JButton backToAdminBtn;
	private JTable table;
	private JScrollPane scrollPane;

	// Method to run the createLeagueUI.
	public void runCreateLeagueView() {
		try {
			CreateLeagueUI leagueView = new CreateLeagueUI();
			leagueView.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Constructor for the class.
	public CreateLeagueUI() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 915, 608);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 899, 423);
		frame.getContentPane().add(scrollPane);
		// Table to display the information for each created team.
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(24);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Team Name", "Stadium Name", "Capacity" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		teamNameInput = new JTextField();
		teamNameInput.setFont(new Font("Tahoma", Font.PLAIN, 22));
		teamNameInput.setBounds(207, 16, 216, 38);
		frame.getContentPane().add(teamNameInput);
		teamNameInput.setColumns(10);

		JLabel team_name_label = new JLabel("Team Name:");
		team_name_label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		team_name_label.setBounds(56, 11, 127, 38);
		frame.getContentPane().add(team_name_label);

		StadiumInput = new JTextField();
		StadiumInput.setFont(new Font("Tahoma", Font.PLAIN, 22));
		StadiumInput.setColumns(10);
		StadiumInput.setBounds(207, 65, 216, 38);
		frame.getContentPane().add(StadiumInput);

		JLabel stadium_label = new JLabel("Stadium Name:");
		stadium_label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stadium_label.setBounds(33, 65, 150, 38);
		frame.getContentPane().add(stadium_label);

		JLabel seats_label = new JLabel("Stadium Capacity:");
		seats_label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		seats_label.setBounds(10, 114, 175, 38);
		frame.getContentPane().add(seats_label);

		capacityInput = new JTextField();
		capacityInput.setFont(new Font("Tahoma", Font.PLAIN, 22));
		capacityInput.setColumns(10);
		capacityInput.setBounds(207, 114, 216, 38);
		frame.getContentPane().add(capacityInput);

		JButton save_team_btn = new JButton("Insert Team");
		// Listener for the insert team button in order to insert a team to the league.
		// Also validating all fields and checking
		// whether the team already exists.
		save_team_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean teamExists = false;
				for (Team t : LeagueManager.getInstance().getTeams()) {
					if (t.getName().equals(teamNameInput.getText())) {
						teamExists = true;
					}
				}
				if (teamExists) {
					JOptionPane.showMessageDialog(null,
							"The team you entered already exists in the league. Please enter a different name.",
							"Team Exists", JOptionPane.WARNING_MESSAGE);
				} else if (!teamNameInput.getText().matches("^[a-z0-9]+(?:[ _.-][a-z0-9]+)*$")) {
					JOptionPane.showMessageDialog(null,
							"Invalid team name entered. Team names can contain letters, numbers and single white spaces.",
							"Invalid Team Name", JOptionPane.WARNING_MESSAGE);
				} else if (!StadiumInput.getText().matches("^[a-zA-Z0-9]*$")
						|| !capacityInput.getText().matches("[3-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]"
								+ "{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|[1-7][0-9]{4}|80000")) {
					JOptionPane.showMessageDialog(null,
							"Invalid stadium name or capacity entered. Stadium names can only contain letters and numbers. Stadium capacity must be "
									+ "between 300 and 80000",
							"Invalid Stadium", JOptionPane.WARNING_MESSAGE);
				} else {
					String teamToInsert = teamNameInput.getText();
					String stadiumName = StadiumInput.getText();
					int stadiumCapacity = Integer.parseInt(capacityInput.getText());
					SQLiteClass.insertTeam(teamToInsert, stadiumName, stadiumCapacity);
					Stadium stadium = new Stadium(stadiumName, stadiumCapacity);
					Team team = new Team(teamToInsert, stadium);
					LeagueManager.getInstance().insertTeam(team);
					JOptionPane.showMessageDialog(null, "Team Inserted Successfully");
					updateTable(model);
					teamNameInput.setText("");
					StadiumInput.setText("");
					capacityInput.setText("");
					// If 16 teams are entered. Return to the admin menu.
					if (SQLiteClass.checkIfLeagueExists()) {
						JOptionPane.showMessageDialog(null,
								"16 Teams have been entered and the league has been created. Returning to admin menu.",
								"League Creation Complete", JOptionPane.INFORMATION_MESSAGE);
						LeagueManager.getInstance().generateFixtures();
						AdminMenuUI adminMenu = new AdminMenuUI();
						adminMenu.runAdminMenu();
						frame.setVisible(false);
						frame.dispose();
					}

				}

			}
		});
		save_team_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save_team_btn.setBounds(433, 11, 138, 141);
		frame.getContentPane().add(save_team_btn);

		backToAdminBtn = new JButton("Back To Admin Menu");
		// Listener for the back to admin menu button.
		backToAdminBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				AdminMenuUI adminMenu = new AdminMenuUI();
				adminMenu.getFrame().setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		backToAdminBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backToAdminBtn.setBounds(580, 11, 201, 141);
		frame.getContentPane().add(backToAdminBtn);
		
		JButton btnNewButton = new JButton("<html>Lazy<br>Team<br>Generator</html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeagueManager.getInstance().clearList();
				model.setRowCount(0);
				Stadium stadium1 = new Stadium("Team1 Stadium",23000);
				Stadium stadium2 = new Stadium("Team2 Stadium",43000);
				Stadium stadium3 = new Stadium("Team3 Stadium",35000);
				Stadium stadium4 = new Stadium("Team4 Stadium",40000);
				Stadium stadium5 = new Stadium("Team5 Stadium",15000);
				Stadium stadium6 = new Stadium("Team6 Stadium",60000);
				Stadium stadium7 = new Stadium("Team7 Stadium",80000);
				Stadium stadium8 = new Stadium("Team8 Stadium",44500);
				Stadium stadium9 = new Stadium("Team9 Stadium",75000);
				Stadium stadium10 = new Stadium("Team10 Stadium",5000);
				Stadium stadium11 = new Stadium("Team11 Stadium",800);
				Stadium stadium12 = new Stadium("Team12 Stadium",33000);
				Stadium stadium13 = new Stadium("Team13 Stadium",43000);
				Stadium stadium14 = new Stadium("Team14 Stadium",60000);
				Stadium stadium15 = new Stadium("Team15 Stadium",2000);
				Stadium stadium16 = new Stadium("Team16 Stadium",1590);
				Stadium[] stadiums = {stadium1, stadium2, stadium3, stadium4, stadium5,stadium6, stadium7, stadium8, stadium9, stadium10, stadium11, stadium12, stadium13, stadium14, stadium15, stadium16};
				String[] teamNames = {"Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9", "Team10", "Team11", "Team12", "Team13", "Team14", "Team15", "Team16"};
				SQLiteClass.disbandLeague();
				SQLiteClass.createDB();
				for(int i = 0; i < 16; i++) {
					Team team = new Team(teamNames[i], stadiums[i]);
					LeagueManager.getInstance().insertTeam(team);
					SQLiteClass.insertTeam(teamNames[i], stadiums[i].getName(), stadiums[i].getCapacity());
				}
				loadTable(model);
				JOptionPane.showMessageDialog(null,
						"16 Teams have been entered and the league has been created. Returning to admin menu.",
						"League Creation Complete", JOptionPane.INFORMATION_MESSAGE);
				LeagueManager.getInstance().generateFixtures();
				AdminMenuUI adminMenu = new AdminMenuUI();
				adminMenu.runAdminMenu();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(782, 11, 127, 140);
		frame.getContentPane().add(btnNewButton);

		loadTable(model);
	}

	/**
	 * Method to load the table with data already entered and loaded from the
	 * database.
	 * 
	 * @param model
	 *            used to add the data to the table's rows.
	 */
	public void loadTable(DefaultTableModel model) {
		for (int i = 0; i < LeagueManager.getInstance().getTeams().size(); i++) {
			String name = LeagueManager.getInstance().getTeams().get(i).getName();
			String stadiumName = LeagueManager.getInstance().getTeams().get(i).getStadium().getName();
			int capacity = LeagueManager.getInstance().getTeams().get(i).getStadium().getCapacity();
			Object[] data = { name, stadiumName, capacity };
			model.addRow(data);
		}
	}

	/**
	 * Method to update the table by inserting the new data entered.
	 * 
	 * @param model
	 *            used to add the data to the table's rows.
	 */
	public void updateTable(DefaultTableModel model) {
		int lastTeam = LeagueManager.getInstance().getTeams().size() - 1;
		String name = LeagueManager.getInstance().getTeams().get(lastTeam).getName();
		String stadiumName = LeagueManager.getInstance().getTeams().get(lastTeam).getStadium().getName();
		int capacity = LeagueManager.getInstance().getTeams().get(lastTeam).getStadium().getCapacity();
		Object[] data = { name, stadiumName, capacity };
		model.addRow(data);

	}
}