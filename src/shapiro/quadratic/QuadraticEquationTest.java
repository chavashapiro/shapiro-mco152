package shapiro.quadratic;

import org.junit.Test;
import org.junit.Assert;

public class QuadraticEquationTest {
	@Test
	public void testGetPositiveX() throws InvalidDataException {
		QuadraticEquation q = new QuadraticEquation(1.6, 5.1, 2.8);
		double x = q.getPositiveX();

		Assert.assertEquals(-.70, x, .01);
	}

	@Test
	public void testGetNegativeX() throws InvalidDataException {
		QuadraticEquation q = new QuadraticEquation(1.6, 5.1, 2.8);
		double x = q.getNegativeX();

		Assert.assertEquals(-2.48, x, .01);
	}
}
