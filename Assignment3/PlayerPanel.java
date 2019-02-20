package Assignment3;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.*;

public class PlayerPanel extends JPanel {
	private JLabel nameLabel, title; // To display labels and player info
	public JTextArea winLoss;
	private JTextField nameField; //player name
	public int wins, losses;
	private String name;
	private int playerNumber;//to determine if player one or tow
	/**
	 * Constructor
	 */

	public PlayerPanel(int playerNumber, String name) {
		setLayout(new BorderLayout());

		this.playerNumber = playerNumber;
		this.name = name;
		wins = 0;
		losses = 0;
		
		if(playerNumber == 1) {
			title = new JLabel("Player 1(X)");
		}
		else {
			title = new JLabel("Player 2(0)");
		}
		
		//create panel objects
		nameField = new JTextField(8);
		nameLabel = new JLabel("Name: ");
	
		winLoss = new JTextArea("Wins: " + wins +  "\nLosses: " + losses);
		winLoss.setEditable(false);
		
		
		// add objects to panel
		add(winLoss, BorderLayout.SOUTH);
		add(nameLabel, BorderLayout.WEST);
		add(nameField, BorderLayout.CENTER);
		
	
		add(title, BorderLayout.NORTH);
	}
}
