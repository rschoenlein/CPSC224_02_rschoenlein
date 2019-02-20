package Assignment3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToeGUI extends JFrame {
	private GamePanel gPanel; // Game panel
	private PlayerPanel pPanel1; // Player info panel
	private PlayerPanel pPanel2; // Player info panel
	private JLabel status; // Game state status

	JButton exitButton;
	JButton resetButton;
	JButton newGameButton;

	public TicTacToeGUI() {
		// Display a title.
		setTitle("Tic Tac Toe");
		setSize(500, 500);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager.
		setLayout(new BorderLayout());

		// Create the custom panels.
		gPanel = new GamePanel();
		JPanel panel = new JPanel();
		pPanel1 = new PlayerPanel(1, "Player 1");
		pPanel2 = new PlayerPanel(2, "Player 2");

		// Add the components to the content pane.
		panel.add(pPanel1, BorderLayout.EAST);
		panel.add(pPanel2, BorderLayout.WEST);
		add(panel, BorderLayout.NORTH);
		add(gPanel, BorderLayout.CENTER);

		addGameButtons();

		// Pack the contents of the window and display it.
		pack();
		setVisible(true);
	}

	public ButtonGroup addGameButtons() {

		newGameButton = new JButton("New Game");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");

		newGameButton.addActionListener(new GameListener());
		resetButton.addActionListener(new GameListener());
		exitButton.addActionListener(new GameListener());

		ButtonGroup bg = new ButtonGroup();
		bg.add(exitButton);
		bg.add(newGameButton);
		bg.add(resetButton);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(newGameButton, BorderLayout.LINE_START);
		panel.add(resetButton, BorderLayout.CENTER);
		panel.add(exitButton, BorderLayout.LINE_END);

		status = new JLabel("Welcome to Tic Tac Toe");
		panel.add(status, BorderLayout.SOUTH);
		add(panel, BorderLayout.SOUTH);

		return bg;
	}

	private class GameListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exitButton) {
				System.exit(0);
			}

			else if (e.getSource() == newGameButton) {
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						//gPanel.gameOver = false;
						gPanel.grid[r][c].setEnabled(true);
						gPanel.grid[r][c].setText("");
					}
				}

			}
			
			if(e.getSource() != resetButton){
				System.out.println(gPanel.gameOver);
				if(gPanel.gameOver) {
					//change status label and PlayerPanel wins/losses
					status.setText("Game Over" + " Winner is " + gPanel.winner);
				
					if(gPanel.winner == "Player 1")
					{
						pPanel1.wins++;
						pPanel2.losses++;
					}
					else {
						pPanel2.wins++;
						pPanel1.losses++;
						
					}
					
					pPanel1.winLoss.setText("Wins: " + pPanel1.wins +  "\nLosses: " + pPanel1.losses);
					pPanel2.winLoss.setText("Wins: " + pPanel2.wins +  "\nLosses: " + pPanel2.losses);
					pPanel1.setName(pPanel1.getNameField().getText());
					pPanel2.setName(pPanel2.getNameField().getText());
						
				}
				
				if(gPanel.turn == 1) {
					status.setText(pPanel1.getName() + " 's turn");
				}
				else {
					status.setText(pPanel2.getName() + " 's turn");
				}
			}
			
			
			else if (e.getSource() == resetButton) {
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						gPanel.grid[r][c].setText("");
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		new TicTacToeGUI();

	}
}