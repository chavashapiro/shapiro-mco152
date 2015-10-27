package shapiro.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileArcComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Projectile projectile = new Projectile(31, 20, 0);
		Graphics2D g2d = (Graphics2D) g;
		double x1, y1, x2, y2;
		int time = 0;
		x1 = 0;
		y1 = 0;
		while (y1 >= 0) {
			time++;
			projectile.setTime(time);
			x2 = projectile.getX();
			y2 = projectile.getY();
			g2d.draw(new Line2D.Double(x1, getHeight() - y1, x2, getHeight()
					- y2));
			x1 = x2;
			y1 = y2;
		}
	}
}
