package fp.messageParsers.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nu.xom.Element;

import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingStatus;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import fp.dataObjects.Notification.NotificationStatus;
import fp.dataObjects.Notification.NotificationType;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.databaseReaders.MeetingReader;
import fp.databaseReaders.NotificationReader;
import fp.databaseReaders.UserReader;
import fp.messageHandlers.MessageHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;
import fp.packetBuilders.InitialHandshakePacketBuilder;
import fp.server.ServerClientContext;
import fp.util.StringHasher;
import fp.xmlConverters.MeetingNotificationConverter;
import fp.xmlConverters.NotificationConverter;

public class UserLoginHandler implements MessageHandler {

	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		ArrayList<Element> dataElements = message.getDataElements();
		String userName = dataElements.get(0).getAttributeValue("value");
		String password = dataElements.get(1).getAttributeValue("value");
		
		ResultSet set = DatabaseConnection.executeReadQuery("SELECT * FROM User WHERE UserName='"+userName+"'");
		String correctPasswordHash = "";
		User user = null;
		try {
			set.next();
			correctPasswordHash = StringHasher.hashPassword(set.getString("Password"), clientContext.passwordSalt);
			user = UserReader.readUserFromResultSet(set);
		}
		catch(SQLException e) {
			this.sendInvalidLoginMessage(clientContext);
			return;
		}
		
		if(correctPasswordHash.equals(password)) {
			clientContext.user = user;
			Message replymessage = InitialHandshakePacketBuilder.generateLoggedInMessage(user);
			clientContext.connectionHandler.sendMessage(replymessage);
			this.sendPendingNotifications(clientContext);
		} else {
			this.sendInvalidLoginMessage(clientContext);
		}	
	}
	
	private void sendInvalidLoginMessage(ServerClientContext clientContext) {
		Message replymessage = InitialHandshakePacketBuilder.generateInvalidLoginMessage();
		clientContext.connectionHandler.sendMessage(replymessage);
	}

	private void sendPendingNotifications(ServerClientContext context) {
		Message returnMessage = new Message(MessageType.meetingNotification);
		try {
			ResultSet result = DatabaseConnection.executeReadQuery("SELECT * FROM Notifications WHERE UserID="+context.user.userID+" AND AcceptedMeeting=NULL");
			while(result.next()) {
				Notification notification = NotificationReader.readNotificationLine(result);
				Meeting meeting = this.getMeetingByID(notification.meetingID);
				MeetingNotification meetingNotification = new MeetingNotification(meeting, notification);
				returnMessage.addDataElement(MeetingNotificationConverter.convertMeetingotificationToXML(meetingNotification));
			}
			
		} catch (SQLException e) {
			//will be thrown if there are no notifications for the client -> the message is still sent so the client can reflect this in the UI
		}
		context.connectionHandler.sendMessage(returnMessage);
	}
	
	private Meeting getMeetingByID(int meetingID) throws SQLException {
		ResultSet result = DatabaseConnection.executeReadQuery("SELECT * FROM Meeting WHERE MeetingID="+meetingID);
		result.next();
		return MeetingReader.readMeetingFromResultSet(result);
	}
}
