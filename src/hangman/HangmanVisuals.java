package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HangmanVisuals {

	private static String[][] hangMen = new String[10][20];

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

	public static void update(ArrayList<Character> guessedLetters, String partialWord) {

		// Clearing out console
		clearConsole();

		for (int i = 0; i < 35; i++) {
			System.out.print(' ');
		}
		System.out.println("DANG MAN!  IT'S HANGMAN!");

		// Showing relevant hangman graphic
		for (int i = 0; i <= 4; i++) {
			System.out.println("");
		}

		int numGuessedLetters = guessedLetters.size();

		// if (guessedLetters.size() < )

		if (numGuessedLetters < hangMen.length) {
			for (String y : hangMen[guessedLetters.size()]) {
				for (int i = 0; i < 40; i++) {
					System.out.print(' ');
				}
				System.out.println(y);
			}
			// Showing guessed letters
			if (!guessedLetters.isEmpty()) {
				System.out.println("Guessed letters:");
				for (Character c : guessedLetters) {
					System.out.print(c + ", ");
				}
				System.out.println("");

			}

			// Showing word
			printPartialWord(partialWord);
			System.out.println("");

		}
	}

	private static void printPartialWord(String partialWord) {
		for (char c : partialWord.toCharArray()) {
			System.out.print("" + c + ' ');
		}
	}

	private static void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
