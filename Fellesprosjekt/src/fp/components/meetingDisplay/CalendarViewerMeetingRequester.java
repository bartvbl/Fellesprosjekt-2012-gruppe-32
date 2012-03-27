package fp.components.meetingDisplay;

import nu.xom.Element;
import fp.dataObjects.CalendarDate;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.models.DateSelectionModel;
import fp.net.client.ClientConnector;
import fp.util.CalendarDateConstructor;
import fp.xmlConverters.CalendarDateConverter;

public class CalendarViewerMeetingRequester implements EventHandler {
	private EventDispatcher eventDispatcher;
	private DateSelectionModel model;

	public CalendarViewerMeetingRequester(EventDispatcher eventDispatcher, DateSelectionModel dateSelectionModel) {
		this.eventDispatcher = eventDispatcher;
		this.eventDispatcher.addEventListener(this, EventType.SELECTED_WEEK_CHANGED);
		this.model = dateSelectionModel;
	}
	
	public void handleEvent(Event<?> event) {
		if(event.eventType == EventType.SELECTED_WEEK_CHANGED) {
			this.sendWeekUpdateRequest();
		}
	}

	private void sendWeekUpdateRequest() {
		Message messageToSend = new Message(MessageType.listMeetingsRequest);
		this.generateMessageDataXML(messageToSend);
		ClientConnector.sendMessage(messageToSend);
	}
	
	private void generateMessageDataXML(Message messageToSend) {
		int weekNumber = this.model.getSelectedWeekNumber();
		int yearNumber = this.model.getSelectedYear();
		
		for(int dayNumber = 1; dayNumber < 8; dayNumber++) {
			CalendarDate date = new CalendarDate(yearNumber, weekNumber, dayNumber);
			Element dateElement = CalendarDateConverter.convertCalendarDateToXML(date);
			messageToSend.addDataElement(dateElement);
		}
	}
}
