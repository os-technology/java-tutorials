package javathreads.examples.ch02.example2;

import java.util.Random;

import javathreads.examples.ch02.CharacterEventHandler;
import javathreads.examples.ch02.CharacterListener;
import javathreads.examples.ch02.CharacterSource;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
	private static char[] chars;

	private static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";

	static {
		chars = charArray.toCharArray();
	}

	private Random random;

	private CharacterEventHandler handler;

	public RandomCharacterGenerator() {
		random = new Random();
		handler = new CharacterEventHandler();
	}

	public int getPauseTime() {
		return (int) (Math.max(1000, 5000 * random.nextDouble()));
	}

	@Override
	public void addCharacterListener(CharacterListener cl) {
		handler.addCharacterListener(cl);
	}

	@Override
	public void removeCharacterListener(CharacterListener cl) {

		handler.removeCharacterListener(cl);

	}

	@Override
	public void nextCharacter() {
		handler.fireNewCharacter(this,
				(int) chars[random.nextInt(chars.length)]);
	}

	@Override
	public void run() {
		while (true) {
			nextCharacter();
			try {
				Thread.sleep(getPauseTime());
			} catch (InterruptedException ie) {
				return;
			}
		}
	}
}
