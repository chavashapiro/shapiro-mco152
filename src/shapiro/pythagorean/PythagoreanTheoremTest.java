package shapiro.pythagorean;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {
	@Test
	public void testSetAB() {
		PythagoreanTheorem pythagorean = new PythagoreanTheorem();
		pythagorean.setAB(2.4, 5.6);
		double c = pythagorean.getC();

		Assert.assertEquals(6.09, c, .01);
	}

	@Test
	public void testsetAC() {
		PythagoreanTheorem pythagorean = new PythagoreanTheorem();
		pythagorean.setAC(3.4, 7.2);
		double b = pythagorean.getB();

		Assert.assertEquals(6.35, b, .01);
	}

	@Test
	public void testSetBC() {
		PythagoreanTheorem pythagorean = new PythagoreanTheorem();
		pythagorean.setBC(2.1, 4.7);
		double a = pythagorean.getA();

		Assert.assertEquals(4.20, a, .01);
	}
}
