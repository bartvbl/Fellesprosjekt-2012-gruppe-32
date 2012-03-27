package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Notification;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.NotificationConverter;

public class NotificationResponseHandler implements MessageHandler {

	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		Notification updatedNotification = NotificationConverter.convertXMLToNotification(message.getDataElements().get(0));
		DatabaseConnection.executeWriteQuery("UPDATE Notifications SET AcceptedMeeting='"+updatedNotification.notificationStatus+"' " +
															"WHERE UserID="+updatedNotification.userID+" " +
															"AND MeetingID="+updatedNotification.meetingID+" " +
															"AND NotificationType='"+updatedNotification.notificationType+"'");
		System.out.println("notification status updated to: " + updatedNotification.notificationStatus);
	}

}
