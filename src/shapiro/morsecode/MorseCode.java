package shapiro.morsecode;

public class MorseCode {
	private char[] letters;
	private String[] morseLetters;

	public MorseCode() {
		letters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', ' ' };
		morseLetters = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.",
				"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
				".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
				"-..-", "-.--", "--..", " " };
	}

	public String encode(String message) {
		// turn message to all lowercase so will be easy to compare to chars in
		// array
		message = message.toLowerCase();
		StringBuffer code = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < letters.length; j++) {
				if (message.charAt(i) == letters[j]) {
					if (i == message.length() - 1)
						code.append(morseLetters[j]);
					else
						code.append(morseLetters[j] + " ");
				}
			}
		}
		return code.toString();
	}

	public String decode(String code) {
		StringBuffer message = new StringBuffer();

		String[] codeWordsArray = code.split("   ");
		for (int t = 0; t < codeWordsArray.length; t++) {
			String[] codeArray = codeWordsArray[t].split(" ");
			for (int i = 0; i < codeArray.length; i++) {
				for (int j = 0; j < morseLetters.length; j++) {
					if (codeArray[i].equals(morseLetters[j]))
						message.append(letters[j]);
				}
			}
			if (!(t == codeWordsArray.length - 1))
				message.append(" ");
		}
		return message.toString();
	}
}
