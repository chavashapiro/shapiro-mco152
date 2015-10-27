package shapiro.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileArcJFrame extends JFrame {
	public ProjectileArcJFrame() {
		setTitle("Projectile");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);

		container.add(new ProjectileArcComponent(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new ProjectileArcJFrame().setVisible(true);
	}

}
