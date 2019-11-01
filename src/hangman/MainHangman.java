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
		String userName;
		int counter = 0;
//		String gameMode;
		System.out.println("Dang Man, Let's Play Hang Man!");
		HangmanVisuals.loadHangMen();
		HangmanVisuals.update(guessedLetters, "");
		System.out.println("Please enter your name: ");
		userName = scnr.nextLine();
		String easyWord;
		ArrayList<String> easywords = FileHelper.readFromFile();
		String randomStringFromEasyWords = easywords.get((int) Math.floor(Math.random() * easywords.size()));
//		System.out.println(randomStringFromEasyWords);
		String partialWord = "";
		for (int i = 0; i < randomStringFromEasyWords.length(); i++) {
			partialWord += "_";
		}

		while (guessedLetters.size() < 10 && !partialWord.equalsIgnoreCase(randomStringFromEasyWords)) {

			char guessedSingleString = Validator.getStringMatchingRegex(scnr, "Please enter a letter: ", "[A-za-z]{1}")
					.charAt(0);
			guessedSingleString = Character.toUpperCase(guessedSingleString);
			if (Hangman.stringHasChar(randomStringFromEasyWords, guessedSingleString)) {
				partialWord = (Hangman.updatePartialWord(guessedSingleString, partialWord, randomStringFromEasyWords));

				System.out.println(partialWord);
				counter++;
			} else {
				System.out.println("Oops, this word doesn't contain this letter...");
				guessedLetters.add(guessedSingleString);
				HangmanVisuals.update(guessedLetters, partialWord);
				counter++;
			}
		}

	}

}