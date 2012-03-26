package fp.server.events;

import fp.dataObjects.Meeting;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import fp.events.ServerEvent;
import fp.events.ServerEventHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;

public class NewMeetingNotificationEventHandler implements ServerEventHandler {

	public void handleEvent(ServerEvent<?> event, ServerClientContext context) {
		MeetingNotification notification = (MeetingNotification) event.getEventParameterObject();
		Message message = new Message(MessageType.meetingNotification);
		
	}

}
