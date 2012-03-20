package fp.components.calendarViewer;

import java.util.Date;

import fp.componentHandlers.AbstractComponentHandler;
import fp.componentHandlers.ComponentHandlerType;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;

public class CalendarViewerHandler extends AbstractComponentHandler implements EventHandler {

	private CalendarViewerController controller;

	public CalendarViewerHandler(EventDispatcher eventDispatcher, CalendarViewerController calendarViewerController) {
		super(ComponentHandlerType.CALENDAR_VIEW_CALENDAR_VIEWER, eventDispatcher);
		this.controller = calendarViewerController;
		this.addEventListeners();
	}

	private void addEventListeners() {
		this.eventDispatcher.addEventListener(this, EventType.SMALL_CALENDAR_WEEK_SELECTED);
		this.eventDispatcher.addEventListener(this, EventType.WINDOW_RESIZED);
	}

	public void handleEvent(Event<?> event) {
		switch(event.eventType) {
			case WINDOW_RESIZED:
				break;
			case SMALL_CALENDAR_WEEK_SELECTED:
				//this.controller.updateWeek((Date)event.getEventParameterObject());
		}
	}

}
