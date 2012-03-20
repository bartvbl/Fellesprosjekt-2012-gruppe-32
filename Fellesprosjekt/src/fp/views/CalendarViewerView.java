package fp.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import fp.components.calendarViewer.DatePanelHoverHandler;

public class CalendarViewerView {
	private static String[] dayNames = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	public static DatePanel[] dayDatePanels = new DatePanel[7];
	private static final int minimumPanelWidth = 140;
	
	public CalendarViewerView() {
		CalendarView.calendarViewerLayeredPane.getParent().setBackground(Color.white);
		this.createDayPanels();
	}
	
	private void createDayPanels() {
		for(int i = 0; i < 7; i++) {
			DatePanel currentPanel = new DatePanel();
			dayDatePanels[i] = currentPanel;
			currentPanel.dayNameLabel.setText(" " + dayNames[i]);
			currentPanel.addMouseListener(new DatePanelHoverHandler(currentPanel));
			CalendarView.calendarViewerLayeredPane.add(currentPanel, i+1);
		}
	}

	public static void handleRedraw() {
		Rectangle scrollPaneBounds = CalendarView.calendarViewerScrollPane.getViewportBorderBounds();
		double availableWidth = ((double)scrollPaneBounds.width + 1d) / 7;
		if(availableWidth < minimumPanelWidth) {
			availableWidth = minimumPanelWidth;
		}
		int pixelsPerPanel = (int) availableWidth + 1;
		int currentOffset = 0;
		for(int i = 0; i < 7; i++) {
			DatePanel panel = dayDatePanels[i];
			panel.setBounds(currentOffset, -1, pixelsPerPanel, scrollPaneBounds.height + 20);
			currentOffset += pixelsPerPanel;
		}
		CalendarView.calendarViewerLayeredPane.setPreferredSize(new Dimension((int)(availableWidth * 7) - 2, scrollPaneBounds.height));
		CalendarView.mainLayeredPane.validate();
	}
}
