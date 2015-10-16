package shapiro.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import shapiro.quadratic.InvalidDataException;
import shapiro.quadratic.QuadraticEquation;

public class QuadraticGui extends JFrame {
	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel result;
	private JTextField editA;
	private JTextField editB;
	private JTextField editC;
	private JButton compute;

	public QuadraticGui() {
		setTitle("QuadraticGUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		a = new JLabel("A");
		add(a);
		editA = new JTextField();
		add(editA);
		b = new JLabel("B");
		add(b);
		editB = new JTextField();
		add(editB);
		c = new JLabel("C");
		add(c);
		editC = new JTextField();
		add(editC);
		compute = new JButton("Compute");
		add(compute);
		result = new JLabel();
		add(result);

		compute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double aValue = Double.parseDouble(editA.getText());
				double bValue = Double.parseDouble(editB.getText());
				double cValue = Double.parseDouble(editC.getText());
				try {
					QuadraticEquation quad = new QuadraticEquation(aValue, bValue, cValue);
					double posX = quad.getPositiveX();
					double negX = quad.getNegativeX();
					// String string = new String("x = " + posX + ", " + negX);
					result.setText("x = " + posX + ", " + negX);
				} catch (InvalidDataException e1) {
					System.exit(1);
				}
			}
		});

	}
}
