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
		Difficulty dLevel = Difficulty.EASY;
		
		Scanner scnr = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String userName;
		int counter = 0;
		char guessedChar = 0;
		char userReply;
		
		userName = HangmanVisuals.getUserName();
//		System.out.println("Please enter your name: ");
//		userName = scnr.nextLine();
		
		if (userName.equalsIgnoreCase("Nina")) {
			System.out.println("There is no cheating allowed and you dont have over 1000 wins...");
			counter--;
		}
		if (userName.equalsIgnoreCase("Rob")) {
			System.out.println("Bro, you just get an automatic win. You don't even have to play...");
			counter++;
		}
		if (userName.equalsIgnoreCase("Nathaniel")) {
			System.out.println("Haha, I'm gonna lose...");
			counter = -101;
		}
		
		do {
			ArrayList<Character> guessedLetters = new ArrayList<>();
			int missedCounter = 0;
			HangmanVisuals.loadHangMen();
			ArrayList<String> wordBank = FileHelper.readFromFile();
			
			int minLength = 0, maxLength = 0;
			
			switch(HangmanVisuals.getDiffLevel()) {
			case EASY:
				maxLength = 5;
				break;
			case MEDIUM:
				minLength = 6;
				maxLength = 9;
				break;
			case HARD:
				minLength = 10;
				maxLength = 14;
				break;
			}
			
			//String hiddenWord = wordBank.get((int) Math.floor(Math.random() * wordBank.size()));
			String hiddenWord = Selector.getWordByLengthRange(minLength, maxLength, wordBank);
			String partialWord = "";

			for (int i = 0; i < hiddenWord.length(); i++) {
				partialWord += "_";
			}
			
			HangmanVisuals.update(guessedLetters, partialWord);
			boolean end = false;
			while (!end) {
				boolean done = false;
				while (!done) {
					guessedChar = Validator
							.getStringMatchingRegex(scnr, userName + ", please enter a letter: ", "[A-za-z]{1}")
							.charAt(0);
					guessedChar = Character.toUpperCase(guessedChar);
					if (guessedLetters.contains(guessedChar)) {
						System.out.println("You have already guessed this. Please enter another letter: ");
					} else {
						done = true;
					}
				}
				
				guessedChar = Character.toUpperCase(guessedChar);
				if (Hangman.stringHasChar(hiddenWord, guessedChar)) {
					partialWord = (Hangman.updatePartialWord(guessedChar, partialWord, hiddenWord));
					HangmanVisuals.update(guessedLetters, partialWord);
					if (partialWord.equals(hiddenWord)) {
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
						System.out.println("Here was the correct word: " + hiddenWord);
						LeaderBoard.addLoss();

					}
				}

			}
			System.out.println("Would you like to continue? (y/n) ");
			userReply = scnr.nextLine().charAt(0);
		} while (userReply == 'y');
		LeaderBoard.saveLeaderBoard();
		System.out.println("Would you like to see the leader board? (y/n): ");
		userReply = scnr.nextLine().charAt(0);
		if (userReply == 'y') {
			LeaderBoard.readLeaderBoard();
			System.out.println(LeaderBoard.percentageWins() + "%");
		}
		System.out.println("Please come come again!");
	}

}