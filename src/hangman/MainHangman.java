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
		int missedCounter = 0;
		int counter = 0;
		char guessedChar = 0;
//		String gameMode;
//		System.out.println("Dang Man, Let's Play Hang Man!");
		HangmanVisuals.loadHangMen();
		HangmanVisuals.update(guessedLetters, "");
		System.out.println("Please enter your name: ");
		userName = scnr.nextLine();
		String easyWord;
		ArrayList<String> easywords = FileHelper.readFromFile();
		String randEasyWord = easywords.get((int) Math.floor(Math.random() * easywords.size()));
		String partialWord = "";
		
		for (int i = 0; i < randEasyWord.length(); i++) {
			partialWord += "_";
		}
		boolean end = false;
		while (!end) {
			boolean done = false;
			while (!done) {
				guessedChar = Validator
						.getStringMatchingRegex(scnr, userName + ", please enter a letter: ", "[A-za-z]{1}").charAt(0);
				guessedChar = Character.toUpperCase(guessedChar);
				if (guessedLetters.contains(guessedChar)) {
					System.out.println("You have already guessed this. Please enter another letter: ");
				} else {
					done = true;
				}
			}

			// Removed this because all it did was ask for their input again
			// guessedChar = Validator.getStringMatchingRegex(scnr, "Please enter a letter:
			// ", "[A-za-z]{1}").charAt(0);
			guessedChar = Character.toUpperCase(guessedChar);
			if (Hangman.stringHasChar(randEasyWord, guessedChar)) {
				partialWord = (Hangman.updatePartialWord(guessedChar, partialWord, randEasyWord));
				HangmanVisuals.update(guessedLetters, partialWord);
				counter++;
				end = false;
			} else {
				System.out.println("Oops, this word doesn't contain this letter...");
				guessedLetters.add(guessedChar);
				HangmanVisuals.update(guessedLetters, partialWord);
				counter++;
				if (missedCounter == 8) {
					end = true;
				}
			}

		}

	}

}