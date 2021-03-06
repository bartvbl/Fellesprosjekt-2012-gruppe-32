package fp.messageParsers.client;

import java.sql.ResultSet;
import java.sql.SQLException;

import nu.xom.Element;

import fp.dataObjects.Notification;
import fp.dataObjects.Notification.NotificationStatus;
import fp.dataObjects.Notification.NotificationType;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.databaseReaders.NotificationReader;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;
import fp.views.CalendarApp;
import fp.views.LoginScreen;
import fp.xmlConverters.NotificationConverter;
import fp.xmlConverters.UserConverter;

public class LoginAcceptedHandler implements ClientMessageHandler {

	public void handleMessage(Message message, ClientConnectionContext context) {
		CalendarApp.getApplication().showMainWindow();
		LoginScreen.close();
		User user = UserConverter.convertXMLToUser(message.getDataElements().get(0));
		context.user = user;
	}

}
