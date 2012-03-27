package fp.core;

import prototype.calendarApp.views.CalendarView;
import fp.componentControllers.CalendarViewResizeController;
import fp.componentHandlers.AddNewMeetingButtonHandler;
import fp.componentHandlers.CalendarViewResizeHandler;
import fp.components.calendarViewer.AddNewMeetingHandler;
import fp.components.calendarViewer.CalendarViewerController;
import fp.components.calendarViewer.CalendarViewerHandler;
import fp.components.calendarViewer.ChangeWeekButtonHandler;
import fp.components.loginScreen.LoginScreenHandler;
import fp.components.meetingDisplay.CalendarViewerMeetingUpdater;
import fp.components.newMeeting.NewMeetingController;
import fp.components.newMeeting.NewMeetingHandler;
import fp.components.newMeeting.NewMeetingModel;
import fp.components.notifications.NotificationsController;
import fp.components.notifications.NotificationsHandler;
import fp.components.notifications.NotificationsModel;
import fp.components.notifications.NotificationsMouseHandler;
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
import fp.views.NewMeetingWindow;

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
		
		new CalendarViewerView(new AddNewMeetingHandler(dateSelectionModel, eventDispatcher));

		CalendarViewerController calendarViewerController = new CalendarViewerController(eventDispatcher, dateSelectionModel);
		new CalendarViewerHandler(eventDispatcher, calendarViewerController);
		new ChangeWeekButtonHandler(eventDispatcher, calendarViewerController);
		new AddNewMeetingButtonHandler(eventDispatcher);
		new FavouritesView();
		
		new ClientMessageParser(eventDispatcher);
		ClientConnector connector = new ClientConnector(eventDispatcher);
		new ClientConnectionReceiverWorker(connector);
		new LoginScreenHandler();
		
		NotificationsModel notificationsModel = new NotificationsModel(eventDispatcher);
		new NotificationsController(eventDispatcher, notificationsModel);
		new NotificationsHandler(eventDispatcher);
		
		new NewMeetingWindow();
		
		new NewMeetingHandler(eventDispatcher, new NewMeetingController(eventDispatcher));
		
		new CalendarViewerMeetingUpdater(eventDispatcher, dateSelectionModel);
	}
	
	private void createCalendarViewControllers() {
		
	}
}
