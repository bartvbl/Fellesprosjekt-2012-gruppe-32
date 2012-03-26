package fp.components.notifications;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JScrollPane;

import fp.dataObjects.Meeting;
import fp.dataObjects.MeetingNotification;
import fp.util.DateStringConverter;
import fp.views.CalendarView;
import fp.views.MessagesPanel;
import fp.views.NotificationsView;

public class NotificationsViewController {
	private NotificationsModel model;
	
	private static final int NOTIFICATIONS_PANEL_OFFSET_X = 20;
	private static final int NOTIFICATIONS_PANEL_OFFSET_Y = 91;
	private static final int DATEPANEL_HEIGHT = 44;

	public NotificationsViewController(NotificationsModel model) {
		new NotificationsView();
		this.model = model;
	}

	public void redraw() {
		NotificationsView.invitationsList.clearListContents();
		for(int i = 0; i < this.model.getNumActiveNotifications(); i++) {
			MeetingNotification notification = this.model.getNotificationByID(i);
			
			MessagesPanel messagesPanel = new MessagesPanel();
			Meeting meeting = notification.meeting;
			messagesPanel.titleLabel.setText(meeting.description);
			messagesPanel.infoLabel.setText(meeting.location + ", " + DateStringConverter.getTimeString(meeting.startTime)
															+ " - " + DateStringConverter.getTimeString(meeting.endTime));
			
			NotificationsView.invitationsList.addInteractiveItem(messagesPanel);
		}
		this.updatePanelPosition();
		NotificationsView.invitationsList.validate();
	}

	private void updatePanelPosition() {
		NotificationsView view = NotificationsView.getInstance();
		Rectangle frameBounds = CalendarView.getJFrame().getBounds();
		Dimension panelSize = view.getSize();
		int x = frameBounds.width - panelSize.width - NOTIFICATIONS_PANEL_OFFSET_X;
		int y = frameBounds.height - panelSize.height - NOTIFICATIONS_PANEL_OFFSET_Y;
		int numNotifications = this.model.getNumActiveNotifications();
		if(numNotifications > 5) {
			numNotifications = 5;
			NotificationsView.mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		} else {
			NotificationsView.mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		}
		int height = numNotifications * DATEPANEL_HEIGHT;
		view.setBounds(x, y, 302, height);
	}
}
