package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class LeaderBoard {

	// vars
	// hashmap for name and # of wins

	static int totalWins = 0;
	static int totalLosses = 0;

	static HashMap<String, Integer> leaderBoardMap = new HashMap<>();

	public static void loadLeaderBoard() {
		Path p = Paths.get("resources", "leaderBoard.txt");
		File f = p.toFile();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = "";
			int lineCounter = 0;
			while ((line = br.readLine()) != null) {
				switch (lineCounter) {
				case 0:
					totalWins = Integer.valueOf(line.split(":")[1]);
					break;
				case 1:
					totalLosses = Integer.valueOf(line.split(":")[1]);
					break;
				default:
					if (!line.isEmpty()) {
						String[] thisEntry = line.split(" ");
						leaderBoardMap.put(thisEntry[0], Integer.valueOf(thisEntry[2]));
					}
				}
				lineCounter++;
<<<<<<< HEAD
//				br.close();
=======
				
>>>>>>> 54e7a5ed39f10d6268e87b8c735400fba8301d07
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		} 
	}

	public static void saveLeaderBoard() {
		Path p = Paths.get("resources", "leaderBoard.txt");
		File file = p.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			output.println("Total Wins:" + totalWins);
			output.println("Total Losses:" + totalLosses);
			for (String s : leaderBoardMap.keySet()) {
				output.println(s + " has " + leaderBoardMap.get(s) + " points!");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		output.close();
	}

	public static void addVictory(String userName, int numNewPoints) {
		totalWins++;

		for (String s : leaderBoardMap.keySet()) {
			if (s.equalsIgnoreCase(userName)) {
				Integer i = leaderBoardMap.get(s);
				leaderBoardMap.put(s, i + numNewPoints);
				return;
			}
		}

		leaderBoardMap.put(userName, numNewPoints);
	}

	public static void addLoss() {
		totalLosses++;
	}

	public static void readLeaderBoard() {
		String fileName = "leaderBoard.txt";
		Path path = Paths.get("resources", fileName);
		File file = path.toFile();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			br.close();

		} catch (FileNotFoundException e) {

			System.out.println("Something went wrong with your file...");
		} catch (IOException e) {

			System.out.println("Something went wrong while reading from the file...");
		}
		
	}
	public static double percentageWins() {
		double percentage = totalWins / (totalWins + totalLosses) * 100;
		return percentage;
		// pass totalWins and totalLosses
	}
	
	public static double averageGuesses(double numMiss, double numCorrect, double numPlayed) {
		return (numMiss + numCorrect / numPlayed);
		
	}
	public static double averageWordLength(double numPlayed, double lengthWord) {
		// get length of each word
		// add all lengths
		// get timesPlayed
		// lengthWord + lengthWord etc / timesPlayed
		return 0.0;
		
	}

}
