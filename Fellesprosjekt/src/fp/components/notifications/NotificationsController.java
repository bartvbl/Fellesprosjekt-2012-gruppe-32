package fp.components.notifications;

import javax.swing.ImageIcon;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.views.CalendarView;

public class NotificationsController implements EventHandler {
	private EventDispatcher eventDispatcher;
	private final ImageIcon newNotificationsIcon = new ImageIcon("res/mail_new.png");
	private final ImageIcon noNewNotificationsIcon = new ImageIcon("res/mail.png");
	
	public NotificationsController(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.eventDispatcher.addEventListener(this, EventType.NO_NEW_NOTIFICATIONS);
	}

	public void handleEvent(Event<?> event) {
		if(event.eventType == EventType.NO_NEW_NOTIFICATIONS) {
			CalendarView.pendingNotificationsButton.setText("Notifications (0)");
			CalendarView.pendingNotificationsButton.setIcon(noNewNotificationsIcon);
			CalendarView.pendingNotificationsButton.setEnabled(false);
		}
	}
	
	
}
