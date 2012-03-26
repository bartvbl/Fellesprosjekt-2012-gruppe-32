package fp.components.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.dataObjects.Notification.NotificationStatus;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;

public class NotificationResponseHandler implements ActionListener {

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		int meetingID = this.getMeetingID(command);
		NotificationStatus chosenStatus = this.getChosenNewStatus(command);
		
		Message message = new Message(MessageType.registerNotificationResponse);
		//Element dataElement = new Element("notificationUpdate");
	}

	private int getMeetingID(String command) {
		return Integer.parseInt(command.split(" ")[0]);
	}
	
	private NotificationStatus getChosenNewStatus(String command) {
		return Enum.valueOf(NotificationStatus.class, command.split(" ")[1]);
	}

}
