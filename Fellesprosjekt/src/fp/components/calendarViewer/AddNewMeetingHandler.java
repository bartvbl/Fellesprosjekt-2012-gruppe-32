package fp.components.calendarViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.components.smallCalendar.CalendarDateConstructor;
import fp.dataObjects.CalendarDate;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.models.DateSelectionModel;
import fp.views.NewMeetingWindow;

public class AddNewMeetingHandler implements ActionListener {
	private DateSelectionModel selectionModel;
	private EventDispatcher eventDispatcher;

	public AddNewMeetingHandler(DateSelectionModel model, EventDispatcher eventDispatcher) {
		this.selectionModel = model;
		this.eventDispatcher = eventDispatcher;
	}
	
	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();
		int dayIndex = Integer.parseInt(actionCommand.split(" ")[4]);
		int year = this.selectionModel.getSelectedYear();
		int week = this.selectionModel.getSelectedWeekNumber();
		int date = CalendarDateConstructor.getWeekDayDates(week, year)[dayIndex];
		NewMeetingWindow.setFrameVisible(true);
		CalendarDate calendarDate = new CalendarDate(year, week, date);
		this.eventDispatcher.dispatchEvent(new Event<CalendarDate>(EventType.SHOW_NEW_MEETING, calendarDate));
	}

}
