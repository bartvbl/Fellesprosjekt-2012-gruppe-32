package fp.components.calendarViewer;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fp.views.CalendarView;
import fp.views.DatePanel;

public class DatePanelHoverHandler implements MouseListener {
	private DatePanel datePanel;

	public DatePanelHoverHandler(DatePanel target) {
		this.datePanel = target;
		this.datePanel.addNewMeetingButton.addMouseListener(this);
		this.datePanel.addNewMeetingButton.setVisible(false);
	}

	public void mouseEntered(MouseEvent arg0) {
		if(CalendarView.calendarViewerScrollPane.isEnabled() == false) {return;}
		this.datePanel.setBackground(new Color(240, 240, 240));
		this.datePanel.headerPanel.setBackground(new Color(240, 240, 240));
		this.datePanel.panelBorder.setForeground(new Color(240, 240, 240));
		this.datePanel.addNewMeetingButton.setVisible(true);
	}

	public void mouseExited(MouseEvent arg0) {
		if(CalendarView.calendarViewerScrollPane.isEnabled() == false) {return;}
		this.datePanel.setBackground(Color.white);
		this.datePanel.headerPanel.setBackground(Color.white);
		this.datePanel.panelBorder.setForeground(Color.white);
		this.datePanel.addNewMeetingButton.setVisible(false);
	}

	public void mouseClicked(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
}
