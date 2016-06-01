package cn.aposoft.remote.rmi.demos.headfirst.chap18;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DayOfTheWeekService implements Service {

	private static final long serialVersionUID = -3323664716156988058L;
	JLabel outputLabel;
	JComboBox<?> month;
	JTextField day;
	JTextField year;

	public JPanel getGuiPanel() {
		JPanel panel = new JPanel();
		JButton button = new JButton("Do it!");
		button.addActionListener(new DoItListener());
		outputLabel = new JLabel("date appears here");

		DateFormatSymbols dateStuff = new DateFormatSymbols();
		month = new JComboBox<Object>(dateStuff.getMonths());
		day = new JTextField(8);
		year = new JTextField(8);

		JPanel inputPanel = new JPanel(new GridLayout(3, 2));
		inputPanel.add(new JLabel("Month"));
		inputPanel.add(month);
		inputPanel.add(new JLabel("Day"));
		inputPanel.add(day);
		inputPanel.add(new JLabel("Year"));
		inputPanel.add(year);

		panel.add(inputPanel);
		panel.add(button);
		panel.add(outputLabel);
		return panel;
	}

	public class DoItListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			int monthNum = month.getSelectedIndex();
			int dayNum = Integer.parseInt(day.getText());
			int yearNum = Integer.parseInt(year.getText());
			Calendar c = Calendar.getInstance();
			c.set(Calendar.MONTH, monthNum);
			c.set(Calendar.DAY_OF_MONTH, dayNum);
			c.set(Calendar.YEAR, yearNum);
			Date date = c.getTime();
			String dayOfWeek = (new SimpleDateFormat("EEEE")).format(date);
			outputLabel.setText(dayOfWeek);

		}
	}

}