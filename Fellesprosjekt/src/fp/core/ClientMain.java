package fp.core;

import fp.componentControllers.CalendarViewResizeController;
import fp.componentHandlers.CalendarViewResizeHandler;
import fp.components.calendarViewer.CalendarViewerController;
import fp.components.calendarViewer.CalendarViewerHandler;
import fp.components.smallCalendar.SmallCalendarController;
import fp.components.smallCalendar.SmallCalendarHandler;
import fp.events.EventDispatcher;
import fp.models.DateSelectionModel;
import fp.views.CalendarViewerView;

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
		new CalendarViewResizeHandler(this.eventDispatcher);
		
		DateSelectionModel dateSelectionModel = new DateSelectionModel();
		SmallCalendarController smallCalendar = new SmallCalendarController(eventDispatcher, dateSelectionModel);
		new SmallCalendarHandler(this.eventDispatcher, smallCalendar);
		
		CalendarViewerController calendarViewerController = new CalendarViewerController(eventDispatcher, dateSelectionModel);
		new CalendarViewerHandler(eventDispatcher, calendarViewerController);
		new CalendarViewerView();
	}
	
	private void createCalendarViewControllers() {
		
	}
}
