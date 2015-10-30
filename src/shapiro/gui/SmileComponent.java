package shapiro.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private int y = 240;

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
		g.fillOval(340, y, 20, 20);
		g.fillOval(440, y, 20, 20);
		y++;
		if (y == 246) {
			y = 240;
		}
		g.setColor(new Color(232, 74, 122));
		g.fillArc(350, 300, 100, 100, 180, 180);

		try {
			Thread.sleep(75);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.repaint();
	}
}
