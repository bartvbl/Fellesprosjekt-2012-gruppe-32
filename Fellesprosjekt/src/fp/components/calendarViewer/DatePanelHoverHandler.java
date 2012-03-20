package fp.components.calendarViewer;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fp.views.DatePanel;

public class DatePanelHoverHandler implements MouseListener {
	private DatePanel datePanel;

	public DatePanelHoverHandler(DatePanel target) {
		this.datePanel = target;
		this.datePanel.addNewMeetingButton.addMouseListener(this);
	}

	public void mouseEntered(MouseEvent arg0) {
		this.datePanel.setBackground(new Color(240, 240, 240));
		this.datePanel.headerPanel.setBackground(new Color(240, 240, 240));
	}

	public void mouseExited(MouseEvent arg0) {
		this.datePanel.setBackground(Color.white);
		this.datePanel.headerPanel.setBackground(Color.white);
	}

	public void mouseClicked(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
}
