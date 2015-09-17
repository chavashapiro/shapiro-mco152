package shapiro.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

	private ArrayList<String> englishWords;

	public ScrabbleDictionary() throws FileNotFoundException {
		englishWords = new ArrayList<String>();
		Scanner wordsFile = new Scanner(new File("US.dic"));
		while (wordsFile.hasNext()) {
			englishWords.add(wordsFile.next());
		}
		wordsFile.close();
	}

	public boolean contains(String searchWord) {
		if (englishWords.contains(searchWord))
			return true;
		else
			return false;
	}
}
