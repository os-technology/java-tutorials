package com.eccl.product.liujian.tutorials.threads.examples.ch03.exapmle2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterEvent;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterListener;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterSource;

public class ScoreLabel extends JLabel implements CharacterListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9098411690437888666L;
	private volatile int score = 0;
	private int char2type = -1;
	private CharacterSource generator = null, typist = null;
	private Lock scoreLock = new ReentrantLock();

	public ScoreLabel(CharacterSource generator, CharacterSource typist) {
		this.generator = generator;
		this.typist = typist;

		if (generator != null)
			generator.addCharacterListener(this);
		if (typist != null)
			typist.addCharacterListener(this);
	}

	public ScoreLabel() {
		this(null, null);
	}

	public void resetGenerator(CharacterSource newGenerator) {
		try {
			scoreLock.lock();
			if (generator != null)
				generator.removeCharacterListener(this);

			generator = newGenerator;
			if (generator != null)
				generator.addCharacterListener(this);
		} finally {
			scoreLock.unlock();
		}
	}

	public void resetTypist(CharacterSource newTypist) {
		try {
			scoreLock.lock();
			if (typist != null)
				typist.removeCharacterListener(this);

			typist = newTypist;
			if (typist != null)
				typist.addCharacterListener(this);
		} finally {
			scoreLock.unlock();
		}
	}

	public void resetScore() {
		try {
			scoreLock.lock();
			score = 0;
			char2type = -1;
			setScore();
		} finally {
			scoreLock.unlock();
		}
	}

	private void setScore() {
		// This method will be explained later in chapter 7
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setText(Integer.toString(score));
			}
		});
	}

	public void newCharacter(CharacterEvent ce) {
		try {
			scoreLock.lock();
			// Previous character not typed correctly - 1 point penalty
			if (ce.source == generator) {
				if (char2type != -1) {
					score--;
					setScore();
				}
				char2type = ce.character;
			}

			// If character is extraneous - 1 point penalty
			// If character does not match - 1 point penalty
			else {
				if (char2type != ce.character) {
					score--;
				} else {
					score++;
					char2type = -1;
				}
				setScore();
			}
		} finally {
			scoreLock.unlock();
		}
	}
}
