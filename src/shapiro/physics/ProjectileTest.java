package shapiro.physics;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {
	
	@Test
	public void testGetY() {
		Projectile p = new Projectile(31, 20, 2.7);
		double x = p.getY();
		
		Assert.assertEquals(27.81, x, 0.01);
	}
	
}
