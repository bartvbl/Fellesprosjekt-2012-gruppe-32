package fp.core;

import fp.componentControllers.CalendarViewResizeController;
import fp.componentHandlers.CalendarViewResizeHandler;
import fp.components.calendarViewer.CalendarViewerController;
import fp.components.calendarViewer.CalendarViewerHandler;
import fp.components.smallCalendar.SmallCalendarController;
import fp.components.smallCalendar.SmallCalendarHandler;
import fp.components.smallCalendar.SmallCalendarSelectionController;
import fp.events.EventDispatcher;
import fp.models.DateSelectionModel;
import fp.models.SmallCalendarModel;
import fp.utils.CalendarDataFormatHelper;
import fp.views.CalendarViewerView;
import fp.views.FavouritesView;

public class ClientMain {
	private EventDispatcher eventDispatcher;
	
	public ClientMain() {
		this.createEventDispatcher();
		this.createCalendarViewHandlers();
		this.createCalendarViewControllers();
	}

	private void createEventDispatcher() {
		this.eventDispatcher = new EventDispatcher();
	}

	private void createCalendarViewHandlers() {
		new CalendarViewResizeController(this.eventDispatcher);
		new CalendarViewResizeHandler(this.eventDispatcher);
		
		new CalendarDataFormatHelper();
		DateSelectionModel dateSelectionModel = new DateSelectionModel(eventDispatcher);
		SmallCalendarModel smallCalendarModel = new SmallCalendarModel(eventDispatcher);
		new SmallCalendarController(eventDispatcher, dateSelectionModel, smallCalendarModel);
		new SmallCalendarSelectionController(eventDispatcher, dateSelectionModel, smallCalendarModel);
		new SmallCalendarHandler(this.eventDispatcher, smallCalendarModel, dateSelectionModel);
		
		new CalendarViewerView();
		new CalendarViewerController(eventDispatcher, dateSelectionModel);
		new CalendarViewerHandler(eventDispatcher, dateSelectionModel);
		
		new FavouritesView();
		
		smallCalendarModel.update();
	}
	
	private void createCalendarViewControllers() {
		
	}
}
