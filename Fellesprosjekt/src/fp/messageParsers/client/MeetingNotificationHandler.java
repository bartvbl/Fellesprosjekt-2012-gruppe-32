package fp.messageParsers.client;

import java.util.ArrayList;

import nu.xom.Element;

import fp.dataObjects.Notification;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.messageParsers.Message;
import fp.net.client.ClientConnectionContext;
import fp.xmlConverters.NotificationConverter;

public class MeetingNotificationHandler implements ClientMessageHandler {

	private EventDispatcher eventDispatcher;

	public MeetingNotificationHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	public void handleMessage(Message message, ClientConnectionContext context) {
		ArrayList<Element> dataElements = message.getDataElements();
		for(Element dataElement : dataElements) {
			Notification notification = NotificationConverter.convertXMLToNotification(dataElement);
			this.eventDispatcher.dispatchEvent(new Event<Notification>(EventType.NOTIFICATION_RECEIVED, notification));
		}
	}

}
