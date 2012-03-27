package fp.components.meetingDisplay;

import fp.components.smallCalendar.CalendarDateConstructor;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.models.DateSelectionModel;

public class CalendarViewerMeetingUpdater implements EventHandler {
	private EventDispatcher eventDispatcher;
	private DateSelectionModel model;

	public CalendarViewerMeetingUpdater(EventDispatcher eventDispatcher, DateSelectionModel dateSelectionModel) {
		this.eventDispatcher = eventDispatcher;
		this.eventDispatcher.addEventListener(this, EventType.SELECTED_WEEK_CHANGED);
		this.model = dateSelectionModel;
	}
	
	public void handleEvent(Event<?> event) {
		if(event.eventType == EventType.SELECTED_WEEK_CHANGED){this.sendWeekUpdateRequest();}
		//System.out.println(event.getEventParameterObject().toString());
	}

	private void sendWeekUpdateRequest() {
		int weekNumber = this.model.getSelectedWeekNumber();
		int yearNumber = this.model.getSelectedYear();
		
		//CalendarDateConstructor.getWeekDayDates(week, year)
	}
}
