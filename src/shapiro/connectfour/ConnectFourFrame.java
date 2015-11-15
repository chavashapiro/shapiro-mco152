package shapiro.connectfour;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConnectFourFrame extends JFrame {

	private JButton[] buttons;
	private JLabel[][] board;
	private ImageIcon arrow;
	private ImageIcon yellow;
	private ImageIcon red;
	private ImageIcon empty;

	private int currentPlayer;
	private GameBoard gameBoard;

	public ConnectFourFrame() {
		setTitle("Connect Four");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(7, 7));

		buttons = new JButton[7];
		arrow = new ImageIcon(new ImageIcon("arrow.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		for (int i = 0; i < 7; i++) {
			buttons[i] = new JButton(arrow);
			add(buttons[i]);
		}
		empty = new ImageIcon(new ImageIcon("emptyslot.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		board = new JLabel[6][7];
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 7; column++) {
				board[row][column] = new JLabel(empty);
				add(board[row][column]);
			}
		}
		yellow = new ImageIcon(new ImageIcon("yellowpiece.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		red = new ImageIcon(new ImageIcon("redpiece.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT));

		currentPlayer = 1;
		gameBoard = new GameBoard();

		for (int i = 0; i < buttons.length; i++) {
			int column = i;
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						int row = gameBoard.takeTurn(currentPlayer, column);
						if (currentPlayer == 1) {
							board[row][column].setIcon(yellow);
						} else {
							board[row][column].setIcon(red);
						}

						boolean full = gameBoard.isFull();
						if (full) {
							int playAgain = JOptionPane
									.showConfirmDialog(
											null,
											"No one wins! Would you like to play again?",
											"Game Over",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.INFORMATION_MESSAGE,
											new ImageIcon("fullboard.png"));
							if (playAgain == 0) {
								restartGame();
							} else {
								exitGame();
							}
						}
						boolean winner = gameBoard.isWinner();
						if (winner) {
							int playAgain = JOptionPane.showConfirmDialog(null,
									"You win! Would you like to play again?",
									"Game Over", JOptionPane.YES_NO_OPTION,
									JOptionPane.INFORMATION_MESSAGE,
									new ImageIcon("winner.jfif"));

							if (playAgain == 0) {
								restartGame();
							} else {
								exitGame();
							}
						}
						if (currentPlayer == 1) {
							currentPlayer = 2;
						} else {
							currentPlayer = 1;
						}
					} catch (ColumnFullException e) {
						JOptionPane.showMessageDialog(null,
								"Column full. Try another column.",
								"Column Full", JOptionPane.INFORMATION_MESSAGE,
								new ImageIcon("fullcolumn.jfif"));
					}
				}
			});
		}
	}

	public void restartGame() {
		dispose();
		new ConnectFourFrame().setVisible(true);
	}

	public void exitGame() {
		dispose();
	}

	public static void main(String[] args) {
		ConnectFourFrame connect4 = new ConnectFourFrame();
		connect4.setVisible(true);
	}
}
