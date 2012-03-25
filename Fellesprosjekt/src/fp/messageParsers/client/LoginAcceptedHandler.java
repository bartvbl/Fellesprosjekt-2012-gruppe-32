package fp.messageParsers.client;

import fp.dataObjects.User;
import fp.messageParsers.Message;
import fp.net.client.ClientConnectionContext;
import fp.views.CalendarApp;
import fp.views.LoginScreen;
import fp.xmlConverters.UserConverter;

public class LoginAcceptedHandler implements ClientMessageHandler {

	public void handleMessage(Message message, ClientConnectionContext context) {
		CalendarApp.getApplication().showMainWindow();
		LoginScreen.close();
		User user = UserConverter.convertXMLToUser(message.getDataElements().get(0));
		context.user = user;
	}

}
