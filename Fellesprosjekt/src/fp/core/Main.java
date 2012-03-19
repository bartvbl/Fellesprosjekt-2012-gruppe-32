package fp.core;

import fp.componentControllers.CalendarViewResizeController;
import fp.componentControllers.SmallCalendarController;
import fp.componentHandlers.CalendarViewResizeHandler;
import fp.componentHandlers.SmallCalendarHandler;
import fp.events.EventDispatcher;

public class Main {
	private EventDispatcher eventDispatcher;
	
	public Main() {
		this.createEVentDispatcher();
		this.createCalendarViewHandlers();
		this.createCalendarViewControllers();
	}

	private void createEVentDispatcher() {
		this.eventDispatcher = new EventDispatcher();
	}

	private void createCalendarViewHandlers() {
		new CalendarViewResizeController(this.eventDispatcher);
		SmallCalendarController smallCalendar = new SmallCalendarController(eventDispatcher);
		new SmallCalendarHandler(this.eventDispatcher, smallCalendar);
		
		new CalendarViewResizeHandler(this.eventDispatcher);
	}
	
	private void createCalendarViewControllers() {
		
	}
}
