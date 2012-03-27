package fp.messageHandlers.client;

import java.util.ArrayList;

import nu.xom.Element;
import fp.dataObjects.DayMeetingList;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.messageParsers.Message;
import fp.messageParsers.client.ClientMessageHandler;
import fp.net.client.ClientConnectionContext;
import fp.views.CalendarView;
import fp.xmlConverters.DayMeetingConverter;

public class ListMeetingsResponseMessageHandler implements ClientMessageHandler {

	private EventDispatcher eventDispatcher;

	public ListMeetingsResponseMessageHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	public void handleMessage(Message message, ClientConnectionContext context) {
		ArrayList<Element> dataElements = message.getDataElements();
		for(Element currentElement : dataElements) {
			DayMeetingList meetingList = DayMeetingConverter.convertXMLToDayMeeting(currentElement);
			this.eventDispatcher.dispatchEvent(new Event<DayMeetingList>(EventType.MEETING_DAY_UPDATE_RECEIVED, meetingList));
		}
		CalendarView.calendarViewerLayeredPane.revalidate();
		CalendarView.calendarViewerLayeredPane.repaint();
	}

}
