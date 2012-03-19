package fp.core;

import fp.componentHandlers.CalendarViewResizeHandler;
import fp.componentHandlers.SmallCalendarHandler;
import fp.events.EventDispatcher;

public class Main {
	private EventDispatcher eventDispatcher;
	
	public Main() {
		this.createEVentDispatcher();
		this.createCalendarViewHandlers();
	}

	private void createEVentDispatcher() {
		this.eventDispatcher = new EventDispatcher();
	}

	private void createCalendarViewHandlers() {
		new SmallCalendarHandler(this.eventDispatcher);
		new CalendarViewResizeHandler(this.eventDispatcher);
	}
}
