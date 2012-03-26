package fp.views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParticipantSearchResultPanel extends JPanel {
	public static JLabel participantNameLabel = new JLabel();
	public static JButton addParticipantButton;
	
	public ParticipantSearchResultPanel() {
		super(new BorderLayout());
		this.addParticipantButton = new JButton();
		this.addParticipantButton.setContentAreaFilled(false);
		this.addParticipantButton.setIcon(new ImageIcon("res/plus_small.png"));
		this.addParticipantButton.setRolloverIcon(new ImageIcon("res/plus_small2.png"));
		this.add(addParticipantButton, BorderLayout.WEST);
		this.add(participantNameLabel, BorderLayout.CENTER);
	}
	
}
