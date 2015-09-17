package shapiro.scrabble;

import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {
	@Test
	public void testTrueContains() throws FileNotFoundException {
		ScrabbleDictionary scrabble = new ScrabbleDictionary();
		boolean found = scrabble.contains("zoo");

		Assert.assertEquals(true, found);
	}

	@Test
	public void testFalseContains() throws FileNotFoundException {
		ScrabbleDictionary scrabble = new ScrabbleDictionary();
		boolean found = scrabble.contains("ac");

		Assert.assertEquals(false, found);
	}
}
