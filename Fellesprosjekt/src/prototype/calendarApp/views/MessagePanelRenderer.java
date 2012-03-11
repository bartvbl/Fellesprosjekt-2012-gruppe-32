package prototype.calendarApp.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MessagePanelRenderer extends DefaultListCellRenderer implements ListCellRenderer {

	private MessagesPanel messagePanel;
	private final Color backgroundColour = new Color(230, 230, 230);
	
	public MessagePanelRenderer() {
		this.messagePanel = new MessagesPanel();
	}
	public Component getListCellRendererComponent(JList list, Object arg1, int arg2, boolean isSelected, boolean arg4) {
		messagePanel.titleLabel.setText((String) arg1);
		if(isSelected) {
			this.messagePanel.setBackground(Color.gray);
			this.messagePanel.setPreferredSize(new Dimension(260, 74));
		} else {
			this.messagePanel.setBackground(backgroundColour);
			this.messagePanel.setPreferredSize(new Dimension(260, 34));
		}
		return messagePanel;
	}

}
