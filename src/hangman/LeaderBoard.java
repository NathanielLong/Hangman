package hangman;


import java.io.BufferedReader;
import java.io.File;
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

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			int lineCounter = 0;
			while ((line = br.readLine()) != null) {
				switch (lineCounter) {
				case 0:
					totalWins = Integer.valueOf(line);
					break;
				case 1:
					totalLosses = Integer.valueOf(line);
					break;
				default:
					String[] thisEntry = line.split(" ");
					leaderBoardMap.put(thisEntry[0], Integer.valueOf(thisEntry[1]));
				}
				lineCounter++;
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static void saveLeaderBoard() {
			Path p = Paths.get("resources","leaderBoard.txt");
			File file = p.toFile();
			PrintWriter output = null;
			
			try {
				output = new PrintWriter(new FileOutputStream(file, true));
				output.println(totalWins);
				output.println(totalLosses);
				for (String s : leaderBoardMap.keySet())
				{
					output.println(s + " " + leaderBoardMap.get(s));
				}
			}
			catch (IOException e) {
				System.out.println(e);
			}
		}
	
	public static void addVictory(String userName, int numNewPoints) {
		totalWins++;
		
		for (String s : leaderBoardMap.keySet()) {
			if (s.equalsIgnoreCase(userName)) {
				Integer i = leaderBoardMap.get(s);
				leaderBoardMap.put(s,i + numNewPoints);
				return;
			}
		}
		
		leaderBoardMap.put(userName,numNewPoints);
	}
	
	public static void addLoss() {
		totalLosses++;
	}
	
}


