package shapiro.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {
	@Test
	public void testEncode() {
		MorseCode morse = new MorseCode();
		String code = morse.encode("Hello world");

		Assert.assertEquals(".... . .-.. .-.. ---   .-- --- .-. .-.. -..", code);
	}

	@Test
	public void testDecode() {
		MorseCode morse = new MorseCode();
		String message = morse.decode("- --- ..- .-. ---   -.-. --- .-.. .-.. . --. .");

		Assert.assertEquals("touro college", message);
	}
}
