package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainHangman {

	static ArrayList<Character> guessedLetters = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String userName;
		int counter = 0;
		char guessedChar = 0;
//		String gameMode;
		System.out.println("Dang Man, Let's Play Hang Man!");
		HangmanVisuals.loadHangMen();
		HangmanVisuals.update(guessedLetters, "");
		System.out.println("Please enter your name: ");
		userName = scnr.nextLine();
		String easyWord;
		ArrayList<String> easywords = FileHelper.readFromFile();
		String randEasyWord = easywords.get((int) Math.floor(Math.random() * easywords.size()));
//		System.out.println(randomStringFromEasyWords);
		String partialWord = "";
		for (int i = 0; i < randEasyWord.length(); i++) {
			partialWord += "_";
		}

		while (guessedLetters.size() < 10 && !partialWord.equalsIgnoreCase(randEasyWord)) {
			boolean done = false;
<<<<<<< HEAD
			while(!done) {
			guessedChar = Validator.getStringMatchingRegex(scnr, userName + ", please enter a letter: ", "[A-za-z]{1}")
					.charAt(0);
<<<<<<< HEAD
			if(randEasyWord.indexOf(guessedChar) != -1) {
				System.out.println("You have already guessed this. Please enter another letter: ");
			} else {
				done = true;
			}
			} 
			guessedChar = Character.toUpperCase(guessedChar);
			if (Hangman.stringHasChar(randEasyWord, guessedChar)) {
				partialWord = (Hangman.updatePartialWord(guessedChar, partialWord, randEasyWord));
				for (int i = 0; i < partialWord.length(); i++)
					System.out.print(partialWord.charAt(i) + " ");
=======
			guessedSingleString = Character.toUpperCase(guessedSingleString);
			if (Hangman.stringHasChar(randEasyWord, guessedSingleString)) {
				partialWord = (Hangman.updatePartialWord(guessedSingleString, partialWord, randEasyWord));
				HangmanVisuals.update(guessedLetters, partialWord);
//				for (int i = 0; i < partialWord.length(); i++)
//					System.out.print(partialWord.charAt(i) + " ");
>>>>>>> 9dd0229f4086635b6510b09183eea4f064b547e4
//				System.out.println(partialWord);
=======
			while (!done) {
				guessedChar = Validator
						.getStringMatchingRegex(scnr, userName + ", please enter a letter: ", "[A-za-z]{1}").charAt(0);
				if ((randEasyWord.indexOf(guessedChar) != -1) || (partialWord.indexOf(guessedChar) != -1)) {
					System.out.println("You have already guessed this. Please enter another letter: ");
				} else {
					done = true;
				}
			}
			
			guessedChar = Validator.getStringMatchingRegex(scnr, "Please enter a letter: ", "[A-za-z]{1}").charAt(0);
			guessedChar = Character.toUpperCase(guessedChar);
			if (Hangman.stringHasChar(randEasyWord, guessedChar)) {
				partialWord = (Hangman.updatePartialWord(guessedChar, partialWord, randEasyWord));
				HangmanVisuals.update(guessedLetters, partialWord);
>>>>>>> f89a134b89760dfdb3a9a61691c3667cbe777ffd
				counter++;
			} else {
				// this is not working
				System.out.println("Oops, this word doesn't contain this letter...");
				guessedLetters.add(guessedChar);
				HangmanVisuals.update(guessedLetters, partialWord);
				counter++;
			}
		}
		System.out.println("\nThank you for playing!");
	}

}