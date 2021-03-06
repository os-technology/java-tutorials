package com.eccl.product.liujian.tutorials.threads.examples.ch03.exapmle2;

import java.awt.Dimension;
import java.awt.Graphics;

import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterDisplayCanvas;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterEvent;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterListener;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterSource;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas
		implements CharacterListener, Runnable {
	private static final long serialVersionUID = 2856498559194759536L;
	private volatile boolean done = false;
	private int curX = 0;

	public AnimatedCharacterDisplayCanvas() {
	}

	public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
		super(cs);
	}

	public synchronized void newCharacter(CharacterEvent ce) {
		curX = 0;
		tmpChar[0] = (char) ce.character;
		repaint();
	}

	protected synchronized void paintComponent(Graphics gc) {
		Dimension d = getSize();
		gc.clearRect(0, 0, d.width, d.height);
		if (tmpChar[0] == 0)
			return;
		@SuppressWarnings("unused")
		int charWidth = fm.charWidth(tmpChar[0]);
		gc.drawChars(tmpChar, 0, 1, curX++, fontHeight);
	}

	public void run() {
		while (!done) {
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				return;
			}
		}
	}

	public void setDone(boolean b) {
		done = b;
	}
}
