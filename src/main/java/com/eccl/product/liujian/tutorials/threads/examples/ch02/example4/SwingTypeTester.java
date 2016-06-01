/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.examples.ch02.example4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterDisplayCanvas;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterEventHandler;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterListener;
import com.eccl.product.liujian.tutorials.threads.examples.ch02.CharacterSource;

/**
 * @author LiuJian
 * 
 */
public class SwingTypeTester extends JFrame implements CharacterSource {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1738077607826082652L;

	protected RandomCharacterGenerator producer;

	private CharacterDisplayCanvas displayCanvas;

	private CharacterDisplayCanvas feedbackCanvas;

	private JButton quitButton;

	private JButton startButton;

	private JButton stopButton;

	private CharacterEventHandler handler;

	public SwingTypeTester() {

		initComponents();

	}

	private void initComponents() {

		handler = new CharacterEventHandler();

		displayCanvas = new CharacterDisplayCanvas();

		feedbackCanvas = new CharacterDisplayCanvas(this);

		quitButton = new JButton();

		startButton = new JButton();
		stopButton = new JButton();

		add(displayCanvas, BorderLayout.NORTH);

		add(feedbackCanvas, BorderLayout.CENTER);

		JPanel p = new JPanel();

		startButton.setText("Start");
		quitButton.setText("Quit");
		stopButton.setText("Stop");
		p.add(startButton);
		p.add(quitButton);
		p.add(stopButton);
		add(p, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				quit();
			}
		});

		feedbackCanvas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (c != KeyEvent.CHAR_UNDEFINED)
					newCharacter((int) c);
			}
		});

		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				// producer
				// 在每次执行时实例化,是因为一个线程在执行结束后,不可以进行第二次start,因此每次必须新启动一个线程实例
				producer = new RandomCharacterGenerator();

				displayCanvas.setCharacterSource(producer);
				// the second thread: generate a new character in a random time
				// between 1 second to 5 seconds
				producer.start();

				startButton.setEnabled(false);
				stopButton.setEnabled(true);

				feedbackCanvas.setEnabled(true);

				feedbackCanvas.requestFocus();

			}

		});

		stopButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				startButton.setEnabled(true);

				stopButton.setEnabled(false);

				producer.interrupt();

				feedbackCanvas.setEnabled(false);
			}

		});

		quitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				quit();

			}

		});

		pack();

	}

	private void quit() {

		System.exit(0);

	}

	public void addCharacterListener(CharacterListener cl) {

		handler.addCharacterListener(cl);

	}

	public void removeCharacterListener(CharacterListener cl) {

		handler.removeCharacterListener(cl);

	}

	public void newCharacter(int c) {

		handler.fireNewCharacter(this, c);

	}

	public void nextCharacter() {

		throw new IllegalStateException("We don't produce on demand");

	}

	public static void main(String args[]) {

		new SwingTypeTester().setVisible(true);

	}

}
