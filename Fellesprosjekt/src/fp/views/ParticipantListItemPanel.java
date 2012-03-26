package fp.views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParticipantListItemPanel extends JPanel {
	public static JLabel participantNameLabel = new JLabel();
	public static JButton addParticipantButton;
	
	public ParticipantListItemPanel() {
		super(new BorderLayout());
		ParticipantSearchResultPanel.addParticipantButton = new JButton();
		ParticipantSearchResultPanel.addParticipantButton.setContentAreaFilled(false);
		ParticipantSearchResultPanel.addParticipantButton.setIcon(new ImageIcon("res/trash.png"));
		this.add(addParticipantButton, BorderLayout.WEST);
		this.add(participantNameLabel, BorderLayout.CENTER);
	}
}
