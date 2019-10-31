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

	private static String[][] hangMen = new String[9][20];

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
				// int yCounter = 0;
				for (int y = 0; y < hangMen[i].length; y++) {
					hangMen[i][y] = br.readLine();
				}
				/*
				 * while (br.ready()) {
				 * 
				 * yCounter++; }
				 */
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

	public static void update(ArrayList<Character> guessedLetters) {

		// Clearing out console
		clearConsole();
		
		// Showing relevant hangman graphic
		for (String y : hangMen[guessedLetters.size()]) {
			System.out.println(y);
		}

		System.out.println("");
		System.out.println("Guessed letters:");
		for (Character c : guessedLetters) {
			System.out.print(c + ", ");
		}
		// Showing word
	}

	private static void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
