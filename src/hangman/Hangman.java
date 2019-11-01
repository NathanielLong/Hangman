package hangman;

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

//	if(_compWord.StringindexOf[userLetter]) {
//		for(i = 0; i<_compWord.length(); i++) 
//			System.out.println(userLetter);
//	}

//	System.out.println(isChar(userWord, computerWord));

//	public static boolean isValidRegex(String userWord, String "[A-Z][a-z]{1}") {
//		if (isValidRegex(userWord, ("[A-Z][a-z]{1}"))) {
//		} else {
//			System.out.println("This is not valid input. Please enter a word: ");
//		}
//        return userWord.matches(regex);      
//	}

//	public void checkLetter(String letter, ArrayList<> compWord) {
//		for(int i = 0; i<compWord.length(); i++) {
//			if(letter.equals(compWord.[i])) {
//				// Run a method which gives user a correct letter
//			}
//			else {
//				String failed = "Could not find the letter"
//			}
//		}
//	}

//	public static boolean isChar(String userLetter, String computerWord) {
//	
//		int missCounter = 0;
//		
//	if (computerWord.contains(userLetter)) {
//		System.println(userLetter);
//		return true;
//	} else {
//		
//		missCounter++;
//		return false;
//		
//	}
//}
}
