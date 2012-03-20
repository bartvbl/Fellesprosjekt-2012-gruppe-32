package fp.components.calendarViewer;

import java.util.Date;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.events.EventDispatcher;
import fp.models.DateSelectionModel;

public class CalendarViewerController extends AbstractComponentController {

	private DateSelectionModel model;

	public CalendarViewerController(EventDispatcher eventDispatcher, DateSelectionModel model) {
		super(ComponentControllerType.CALENDAR_VIEW_CALENDAR_VIEWER, eventDispatcher);
		this.model = model;
	}

	public void updateWeek() {
		//this.model.
	}

}
