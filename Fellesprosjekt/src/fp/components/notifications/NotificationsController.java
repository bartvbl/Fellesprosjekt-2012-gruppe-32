package fp.components.notifications;

import javax.swing.ImageIcon;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.views.CalendarView;
import fp.views.NotificationsView;

public class NotificationsController implements EventHandler {
	private EventDispatcher eventDispatcher;
	private final ImageIcon newNotificationsIcon = new ImageIcon("res/mail_new.png");
	private final ImageIcon noNewNotificationsIcon = new ImageIcon("res/mail.png");
	private NotificationsViewController notificationsController;
	private NotificationsModel model;
	
	public NotificationsController(EventDispatcher eventDispatcher, NotificationsModel model) {
		this.eventDispatcher = eventDispatcher;
		this.notificationsController = new NotificationsViewController(model);
		this.eventDispatcher.addEventListener(this, EventType.NO_NEW_NOTIFICATIONS);
		this.eventDispatcher.addEventListener(this, EventType.WINDOW_RESIZED);
		this.eventDispatcher.addEventListener(this, EventType.NOTIFICATIONS_UPDATE_REQUESTED);
		this.model = model;
	}

	public void handleEvent(Event<?> event) {
		switch(event.eventType) {
			case NO_NEW_NOTIFICATIONS:
				this.disableNotificationsButton();
			case WINDOW_RESIZED:
				this.redrawNotificationsPanel();
			case NOTIFICATIONS_UPDATE_REQUESTED:
				this.redrawNotificationsPanel();
		}
	}

	private void disableNotificationsButton() {
		CalendarView.pendingNotificationsButton.setText("Notifications (0)");
		CalendarView.pendingNotificationsButton.setIcon(noNewNotificationsIcon);
		CalendarView.pendingNotificationsButton.setEnabled(false);
		CalendarView.pendingNotificationsButton.setSelected(false);
	}
	
	private void redrawNotificationsPanel() {
		int numberOfNotifications = this.model.getNumActiveNotifications();
		if(numberOfNotifications != 0) {
			CalendarView.pendingNotificationsButton.setText("Notifications ("+numberOfNotifications+")");
			CalendarView.pendingNotificationsButton.setIcon(newNotificationsIcon);
			CalendarView.pendingNotificationsButton.setEnabled(true);
		} else {
			this.disableNotificationsButton();
		}
		this.notificationsController.redraw();
		this.updateNotificationsPanel();
	}

	private void updateNotificationsPanel() {
		NotificationsView view = NotificationsView.getInstance();
		boolean notificationsButtonIsEnabled = CalendarView.pendingNotificationsButton.isSelected();
		view.setVisible(notificationsButtonIsEnabled);
		CalendarView.calendarViewerScrollPane.setEnabled(!notificationsButtonIsEnabled);
	}
}
