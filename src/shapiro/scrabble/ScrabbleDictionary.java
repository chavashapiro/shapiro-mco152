package shapiro.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private HashSet<String> englishWords;

	public ScrabbleDictionary() throws IOException {
		englishWords = new HashSet<String>();
		BufferedReader wordsFile = new BufferedReader(new FileReader("US.dic"));
		String word;
		while ( (word = wordsFile.readLine()) != null) {
			englishWords.add(word);
		}
		wordsFile.close();
	}

	public boolean contains(String searchWord) {
		return englishWords.contains(searchWord);
	}
}
