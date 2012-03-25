package fp.components.notifications;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;

public class NotificationsModel implements EventHandler {

	private EventDispatcher eventDispatcher;

	public NotificationsModel(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.eventDispatcher.addEventListener(this, EventType.NOTIFICATION_RECEIVED);
	}

	public void handleEvent(Event<?> event) {
		
	}
	
	

}
