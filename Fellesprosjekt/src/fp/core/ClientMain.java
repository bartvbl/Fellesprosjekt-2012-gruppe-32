package fp.core;

import fp.componentControllers.CalendarViewResizeController;
import fp.componentHandlers.AddNewMeetingButtonHandler;
import fp.componentHandlers.CalendarViewResizeHandler;
import fp.components.calendarViewer.CalendarViewerController;
import fp.components.calendarViewer.CalendarViewerHandler;
import fp.components.calendarViewer.ChangeWeekButtonHandler;
import fp.components.loginScreen.LoginScreenHandler;
import fp.components.smallCalendar.SmallCalendarController;
import fp.components.smallCalendar.SmallCalendarHandler;
import fp.events.EventDispatcher;
import fp.messageParsers.client.ClientMessageParser;
import fp.models.DateSelectionModel;
import fp.net.client.ClientConnectionHandler;
import fp.net.client.ClientConnectionReceiverWorker;
import fp.net.client.ClientConnector;
import fp.util.RandomStringGenerator;
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
		
		DateSelectionModel dateSelectionModel = new DateSelectionModel();
		SmallCalendarController smallCalendar = new SmallCalendarController(eventDispatcher, dateSelectionModel);
		new SmallCalendarHandler(this.eventDispatcher, smallCalendar);
		
		new CalendarViewerView();
		CalendarViewerController calendarViewerController = new CalendarViewerController(eventDispatcher, dateSelectionModel);
		new CalendarViewerHandler(eventDispatcher, calendarViewerController);
		new ChangeWeekButtonHandler(eventDispatcher, calendarViewerController);
		new AddNewMeetingButtonHandler(eventDispatcher);
		
		new FavouritesView();
		
		new ClientMessageParser(eventDispatcher);
		ClientConnector connector = new ClientConnector(eventDispatcher);
		new ClientConnectionReceiverWorker(connector);
		new LoginScreenHandler();
	}
	
	private void createCalendarViewControllers() {
		
	}
}
