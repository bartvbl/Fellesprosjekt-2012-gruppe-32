package fp.components.loginScreen;

import nu.xom.Attribute;
import nu.xom.Element;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnector;
import fp.util.StringHasher;

public class LoginRequestSender {
	public static void sendLoginRequest(String userName, String password, String salt) {
		String hashedPassword = StringHasher.hashPassword(StringHasher.hashPassword(password, ""), salt);
		Message message = buildMessage(userName, hashedPassword);
		ClientConnector.sendMessage(message);
	}
	
	private static Message buildMessage(String userName, String hashedPassword) {
		Message message = new Message(MessageType.loginRequest);
		
		Element userNameElement = new Element("userName");
		userNameElement.addAttribute(new Attribute("value", userName));
		message.addDataElement(userNameElement);
		
		Element passwordElement = new Element("password");
		passwordElement.addAttribute(new Attribute("value", hashedPassword));
		message.addDataElement(passwordElement);
		return message;
	}
}
