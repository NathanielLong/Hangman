package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class LeaderBoard {
	
	// vars
	// hashmap for name and # of wins
	
	static int totalWins;
	static int totalLosses;
	
	static HashMap<String, Integer> leaderBoardMap = new HashMap<>();
	
	
	
	public static void loadLeaderBoard(){
		Path p = Paths.get("resources", "leaderBoard.txt");
		File f = p.toFile();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			int lineCounter = 0;
			while((line = br.readLine()) != null) {
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
				int a = 0;
				
			}
				
		
			
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	public static void saveLeaderBoard() {}

}
