package fp.components.calendarViewer;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.events.EventDispatcher;

public class CalendarViewerController extends AbstractComponentController {

	public CalendarViewerController(EventDispatcher eventDispatcher) {
		super(ComponentControllerType.CALENDAR_VIEW_CALENDAR_VIEWER, eventDispatcher);
		
	}

}
