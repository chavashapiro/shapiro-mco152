package shapiro.acm;

import org.junit.Assert;
import org.junit.Test;

public class RascalTest {
	@Test
	public void testRascalA() {
		int value = Rascal.R(4, 2);
		Assert.assertEquals(5, value);
	}

	@Test
	public void testRascalB() {
		int value = Rascal.R(12345, 9876);
		Assert.assertEquals(24383845, value);
	}
}
