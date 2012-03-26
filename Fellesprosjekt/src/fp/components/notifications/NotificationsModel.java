package fp.components.notifications;

import java.util.ArrayList;

import fp.dataObjects.MeetingNotification;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;

public class NotificationsModel implements EventHandler {

	private EventDispatcher eventDispatcher;
	private ArrayList<MeetingNotification> notifications = new ArrayList<MeetingNotification>();

	public NotificationsModel(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.eventDispatcher.addEventListener(this, EventType.NOTIFICATION_RECEIVED);
	}

	public void removeNotification(MeetingNotification notification) {
		this.notifications.remove(notification);
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.NOTIFICATIONS_UPDATE_REQUESTED));
	}
	
	public MeetingNotification getNotificationByID(int id) {
		return this.notifications.get(id);
	}
	
	public int getNumActiveNotifications() {
		return this.notifications.size();
	}

	public void handleEvent(Event<?> event) {
		if(event.eventType == EventType.NOTIFICATION_RECEIVED) {
			this.handleIncomingNotification((MeetingNotification)event.getEventParameterObject());
		}
	}
	
	private void handleIncomingNotification(MeetingNotification notification) {
		this.notifications.add(notification);
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.NOTIFICATIONS_UPDATE_REQUESTED));
	}
}
