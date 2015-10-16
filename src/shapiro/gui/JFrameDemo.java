package shapiro.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {

	private JLabel label1;
	private JLabel label2;
	private JButton button1;
	private JTextField textField;

	public JFrameDemo() {
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("All this text gets shown all the time.");
		add(label1);
		label2 = new JLabel("another label");
		add(label2);
		textField = new JTextField();
		Dimension dim = new Dimension(200, 25);
		textField.setMaximumSize(dim);
		add(textField);
		button1 = new JButton("Button1");

		// create anonymous class which has no name, exists only here,
		// defining action performed
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("This button works!");
			}
		});

		add(button1);
	}
}
