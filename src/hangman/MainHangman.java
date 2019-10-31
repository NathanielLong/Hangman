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
	
	static ArrayList<Character> guessedLetters = new ArrayList<>(); //Contains all characters that have already been guessed by the player
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userName;
		String gameMode;
		System.out.println("Dang Man, Let's Play Hang Man!");
		System.out.println("Please enter your name: ");
		userName = scnr.nextLine();
		System.out.println("Please select 'Hard mode' or 'Easy mode': ");
		gameMode = scnr.nextLine();
		//This is where
		
		//Loading all of our graphics into hangMen
		HangmanVisuals.loadHangMen();
		
		//Showing first graphic
		HangmanVisuals.update(guessedLetters);
		
		
	}
	
	
	

}
