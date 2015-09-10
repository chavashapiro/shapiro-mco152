package shapiro.physics;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {
	
	@Test
	public void testGetX() {
		Projectile p = new Projectile(31, 20, 2.7);
		double x = p.getX();
		
		Assert.assertEquals(27.81, x, 0.01);
	}
	
}
