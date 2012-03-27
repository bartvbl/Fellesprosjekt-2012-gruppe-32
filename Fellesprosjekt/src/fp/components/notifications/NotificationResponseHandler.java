package fp.components.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nu.xom.Element;

import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import fp.dataObjects.Notification.NotificationStatus;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnector;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.NotificationConverter;

public class NotificationResponseHandler implements ActionListener {
	
	private NotificationsModel model;

	public NotificationResponseHandler(NotificationsModel model) {
		this.model = model;
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		int buttonIndex = this.getButtonIndex(command);
		MeetingNotification notification = this.model.getNotificationByID(buttonIndex);
		
		NotificationStatus chosenStatus = this.getChosenNewStatus(command);
		
		Message message = this.constructMessage(notification.notification, chosenStatus);
		ClientConnector.sendMessage(message);
		
		this.model.removeNotification(notification);
	}


	private int getButtonIndex(String command) {
		return Integer.parseInt(command.split(" ")[0]);
	}
	
	private NotificationStatus getChosenNewStatus(String command) {
		return Enum.valueOf(NotificationStatus.class, command.split(" ")[1]);
	}

	private Message constructMessage(Notification notification, NotificationStatus chosenStatus) {
		Message message = new Message(MessageType.registerNotificationResponse);
		
		Notification notificationToSend = new Notification(notification.userID, notification.meetingID, chosenStatus, notification.notificationType);
		Element dataElement = NotificationConverter.convertNotificationToXML(notificationToSend);
		
		message.addDataElement(dataElement);
		return message;
	}
}
