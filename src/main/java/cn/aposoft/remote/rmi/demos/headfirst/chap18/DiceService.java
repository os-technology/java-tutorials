package cn.aposoft.remote.rmi.demos.headfirst.chap18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiceService implements Service {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8740713083295862596L;
	JLabel label;
	JComboBox<?> numOfDice;

	public JPanel getGuiPanel() {
		JPanel panel = new JPanel();
		JButton button = new JButton("Roll 'em!");
		String[] choices = { "1", "2", "3", "4", "5" };
		numOfDice = new JComboBox<Object>(choices);
		label = new JLabel("dice values here");
		button.addActionListener(new RollEmListener());
		panel.add(numOfDice);
		panel.add(button);
		panel.add(label);
		return panel;
	}

	public class RollEmListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// roll the dice
			String diceOutput = "";
			String selection = (String) numOfDice.getSelectedItem();
			int numOfDiceToRoll = Integer.parseInt(selection);
			for (int i = 0; i < numOfDiceToRoll; i++) {
				int r = (int) ((Math.random() * 6) + 1);
				diceOutput += (" " + r);
			}
			label.setText(diceOutput);

		}
	}

}
