package shapiro.morsecode;

import java.util.HashMap;

public class MorseCode {

	private HashMap<String, String> morseCode;

	public MorseCode() {
		morseCode = new HashMap<String, String>();
		morseCode.put("a", ".-");
		morseCode.put(".-", "a");
		morseCode.put("b", "-...");
		morseCode.put("-...", "b");
		morseCode.put("c", "-.-.");
		morseCode.put("-.-.", "c");
		morseCode.put("d", "-..");
		morseCode.put("-..", "d");
		morseCode.put("e", ".");
		morseCode.put(".", "e");
		morseCode.put("f", "..-.");
		morseCode.put("..-.", "f");
		morseCode.put("g", "--.");
		morseCode.put("--.", "g");
		morseCode.put("h", "....");
		morseCode.put("....", "h");
		morseCode.put("i", "..");
		morseCode.put("..", "i");
		morseCode.put("j", ".---");
		morseCode.put(".---", "j");
		morseCode.put("k", "-.-");
		morseCode.put("-.-", "k");
		morseCode.put("l", ".-..");
		morseCode.put(".-..", "l");
		morseCode.put("m", "--");
		morseCode.put("--", "m");
		morseCode.put("n", "-.");
		morseCode.put("-.", "n");
		morseCode.put("o", "---");
		morseCode.put("---", "o");
		morseCode.put("p", ".--.");
		morseCode.put(".--.", "p");
		morseCode.put("q", "--.-");
		morseCode.put("--.-", "q");
		morseCode.put("r", ".-.");
		morseCode.put(".-.", "r");
		morseCode.put("s", "...");
		morseCode.put("...", "s");
		morseCode.put("t", "-");
		morseCode.put("-", "t");
		morseCode.put("u", "..-");
		morseCode.put("..-", "u");
		morseCode.put("v", "...-");
		morseCode.put("...-", "v");
		morseCode.put("w", ".--");
		morseCode.put(".--", "w");
		morseCode.put("x", "-..-");
		morseCode.put("-..-", "x");
		morseCode.put("y", "-.--");
		morseCode.put("-.--", "y");
		morseCode.put("z", "--..");
		morseCode.put("--..", "z");
		morseCode.put(" ", " ");

	}

	public String encode(String message) {
		// turn message to all lowercase so will be easy to compare to chars in
		// array
		message = message.toLowerCase();

		String[] messageArray = message.split("");
		StringBuilder code = new StringBuilder();
		for (int i = 0; i < messageArray.length; i++) {
			if (i == message.length() - 1) {
				code.append(morseCode.get(messageArray[i]));
			} else {
				code.append(morseCode.get(messageArray[i]) + " ");
			}
		}

		return code.toString();

	}

	public String decode(String code) {
		StringBuilder message = new StringBuilder();

		String[] codeWordsArray = code.split("   ");
		for (int j = 0; j < codeWordsArray.length; j++) {
			String[] codeArray = codeWordsArray[j].split(" ");
			for (int i = 0; i < codeArray.length; i++) {
				message.append(morseCode.get(codeArray[i]));
			}
			if (!(j == codeWordsArray.length - 1)) {
				message.append(" ");
			}
		}
		return message.toString();
	}

}
