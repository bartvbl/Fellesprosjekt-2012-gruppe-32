package fp.core;

import fp.componentControllers.CalendarViewResizeController;
import fp.componentHandlers.CalendarViewResizeHandler;
import fp.components.smallCalendar.SmallCalendarController;
import fp.components.smallCalendar.SmallCalendarHandler;
import fp.events.EventDispatcher;

public class ClientMain {
	private EventDispatcher eventDispatcher;
	
	public ClientMain() {
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
