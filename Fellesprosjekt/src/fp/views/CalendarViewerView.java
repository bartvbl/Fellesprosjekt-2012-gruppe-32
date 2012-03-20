package fp.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

public class CalendarViewerView {
	private static CalendarViewHourIndicator hourIndicator;
	private static String[] dayNames = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	public static DatePanel[] dayDatePanels = new DatePanel[7];
	
	public CalendarViewerView() {
		CalendarView.calendarViewerLayeredPane.getParent().setBackground(Color.white);
		this.createHourIndicator();
		this.createDayPanels();
	}
	
	private void createHourIndicator() {
		hourIndicator = new CalendarViewHourIndicator();
		CalendarView.calendarViewerLayeredPane.add(hourIndicator, 0);
	}
	
	private void createDayPanels() {
		for(int i = 0; i < 7; i++) {
			DatePanel currentPanel = new DatePanel();
			dayDatePanels[i] = currentPanel;
			currentPanel.dayNameLabel.setText(dayNames[i]);
			
		}
	}

	public static void handleRedraw() {
		Rectangle scrollPaneBounds = CalendarView.calendarViewerScrollPane.getViewportBorderBounds();
		hourIndicator.setBounds(0, 30, 50, scrollPaneBounds.height - 30);
		CalendarView.calendarViewerLayeredPane.setPreferredSize(new Dimension(1000, 300));
		CalendarView.mainLayeredPane.validate();
	}
}