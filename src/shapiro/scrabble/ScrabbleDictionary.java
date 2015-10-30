package shapiro.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private HashSet<String> englishWords;
	private static ScrabbleDictionary singleton;

	public static ScrabbleDictionary getInstance() throws IOException {
		if (singleton == null) {
			singleton = new ScrabbleDictionary();
		}

		return singleton;
	}

	private ScrabbleDictionary() throws IOException {
		englishWords = new HashSet<String>();
		BufferedReader wordsFile = new BufferedReader(new FileReader("US.dic"));
		String word;
		while ((word = wordsFile.readLine()) != null) {
			englishWords.add(word);
		}
		wordsFile.close();
	}

	public boolean contains(String searchWord) {
		return englishWords.contains(searchWord);
	}
}
