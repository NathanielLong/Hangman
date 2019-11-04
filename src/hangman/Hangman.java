package hangman;

<<<<<<< HEAD
import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int missedLetters = 0;

		String _compWord = "Hello";

		System.out.println(_compWord);

		// validates that the user input is a letter and one character
		String userLetter = Validator.getStringMatchingRegex(scan, "Enter a letter: ", "[A-Za-z]{1}");
		System.out.println(userLetter);

		// replaces the computer word with underscores
		_compWord = _compWord.replaceAll("(?i)[a-zA-z]", "_");
		System.out.println(_compWord);

		if (_compWord.contains(userLetter)) {
			System.out.println(userLetter);
		} else {
			missedLetters++;
		}

	}

=======
public class Hangman {	
	/*
	 * Replaces a single character in inputString at location specified by newCharIndex with character
	 * specified by newChar
	 */
>>>>>>> 8fe6cad03923863b65b157de1626164d76cb54d5
	static String replaceSingleChar(String inputString, char newChar, int newCharIndex) {
		return inputString.substring(0, newCharIndex) + newChar + inputString.substring(newCharIndex + 1);
	}

	static String updatePartialWord(char guessedChar, String revealedString, String randomString) {
		int startIndex = 0;
		while (true) {

			startIndex = randomString.indexOf(guessedChar, startIndex);
			if (startIndex != -1) {
				revealedString = replaceSingleChar(revealedString, guessedChar, startIndex);
			} else {
				break;
			}
			startIndex++;
		}
		return revealedString;
	}

	static Boolean stringHasChar(String master, char guessedChar) {
		return (master.indexOf(guessedChar) != -1);

	}
	
	public String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);
	 
	    return sb.toString();
	
	}
}
