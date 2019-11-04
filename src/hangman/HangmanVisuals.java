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

public class HangmanVisuals {

	private static String[][] hangMen = new String[10][20];

	/*
	 * Loads hangman graphic from files in hangStages folder into hangMen array
	 */
	public static void loadHangMen() {

		String fileName = "";
		Path path = null;
		BufferedReader br = null;
		File file = null;

		for (int i = 0; i < hangMen.length; i++) {
			fileName = "stage" + i + ".txt";
			path = Paths.get("hangStages", fileName);
			file = path.toFile();
			try {
				br = new BufferedReader(new FileReader(file));
				for (int y = 0; y < hangMen[i].length; y++) {
					hangMen[i][y] = br.readLine();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Warning: Hangman graphic file #" + i + " not found");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Warning: something went wrong");
			}

			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Problem closing the BufferedReader");
			}
		}
	}

	/*
	 * Updates our graphic and prints out the partially-revealed hidden word, in addition to a list of guessed letters
	 */
	public static void update(ArrayList<Character> guessedLetters, String partialWord) {

		// Clearing out console
		clearConsole();

		for (int i = 0; i < 46; i++) {
			System.out.print(' ');
		}
		System.out.println("DANG MAN!  IT'S HANGMAN!");

		// Showing relevant hangman graphic
		for (int i = 0; i <= 4; i++) {
			System.out.println("");
		}

		int numGuessedLetters = guessedLetters.size();

		if (numGuessedLetters < hangMen.length) {
			
			//Showing hangman graphic contained in 2d array
			for (String y : hangMen[guessedLetters.size()]) {
				for (int i = 0; i < 50; i++) {
					System.out.print(' ');
				}
				System.out.println(y);
			}
			
			System.out.println("");
			
			
			// Showing guessed letters
			if (!guessedLetters.isEmpty()) {
				System.out.println("Guessed letters:");
				for (Character c : guessedLetters) {
					System.out.print(c + ", ");
				}
				System.out.println("");

			}
			
			//Centering guessed letters
			for (int i = 0; i < (60 - partialWord.length()); i++) {
				System.out.print(" ");
			}
			
			// Showing word
			printPartialWord(partialWord);
			System.out.println("");
			System.out.println("");

		}
	}

	/*
	 * Prompts the user to enter their name and returns it
	 */
	public static String getUserName(Scanner scnr) {
		String username = Validator.getString(new Scanner(System.in), "Please enter your name: ");
		return username;
	}
	
	/*
	 * Prompts the user to enter a desired difficulty level and repeatedly asks until they enter one in the proper format
	 */
	public static Difficulty getDiffLevel(Scanner scnr) {
		Boolean selected = false;
		Difficulty level = Difficulty.EASY;
		do
		{
			switch (Validator.getString(scnr, "Please select a difficulty level to determine word length.\n"
					+ "You can enter 'easy' (0-5 letters), 'medium'(6-10 letters), or 'hard' (10-14 letters): ").toLowerCase()) {
			case "easy":
				level = Difficulty.EASY;
				selected = true;
				break;
			case "medium":
				level = Difficulty.MEDIUM;
				selected = true;
				break;
			case "hard":
				level = Difficulty.HARD;
				selected = true;
				break;
				default:
					System.out.println("Invalid option entered");
					break;
			}
		} while (!selected);
		return level;
	}
	
	/*
	 * Prints our partially-guessed hidden word with a space in between each character
	 */
	private static void printPartialWord(String partialWord) {
		for (char c : partialWord.toCharArray()) {
			System.out.print("" + c + ' ');
		}
	}

	/*
	 * Clears the console
	 */
	private static void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
