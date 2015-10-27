package shapiro.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g.drawLine(0, 300, 600, 50);
		g.setColor(new Color(242, 232, 211));
		g.fillOval(250, 150, 300, 300);
		g.setColor(new Color(88, 161, 245));
		g.fillOval(325, 225, 50, 50);
		g.fillOval(425, 225, 50, 50);
		g.setColor(Color.BLACK);
		g.fillOval(340, 240, 20, 20);
		g.fillOval(440, 240, 20, 20);
		g.setColor(new Color(232, 74, 122));
		g.fillArc(350, 300, 100, 100, 180, 180);
	}
}
