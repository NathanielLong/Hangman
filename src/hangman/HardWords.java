package hangman;

public class HardWords {

	private String hardWord;

	public HardWords() {
		super();
	}

	public HardWords(String hardWord) {
		super();
		this.hardWord = hardWord;
	}

	public String getHardWord() {
		return hardWord;
	}

	public void setHardWord(String hardWord) {
		this.hardWord = hardWord;
	}

	@Override
	public String toString() {
		return hardWord;
	}

}
