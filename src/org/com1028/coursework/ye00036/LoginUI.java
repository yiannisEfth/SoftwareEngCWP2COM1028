package org.com1028.coursework.ye00036;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginUI {
	private JFrame frame;
	private JTextField usernameField;
	private JButton loginButton;
	private JButton continueAsGuestButton;
	private JPasswordField passwordField;
	private JLabel loginTitleLbl;
	private JButton exitBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				runLogin();
			}
		});
	}

	// Method to run the TeamStatsUI.
	public static void runLogin() {
		try {
			LoginUI login = new LoginUI();
			login.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Constructor for the class. Checks whether the database exists, or how many
	// teams are entered or if the league exists and does the appropriate actions.
	public LoginUI() {
		LeagueManager.getInstance().clearList();
		LeagueManager.getInstance().setIsAdmin(false);
		if (!SQLiteClass.checkIfDbExists()) {
			SQLiteClass.createDB();
		} else if (SQLiteClass.getNumberOfTeams() > 0 && SQLiteClass.getNumberOfTeams() < 16) {
			SQLiteClass.fillTeamsUnfinishedLeague();
		} else if (SQLiteClass.checkIfDbExists() && SQLiteClass.checkIfLeagueExists()) {
			LeagueManager.getInstance().setLeagueExists(true);
			SQLiteClass.loginFillTeams();
			SQLiteClass.loginFillFixtures();
		}
		initialise();
	}

	// Initialise the contents of the frame.
	private void initialise() {
		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 563, 331);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		usernameField = new JTextField();
		usernameField.setBounds(145, 92, 130, 26);
		getFrame().getContentPane().add(usernameField);
		usernameField.setColumns(10);

		JLabel username_label = new JLabel("Username:");
		username_label.setBounds(52, 97, 81, 16);
		getFrame().getContentPane().add(username_label);

		JLabel password_label = new JLabel("Password:");
		password_label.setBounds(52, 148, 81, 16);
		getFrame().getContentPane().add(password_label);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		// Listener for the login button including validation of the credentials.
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getUsername().equals("user") && getPassword().equals("pass")) {
					LeagueManager.getInstance().setIsAdmin(true);
					AdminMenuUI adminMenu = new AdminMenuUI();
					adminMenu.runAdminMenu();
					frame.setVisible(false);
					frame.dispose();
				} else {
					showInvalidLogin();
				}
			}
		});
		loginButton.setBounds(280, 92, 169, 77);
		getFrame().getContentPane().add(loginButton);

		continueAsGuestButton = new JButton("Continue As Guest");
		// Listener for the continue as guest button.
		continueAsGuestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestMenuUI gmUI = new GuestMenuUI();
				gmUI.runGuestMenuUI();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		continueAsGuestButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		continueAsGuestButton.setBounds(155, 181, 239, 54);
		getFrame().getContentPane().add(continueAsGuestButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(145, 143, 130, 26);
		frame.getContentPane().add(passwordField);

		loginTitleLbl = new JLabel("Football League Managerment System");
		loginTitleLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		loginTitleLbl.setBounds(52, 13, 460, 67);
		frame.getContentPane().add(loginTitleLbl);

		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		exitBtn.setBounds(155, 247, 239, 54);
		frame.getContentPane().add(exitBtn);
	}

	// Getter for the username field.
	private String getUsername() {

		return usernameField.getText();
	}

	// Getter for the password field.
	private String getPassword() {

		return new String((passwordField.getPassword()));
	}

	// Method to display a message if there is an invalid login attempt.
	private void showInvalidLogin() {
		JOptionPane.showMessageDialog(null, "Invalid username or password entered! Please try again!", "Invalid Login",
				JOptionPane.WARNING_MESSAGE);
	}

	// Setter for the JFrame.
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	// Getter for the JFrame.
	public JFrame getFrame() {
		return frame;
	}
}