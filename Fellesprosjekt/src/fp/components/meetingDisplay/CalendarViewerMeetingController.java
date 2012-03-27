package fp.components.meetingDisplay;

import fp.dataObjects.DayMeetingList;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.views.CalendarView;
import fp.views.CalendarViewerView;
import fp.views.DatePanel;

public class CalendarViewerMeetingController implements EventHandler {

	private EventDispatcher eventDispatcher;

	public CalendarViewerMeetingController(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.eventDispatcher.addEventListener(this, EventType.MEETING_DAY_UPDATE_RECEIVED);
		this.eventDispatcher.addEventListener(this, EventType.WINDOW_RESIZED);
	}

	public void handleEvent(Event<?> event) {
		if(event.eventType == EventType.MEETING_DAY_UPDATE_RECEIVED) {
			this.updateDatePanel((DayMeetingList)event.getEventParameterObject());
		} else if(event.eventType == EventType.WINDOW_RESIZED) {
			CalendarView.calendarViewerLayeredPane.revalidate();
			CalendarView.calendarViewerLayeredPane.repaint();
		}
	}

	private void updateDatePanel(DayMeetingList meetingList) {
		int dayIndex = meetingList.date.dayInWeek - 1;//dayInWeek is 1-indexed. The DatePanel array requires 0-indexed numbers
		DatePanel[] datePanels = CalendarViewerView.dayDatePanels;
		datePanels[dayIndex].controller.displayMeetingList(meetingList);
	}
	
}
