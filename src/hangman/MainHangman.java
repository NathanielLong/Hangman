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

	public static void main(String[] args) {
		LeaderBoard.loadLeaderBoard();
		
		Scanner scnr = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String userName;
		int counter = 0;
		char guessedChar = 0;
		char userReply;
		System.out.println("Please enter your name: ");
		userName = scnr.nextLine();
		if (userName.equalsIgnoreCase("Nina")) {
			System.out.println("There is no cheating allowed and you dont have over 1000 wins...");
			counter = -100;
		}
		if (userName.equalsIgnoreCase("Rob")) {
			System.out.println("Bro, you just get an automatic win. You don't even have to play...");
			counter++;
		}
		if (userName.equalsIgnoreCase("Nathaniel")) {
			System.out.println("Haha, I'm gonna lose...");
		}
		do {
			ArrayList<Character> guessedLetters = new ArrayList<>();
			int missedCounter = 0;
			HangmanVisuals.loadHangMen();
			ArrayList<String> easywords = FileHelper.readFromFile();
			String randEasyWord = easywords.get((int) Math.floor(Math.random() * easywords.size()));
			String partialWord = "";

			for (int i = 0; i < randEasyWord.length(); i++) {
				partialWord += "_";
			}
			HangmanVisuals.update(guessedLetters, "");
			boolean end = false;
			while (!end) {
				boolean done = false;
				while (!done) {
					guessedChar = Validator
							.getStringMatchingRegex(scnr, userName + ", please enter a letter: ", "[A-za-z]{1}")
							.charAt(0);
					guessedChar = Character.toLowerCase(guessedChar);
					if (guessedLetters.contains(guessedChar)) {
						System.out.println("You have already guessed this. Please enter another letter: ");
					} else {
						done = true;
					}
				}
				guessedChar = Character.toLowerCase(guessedChar);
				if (Hangman.stringHasChar(randEasyWord, guessedChar)) {
					partialWord = (Hangman.updatePartialWord(guessedChar, partialWord, randEasyWord));
					HangmanVisuals.update(guessedLetters, partialWord);
					counter++;
					if (partialWord.equals(randEasyWord)) {
						end = true;
						System.out.println("Hurray, you made it!");

						LeaderBoard.addVictory(userName, 1);
						break;
					}
					end = false;
				} else {
					System.out.println("Oops, this word doesn't contain this letter...");
					guessedLetters.add(guessedChar);
					HangmanVisuals.update(guessedLetters, partialWord);
					missedCounter++;
					if (missedCounter == 9) {
						end = true;
						System.out.println("Dang man, now we gotta eat cake!");
						System.out.println("Here was the correct word: " + randEasyWord);
						LeaderBoard.addLoss();
					}
				}

			}
			System.out.println("Would you like to continue? (y/n) ");
			userReply = scnr.nextLine().charAt(0);
		} while (userReply == 'y');
		System.out.println("Please come come again!");
		LeaderBoard.saveLeaderBoard();
	}

}