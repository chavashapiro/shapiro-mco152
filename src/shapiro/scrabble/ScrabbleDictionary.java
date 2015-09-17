package shapiro.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {

	private HashSet<String> englishWords;

	public ScrabbleDictionary() throws FileNotFoundException {
		englishWords = new HashSet<String>();
		Scanner wordsFile = new Scanner(new File("US.dic"));
		while (wordsFile.hasNext()) {
			englishWords.add(wordsFile.next());
		}
		wordsFile.close();
	}

	public boolean contains(String searchWord) {
		return englishWords.contains(searchWord);
	}
}
