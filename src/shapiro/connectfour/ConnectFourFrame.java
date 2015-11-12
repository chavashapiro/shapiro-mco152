package shapiro.connectfour;

import java.awt.GridLayout;
import java.awt.Image;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConnectFourFrame extends JFrame {
	
	private JButton[] buttons;
	private JLabel[][] board; 
	private ImageIcon arrow;
	private ImageIcon yellow;
	private ImageIcon red;
	private ImageIcon empty;
	
	private int currentPlayer;
	
	public ConnectFourFrame() throws MalformedURLException {
		setTitle("Connect Four");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(7, 7));
		
		buttons = new JButton[7];
		arrow = new ImageIcon("arrow.png");
		arrow = new ImageIcon(new ImageIcon("arrow.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		for (int i = 0; i < 7; i++) {
			buttons[i] = new JButton(arrow);
			add(buttons[i]);
		}
		empty = new ImageIcon(new ImageIcon("emptyslot.png").getImage().getScaledInstance(98, 95, Image.SCALE_DEFAULT));
		board = new JLabel[6][7];
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 7; column++) {
				board[row][column] = new JLabel(empty);
				add(board[row][column]);
			}
		}
		yellow = new ImageIcon(new ImageIcon("yellowpiece.jfif").getImage().getScaledInstance(98, 95, Image.SCALE_DEFAULT));
		red = new ImageIcon(new ImageIcon("redpiece.png").getImage().getScaledInstance(98, 95, Image.SCALE_DEFAULT));
	
		currentPlayer = 1;
	}
	
	public static void main(String[] args) throws MalformedURLException {
		ConnectFourFrame connect4 = new ConnectFourFrame();
		connect4.setVisible(true);
	}
}
