package fp.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JScrollPane;

import fp.components.calendarViewer.DatePanelHoverHandler;

public class CalendarViewerView {
	public static DatePanel[] dayDatePanels = new DatePanel[7];
	private static String[] dayNames = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
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
		int pixelsPerPanel = getAvailablePixelsPerPanel(scrollPaneBounds);
		enableScrollBars(pixelsPerPanel);
		updateDatePanelBounds(pixelsPerPanel, scrollPaneBounds);
		CalendarView.calendarViewerLayeredPane.setPreferredSize(new Dimension(7*pixelsPerPanel - 1, scrollPaneBounds.height));
		CalendarView.mainLayeredPane.validate();
	}
	
	private static int getAvailablePixelsPerPanel(Rectangle scrollPaneBounds) {
		double availableWidth = ((double)scrollPaneBounds.width + 1d) / 7;
		if(availableWidth < minimumPanelWidth) {
			availableWidth = minimumPanelWidth;
		}
		return (int) Math.ceil(availableWidth);
	}
	
	private static void enableScrollBars(int availableWidth) {
		if(availableWidth <= minimumPanelWidth) {
			CalendarView.calendarViewerScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		} else {
			CalendarView.calendarViewerScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		}
	}
	
	private static void updateDatePanelBounds(int pixelsPerPanel, Rectangle scrollPaneBounds) {
		int currentOffset = 0;
		for(int i = 0; i < 7; i++) {
			DatePanel panel = dayDatePanels[i];
			panel.setBounds(currentOffset, -1, pixelsPerPanel, scrollPaneBounds.height + 20);
			currentOffset += pixelsPerPanel;
		}
	}
}
