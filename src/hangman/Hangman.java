package hangman;

import java.util.Scanner;

public class Hangman {
//	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(System.in);
//
//		int missedLetters = 0;
//
//		String _compWord = "Hello";
//
//		System.out.println(_compWord);
//
//		// validates that the user input is a letter and one character
//		String userLetter = Validator.getStringMatchingRegex(scan, "Enter a letter: ", "[A-Za-z]{1}");
//		System.out.println(userLetter);
//
//		// replaces the computer word with underscores
//		_compWord = _compWord.replaceAll("(?i)[a-zA-z]", "_");
//		System.out.println(_compWord);
//
//		if (_compWord.contains(userLetter)) {
//			System.out.println(userLetter);
//		} else {
//			missedLetters++;
//		}
//
//	}
	
	/*
	 * Replaces a single character in inputString at location specified by newCharIndex with character
	 * specified by newChar
	 */
	static String replaceSingleChar(String inputString, char newChar, int newCharIndex) {
		return inputString.substring(0, newCharIndex) + newChar + inputString.substring(newCharIndex + 1);
	}

	/*
	 * Replaces a character in revealedString (which is assumed to be a series of underscores) with the character guessed
	 * by the user, in the event that this character does in fact exist in the hidden word.
	 */
	static String updatePartialWord(char guessedChar, String partialWord, String hiddenWord) {
		int startIndex = 0;
		while (true) {

			startIndex = hiddenWord.indexOf(guessedChar, startIndex);
			if (startIndex != -1) {
				partialWord = replaceSingleChar(partialWord, guessedChar, startIndex);
			} else {
				break;
			}
			startIndex++;
		}
		return partialWord;
	}

	/*
	 * Returns true if string word contains the character guessedChar
	 */
	static Boolean stringHasChar(String word, char guessedChar) {
		return (word.indexOf(guessedChar) != -1);

	}
	
}
