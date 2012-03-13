package prototype.calendarApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class DateField extends JPanel {
	
	private JLabel dateDayLabel;
	private int dateDayNumber;
	public JButton addButton;
	private JPanel header;
	private static final Color selectionColour = new Color(158, 181, 255);

	public DateField() {
		super(new BorderLayout());
		this.dateDayLabel = new JLabel("");
		this.dateDayLabel.setFont(new Font("Tohama", Font.BOLD, 14));
		this.header = new JPanel(new BorderLayout());
		header.setBackground(Color.white);
		header.add(this.dateDayLabel, BorderLayout.WEST);
		this.addButton = new JButton(new ImageIcon("res/plus.png"));
		addButton.setContentAreaFilled(false);
		addButton.setRolloverIcon(new ImageIcon("res/plus_hover.png"));
		header.add(addButton, BorderLayout.EAST);
		this.add(header, BorderLayout.NORTH);
		this.setBackground(Color.white);
	}
	
	public void setValues(CalendarDate date) {
		this.dateDayLabel.setText(" "+date.dateDayNumber);
		if(date.isCurrentMonth == false) {
			this.dateDayLabel.setForeground(Color.gray);
		} else {
			this.dateDayLabel.setForeground(Color.black);
		}
	}
	
	public int getDateDay() {
		return this.dateDayNumber;
	}
	
	public String toString() {
		return ""+dateDayNumber;
	}

	public void setVisuals(boolean isSelected) {
		if(isSelected) {
			this.setBackground(selectionColour);
			this.header.setBackground(selectionColour);
		} else {
			this.header.setBackground(Color.white);
			this.setBackground(Color.white);
		}
	}
	


}
