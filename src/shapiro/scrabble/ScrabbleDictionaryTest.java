package shapiro.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {
	@Test
	public void testTrueContains() throws IOException {
		ScrabbleDictionary scrabble = new ScrabbleDictionary();
		boolean found = scrabble.contains("zoo");

		Assert.assertTrue(found);
	}

	@Test
	public void testFalseContains() throws IOException {
		ScrabbleDictionary scrabble = new ScrabbleDictionary();
		boolean found = scrabble.contains("ac");

		Assert.assertFalse(found);
	}
}
