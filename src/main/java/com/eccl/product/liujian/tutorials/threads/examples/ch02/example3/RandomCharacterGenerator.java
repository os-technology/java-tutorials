/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.examples.ch02.example3;

import java.util.Random;

import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterEventHandler;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterListener;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterSource;

/**
 * @author LiuJian
 * 
 */
public class RandomCharacterGenerator extends Thread implements CharacterSource {

	private volatile boolean done = false;

	public void setDone(boolean done) {
		this.done = done;
	}

	static char[] chars;

	static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";

	static {

		chars = charArray.toCharArray();

	}

	Random random;

	CharacterEventHandler handler;

	public RandomCharacterGenerator() {

		random = new Random();

		handler = new CharacterEventHandler();

	}

	public int getPauseTime() {

		return (int) (Math.max(1000, 5000 * random.nextDouble()));

	}

	public void addCharacterListener(CharacterListener cl) {

		handler.addCharacterListener(cl);

	}

	public void removeCharacterListener(CharacterListener cl) {

		handler.removeCharacterListener(cl);

	}

	public void nextCharacter() {
		handler.fireNewCharacter(this,
				(int) chars[random.nextInt(chars.length)]);
	}

	public void run() {
		while (!done) {
			nextCharacter();
			try {
				Thread.sleep(getPauseTime());
			} catch (InterruptedException ie) {
				return;
			}
		}
	}
}
