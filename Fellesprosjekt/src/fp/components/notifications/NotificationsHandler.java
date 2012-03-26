package fp.components.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import prototype.calendarApp.views.CalendarView;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.views.NotificationsView;

public class NotificationsHandler implements ActionListener {
	private EventDispatcher eventDispatcher;

	public NotificationsHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.addEventListeners();
	}

	private void addEventListeners() {
		CalendarView.pendingInvitationsButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == CalendarView.pendingInvitationsButton) {
			this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.NOTIFICATIONS_UPDATE_REQUESTED));
		}
	}
}
