package hangman;

public class EasyWords {

	private String easyWord;

	public EasyWords() {
		super();
	}

	public EasyWords(String easyWord) {
		super();
		this.easyWord = easyWord;
	}

	public String getEasyWord() {
		return easyWord;
	}

	public void setEasyWord(String easyWord) {
		this.easyWord = easyWord;
	}

	@Override
	public String toString() {
		return easyWord;
	}

}
