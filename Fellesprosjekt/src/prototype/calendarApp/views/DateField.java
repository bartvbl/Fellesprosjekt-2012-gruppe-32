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
	private static final Color selectionColour = new Color(158, 181, 255);

	public DateField() {
		super(new BorderLayout());
		this.dateDayLabel = new JLabel("");
		this.dateDayLabel.setFont(new Font("Tohama", Font.BOLD, 14));
		
		this.add(this.dateDayLabel, BorderLayout.NORTH);
		//this.add(new JButton(new ImageIcon("res/plus.png")), BorderLayout.EAST);
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
		} else {
			this.setBackground(Color.white);
		}
	}
	


}
