package fp.messageParsers.client;

import nu.xom.Element;
import nu.xom.Node;
import fp.messageParsers.Message;
import fp.net.client.ClientConnectionContext;
import fp.views.LoginScreen;

public class SaltMessageHandler implements ClientMessageHandler {
	public void handleMessage(Message message, ClientConnectionContext context) {
		Element data = message.getData();
		Element saltTag = data.getFirstChildElement("PasswordSalt");
		String saltValue = saltTag.getAttributeValue("value");
		context.passwordSalt = saltValue;
		LoginScreen.loginButton.setEnabled(true);
	}

}
