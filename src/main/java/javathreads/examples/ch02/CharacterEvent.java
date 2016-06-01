package javathreads.examples.ch02;

public class CharacterEvent {

	private CharacterSource source;

	private int character;

	public CharacterEvent(CharacterSource cs, int c) {

		setSource(cs);

		setCharacter(c);

	}

	public CharacterSource getSource() {
		return source;
	}

	public void setSource(CharacterSource source) {
		this.source = source;
	}

	public int getCharacter() {
		return character;
	}

	public void setCharacter(int character) {
		this.character = character;
	}
}