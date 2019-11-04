package hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class MainHangman {

	public static void main(String[] args) {
		LeaderBoard.loadLeaderBoard();

		Scanner scnr = new Scanner(System.in);
		String userName;
		char guessedChar = 0;
		char userReply;
		
		int addedPoints = 0;
		
		userName = HangmanVisuals.getUserName(scnr);
		
		if (userName.equalsIgnoreCase("Nina")) {
			System.out.println("There is no cheating allowed and you dont have over 1000 wins...");
		}
		if (userName.equalsIgnoreCase("Rob")) {
			System.out.println("Bro, you just get an automatic win. You don't even have to play...");
		}
		if (userName.equalsIgnoreCase("Nathaniel")) {
			System.out.println("Haha, I'm gonna lose...");
		}
		
		do {
			ArrayList<Character> guessedLetters = new ArrayList<>();
			ArrayList<Character> correctLetters = new ArrayList<>();
			int missedCounter = 0;
			HangmanVisuals.loadHangMen();
			
			// Getting text file of list of possible words

			ArrayList<String> wordBank = FileHelper.readFromFile();
			
			int minLength = 0, maxLength = 0;
<<<<<<< HEAD

			// Allows user to pick from multiple files of possible words

			switch(HangmanVisuals.getDiffLevel()) {
=======
			
			switch(HangmanVisuals.getDiffLevel(scnr)) {
>>>>>>> 54e7a5ed39f10d6268e87b8c735400fba8301d07
			case EASY:
				maxLength = 5;
				addedPoints = 1;
				break;
			case MEDIUM:
				minLength = 6;
				maxLength = 9;
				addedPoints = 2;
				break;
			case HARD:
				minLength = 10;
				maxLength = 14;
				addedPoints = 3;
				break;
			}
			
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

					// Only allows input to be a single letter

					guessedChar = Validator
							.getStringMatchingRegex(scnr, userName + ", please enter a letter: ", "[A-za-z]{1}")
							.charAt(0);
					guessedChar = Character.toUpperCase(guessedChar);
					if (guessedLetters.contains(guessedChar)) {
						System.out.println("You have already guessed this. Please enter another letter: ");
					} 
					else if (correctLetters.contains(guessedChar)) {
						System.out.println("You have already guessed this. Please enter another letter: ");
					} else {
						correctLetters.add(guessedChar);
						done = true;
					}
				}
				// Reveals every place that letter is found in the word
				guessedChar = Character.toUpperCase(guessedChar);
				if (Hangman.stringHasChar(hiddenWord, guessedChar)) {
					partialWord = (Hangman.updatePartialWord(guessedChar, partialWord, hiddenWord));
					HangmanVisuals.update(guessedLetters, partialWord);
					if (partialWord.equals(hiddenWord)) {
						end = true;
						System.out.println("Hurray, you made it!");
						LeaderBoard.addVictory(userName, addedPoints);
						LeaderBoard.saveLeaderBoard();

						userReply = Validator.getString(scnr, "Would you like to see the leader board? (y/n): ").charAt(0);
						if (userReply == 'y') {
							LeaderBoard.readLeaderBoard();
						}
						break;
					}
					end = false;
				} else {
					System.out.println("Oops, this word doesn't contain this letter...");
					guessedLetters.add(guessedChar);
					HangmanVisuals.update(guessedLetters, partialWord);
					
					// Counter of misses that increments 
					missedCounter++;
					// User cannot miss more 9 times
					if (missedCounter == 9) {
						end = true;
						System.out.println("Dang man, now we gotta eat cake!");
						System.out.println("Here was the correct word: " + hiddenWord);
						LeaderBoard.addLoss();
						LeaderBoard.saveLeaderBoard();
						userReply = Validator.getString(scnr, "Would you like to see the leaderboard? (y/n): ").charAt(0);
						if (userReply == 'y') {
							LeaderBoard.readLeaderBoard();
							System.out.println(LeaderBoard.percentageWins());
						}
					}
				}

			}
		userReply = Validator.getString(scnr, "Would you like to play again? (y/n): ").charAt(0);
		} while (userReply == 'y');
		System.out.println("Please come come again!");
		LeaderBoard.saveLeaderBoard();
		scnr.close();
		}

	}

