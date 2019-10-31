package hangman;

import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	

	String computerWord = "Hello";
	
	String userWord = Validator.getStringMatchingRegex(scan, "Enter a letter: ", "[A-Za-z]{1}");
	System.out.println(userWord);
	
//	System.out.println(isChar(userWord, computerWord));
	
	}
	
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

//	public static boolean isChar(String userWord, String computerWord) {
//	
//		int missCounter = 0;
//		
//	if (computerWord.contains(userWord)) {
//		
//		return true;
//	} else {
//		
//		missCounter++;
//		return false;
//		
//	}
//}
}
