package shapiro.anagrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MostAnagrams {
	public static void main(String[] args) {
		HashSet<String> englishWords = new HashSet<String>();
		HashMap<String, ArrayList<String>> anagramGroups = new HashMap<String, ArrayList<String>>();

		BufferedReader wordsFile;
		try {
			wordsFile = new BufferedReader(new FileReader("US.dic"));
			String word;
			while ((word = wordsFile.readLine()) != null) {
				englishWords.add(word);
			}
			wordsFile.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String thisWord : englishWords) {
			thisWord = thisWord.toLowerCase();
			String[] letters = thisWord.split("");
			// sort the word into alphabetical order
			Arrays.sort(letters);
			String sortedWord = Arrays.toString(letters);
			// if a group with that word doesn't exist, create one. if it does,
			// add this word
			if (anagramGroups.containsKey(sortedWord)) {
				anagramGroups.get(sortedWord).add(thisWord);
			} else {
				ArrayList<String> anagramWords = new ArrayList<String>();
				anagramWords.add(thisWord);
				anagramGroups.put(sortedWord, anagramWords);
			}
		}

		// iterate through arrayLists which are the values of the map to see
		// which is the largest
		ArrayList<String> mostAnagrams = new ArrayList<String>();
		for (ArrayList<String> array : anagramGroups.values()) {
			if (array.size() > mostAnagrams.size()) {
				mostAnagrams = array;
			}
		}

		System.out.println(mostAnagrams.toString());

	}
}
