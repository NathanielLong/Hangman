package hangman;
import java.util.ArrayList;

public class Selector {
	public static String getWordByLengthRange(int minLength, int maxLength, ArrayList<String> options) {
		String chosenWord = "";
		String tempWord = "";
		boolean foundNumInRange = false;
		ArrayList<Integer> alreadyCheckedIndexes = new ArrayList<>();

		int selectedIndex = getRandNum(options.size(), alreadyCheckedIndexes);

		while (!foundNumInRange) {
			tempWord = options.get(selectedIndex);
			if (isInRange(tempWord.length(), new int[] { minLength, maxLength })) {
				foundNumInRange = true;
				return tempWord.toUpperCase();
			} else {
				alreadyCheckedIndexes.add(selectedIndex);
				if ((selectedIndex + 1) != options.size()) {
					selectedIndex++;
				}
				else {
					selectedIndex = getRandNum(options.size(), alreadyCheckedIndexes);
				}
			}
		}
		
		return "";
	}
	
	public static int getLongestWordLength(ArrayList<String> options) {
		int longest = 0;
		for (String s : options) {
			if (s.length() > longest) {
				longest = s.length();
			}
		}
		
		return longest;
	}

	private static int getRandNum(int maxLength, ArrayList<Integer> alreadyCheckedIndexes){
//		if (maxLength == alreadyCheckedIndexes.size()) {
//			throw new Exception("Couldn't find any words within the given length range.  Please edit the given word file or provide a new one.");
//		}
		
		int foundNum = -1;
		boolean foundNewNum = false;
		do {
			foundNum = (int) Math.floor(Math.random() * maxLength);
			if (!alreadyCheckedIndexes.contains(foundNum)) {
				return foundNum;
			}
		} while (!foundNewNum);
		return -1;
	}

	private static Boolean isInRange(int num, int[] rangeBounds) {
		return ((num >= rangeBounds[0]) && (num <= rangeBounds[1]));
	}
}
