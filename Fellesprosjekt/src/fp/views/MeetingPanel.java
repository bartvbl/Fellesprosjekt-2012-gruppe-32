package fp.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import fp.dataObjects.Meeting;

public class MeetingPanel extends JPanel{
	public MeetingPanel(Meeting currentMeeting) {
		super(new FlowLayout(FlowLayout.LEADING));
		this.setBackground(new Color(255, 160, 160));
		this.setBorder(new LineBorder(new Color(135, 0, 0)));
		JLabel titleLabel = new JLabel(currentMeeting.description);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.add(titleLabel);
	}
	
}
