package fp.databaseReaders;

import java.sql.ResultSet;
import java.sql.SQLException;

import fp.dataObjects.Notification;
import fp.dataObjects.Notification.NotificationStatus;
import fp.dataObjects.Notification.NotificationType;

public class NotificationReader {
	public static Notification readNotificationLine(ResultSet result) throws SQLException {
		NotificationStatus status = Enum.valueOf(NotificationStatus.class, result.getString("AcceptedMeeting"));
		NotificationType type = Enum.valueOf(NotificationType.class, result.getString("NotificationType"));
		Notification notification = new Notification(result.getInt("UserID"), result.getInt("MeetingID"), status, type);
		return notification;
	}
}
