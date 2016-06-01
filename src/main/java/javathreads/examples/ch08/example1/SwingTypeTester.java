package javathreads.examples.ch08.example1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingTypeTester extends JFrame implements CharacterSource {
	private static final long serialVersionUID = 304466085969093824L;
	protected RandomCharacterGenerator producer;
	private AnimatedCharacterDisplayCanvas displayCanvas;
	private CharacterDisplayCanvas feedbackCanvas;
	private JButton quitButton;
	private JButton startButton;
	private JButton stopButton;
	private CharacterEventHandler handler;
	private ScoreLabel score;

	public SwingTypeTester() {
		initComponents();
	}

	private void initComponents() {
		handler = new CharacterEventHandler();
		producer = new RandomCharacterGenerator();
		producer.setDone(true);
		producer.start();
		displayCanvas = new AnimatedCharacterDisplayCanvas(producer);
		feedbackCanvas = new CharacterDisplayCanvas(this);
		quitButton = new JButton();
		startButton = new JButton();
		stopButton = new JButton();
		score = new ScoreLabel(producer, this);

		Container pane = getContentPane();
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		p1.add(displayCanvas);
		p1.add(feedbackCanvas);

		JPanel p2 = new JPanel();
		score.setText("      ");
		score.setFont(new Font("MONOSPACED", Font.BOLD, 30));
		p2.add(score);
		startButton.setText("Start");
		p2.add(startButton);
		stopButton.setText("Stop");
		stopButton.setEnabled(false);
		p2.add(stopButton);
		quitButton.setText("Quit");
		p2.add(quitButton);
		p1.add(p2);
		pane.add(p1, BorderLayout.NORTH);
		pack();

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
				displayCanvas.setDone(false);
				producer.setDone(false);
				score.resetScore();
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
				producer.setDone(true);
				displayCanvas.setDone(true);
				feedbackCanvas.setEnabled(false);
			}
		});
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quit();
			}
		});
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
