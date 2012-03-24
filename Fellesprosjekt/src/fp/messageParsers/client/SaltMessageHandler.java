package fp.messageParsers.client;

import java.util.ArrayList;

import nu.xom.Element;
import nu.xom.Node;
import fp.messageParsers.Message;
import fp.net.client.ClientConnectionContext;
import fp.views.LoginScreen;

public class SaltMessageHandler implements ClientMessageHandler {
	public void handleMessage(Message message, ClientConnectionContext context) {
		ArrayList<Element> data = message.getDataElements();
		Element saltTag = data.get(0).getFirstChildElement("PasswordSalt");
		String saltValue = saltTag.getAttributeValue("value");
		context.passwordSalt = saltValue;
		LoginScreen.loginButton.setEnabled(true);
	}

}
