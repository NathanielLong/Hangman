package hangman;

import java.util.Scanner;

public class Hangman {	
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
