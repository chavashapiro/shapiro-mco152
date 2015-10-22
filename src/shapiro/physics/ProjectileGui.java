package shapiro.physics;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGui extends JFrame {
	private JLabel angle;
	private JLabel velocity;
	private JLabel time;
	private JLabel result;
	private JTextField editAngle;
	private JTextField editVelocity;
	private JTextField editTime;
	private JButton compute;

	public ProjectileGui() {
		setTitle("ProjectileGUI");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		angle = new JLabel("Angle");
		add(angle);
		editAngle = new JTextField();
		Dimension dim = new Dimension(200, 25);
		editAngle.setMaximumSize(dim);
		add(editAngle);
		velocity = new JLabel("Velocity");
		add(velocity);
		editVelocity = new JTextField();
		editVelocity.setMaximumSize(dim);
		add(editVelocity);
		time = new JLabel("Time");
		add(time);
		editTime = new JTextField();
		editTime.setMaximumSize(dim);
		add(editTime);
		compute = new JButton("Compute");
		add(compute);
		result = new JLabel();
		add(result);

		compute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double angleValue = Double.parseDouble(editAngle.getText());
				double velocityValue = Double.parseDouble(editVelocity
						.getText());
				double timeValue = Double.parseDouble(editTime.getText());
				Projectile proj = new Projectile(angleValue, velocityValue,
						timeValue);
				double x = proj.getX();
				double y = proj.getY();
				result.setText("x = " + x + ", y = " + y);

			}
		});

	}
}
