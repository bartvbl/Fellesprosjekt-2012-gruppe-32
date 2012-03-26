package fp.components.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.views.CalendarView;

public class NotificationsHandler implements ActionListener {
	private EventDispatcher eventDispatcher;

	public NotificationsHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.addEventListeners();
	}

	private void addEventListeners() {
		CalendarView.pendingNotificationsButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == CalendarView.pendingNotificationsButton) {
			this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.NOTIFICATIONS_UPDATE_REQUESTED));
		}
	}
}
