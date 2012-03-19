package fp.core;

import fp.componentControllers.CalendarViewResizeController;
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
		new SmallCalendarHandler(this.eventDispatcher);
		new CalendarViewResizeHandler(this.eventDispatcher);
	}
	
	private void createCalendarViewControllers() {
		new CalendarViewResizeController(this.eventDispatcher);
	}
}
