package fp.messageParsers.client;

import java.util.ArrayList;

import nu.xom.Element;

import fp.dataObjects.Meeting;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.messageParsers.Message;
import fp.net.client.ClientConnectionContext;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.NotificationConverter;

public class MeetingNotificationHandler implements ClientMessageHandler {

	private EventDispatcher eventDispatcher;

	public MeetingNotificationHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	public void handleMessage(Message message, ClientConnectionContext context) {
		ArrayList<Element> dataElements = message.getDataElements();
		if(dataElements.size() == 0) {
			this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.NO_NEW_NOTIFICATIONS));
		}
		for(int i = 0; i < dataElements.size(); i += 2) {
			Notification notification = NotificationConverter.convertXMLToNotification(dataElements.get(i));
			Meeting meeting = MeetingConverter.convertXMLToMeeting(dataElements.get(i+1));
			this.eventDispatcher.dispatchEvent(new Event<MeetingNotification>(EventType.NOTIFICATION_RECEIVED, new MeetingNotification(meeting, notification)));
		}
	}

}
