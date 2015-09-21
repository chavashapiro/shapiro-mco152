package shapiro.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MostAnagrams {
	public static void main(String[] args) {
		HashSet<String> englishWords = new HashSet<String>();
		HashMap<String, ArrayList<String>> anagramGroups = new HashMap<String, ArrayList<String>>();

		try {
			Scanner wordsFile = new Scanner(new File("US.dic"));
			while (wordsFile.hasNext()) {
				englishWords.add(wordsFile.next());
			}
			wordsFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found. Program cannot execute.");
			System.exit(0);
		}

		for (String word : englishWords) {
			word = word.toLowerCase();
			String[] letters = word.split("");
			// sort the word into alphabetical order
			Arrays.sort(letters);
			String sortedWord = Arrays.toString(letters);
			// if a group with that word doesn't exist, create one. if it does,
			// add this word
			if (anagramGroups.containsKey(sortedWord)) {
				anagramGroups.get(sortedWord).add(word);
			} else {
				ArrayList<String> anagramWords = new ArrayList<String>();
				anagramWords.add(word);
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
