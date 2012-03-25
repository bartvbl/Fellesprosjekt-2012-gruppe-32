package fp.messageParsers.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nu.xom.Element;

import fp.dataObjects.Notification;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.databaseReaders.NotificationReader;
import fp.messageHandlers.MessageHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;
import fp.packetBuilders.InitialHandshakePacketBuilder;
import fp.server.ServerClientContext;
import fp.util.StringHasher;
import fp.xmlConverters.NotificationConverter;

public class UserLoginHandler implements MessageHandler {

	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		ArrayList<Element> dataElements = message.getDataElements();
		String userName = dataElements.get(0).getAttributeValue("value");
		String password = dataElements.get(1).getAttributeValue("value");
		
		ResultSet set = DatabaseConnection.executeReadQuery("SELECT * FROM User WHERE UserName='"+userName+"'");
		
		try {set.next();}
		catch(SQLException e) {return;}
		
		System.out.println("used salt: " + clientContext.passwordSalt);
		String correctPasswordHash = StringHasher.hashPassword(set.getString("Password"), clientContext.passwordSalt);
		User user = new User(set.getInt("UserID"), set.getString("UserName"), null, set.getString("FirstName"), set.getString("LastName"), set.getString("Email"), set.getString("PhoneNumber"));
		System.out.println("user password: " + correctPasswordHash);
		System.out.println("entered password: " + password);
		
		if(correctPasswordHash.equals(password)) {
			clientContext.user = user;
			Message replymessage = InitialHandshakePacketBuilder.generateLoggedInMessage(user);
			clientContext.connectionHandler.sendMessage(replymessage);
			this.sendPendingNotifications(clientContext);
		} else {
			Message replymessage = InitialHandshakePacketBuilder.generateInvalidLoginMessage();
			clientContext.connectionHandler.sendMessage(replymessage);
		}	
	}

	private void sendPendingNotifications(ServerClientContext context) {
		try {
			Message returnMessage = new Message(MessageType.meetingNotification);
			ResultSet result = DatabaseConnection.executeReadQuery("SELECT * FROM Notifications WHERE UserID="+context.user.userID+" AND AcceptedMeeting=NULL");
			while(result.next()) {
				Notification notification = NotificationReader.readNotificationLine(result);
				Element dataElement = NotificationConverter.convertNotificationToXML(notification);
				returnMessage.addDataElement(dataElement);
			}
			context.connectionHandler.sendMessage(returnMessage);
		} catch (SQLException e) {/*this exception is also thrown if no results were found*/}
	}
}
