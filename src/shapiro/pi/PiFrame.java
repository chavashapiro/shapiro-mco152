package shapiro.pi;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame {

	public PiFrame() {
		setTitle("Pi calcuator");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("pi calculating");
		Container content = getContentPane();

		content.add(label);

		PiCalculationThread thread = new PiCalculationThread(label);

		// tell operating system to start a new thread
		thread.start();

	}

	public static void main(String args[]) {
		new PiFrame().setVisible(true);
	}
}
