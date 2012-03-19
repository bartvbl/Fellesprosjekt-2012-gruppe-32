package fp.core;

import fp.componentHandlers.SmallCalendarHandler;

public class Main {
	public Main() {
		this.createCalendarViewHandlers();
	}

	private void createCalendarViewHandlers() {
		new SmallCalendarHandler();
	}
}
