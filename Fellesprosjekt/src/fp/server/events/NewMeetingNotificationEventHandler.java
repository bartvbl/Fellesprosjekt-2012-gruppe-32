package fp.server.events;

import nu.xom.Element;
import fp.dataObjects.Meeting;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import fp.events.ServerEvent;
import fp.events.ServerEventHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.MeetingNotificationConverter;
import fp.xmlConverters.NotificationConverter;

public class NewMeetingNotificationEventHandler implements ServerEventHandler {

	public void handleEvent(ServerEvent<?> event, ServerClientContext context) {
		MeetingNotification notification = (MeetingNotification) event.getEventParameterObject();
		Message message = new Message(MessageType.meetingNotification);
		
		Element notificationElement = MeetingNotificationConverter.convertMeetingotificationToXML(notification);
		
		message.addDataElement(notificationElement);
		
		context.connectionHandler.sendMessage(message);
	}

}
