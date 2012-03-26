package fp.components.notifications;

import fp.views.CalendarView;
import fp.views.NotificationsView;

public class NotificationsViewController {
	private NotificationsModel model;

	public NotificationsViewController(NotificationsModel model) {
		new NotificationsView();
		this.model = model;
	}

	public void redraw() {
		// TODO Auto-generated method stub
		
	}
}
