package fp.packetBuilders;

import nu.xom.Attribute;
import nu.xom.Element;
import fp.dataObjects.User;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.xmlConverters.UserConverter;

public class InitialHandshakePacketBuilder {
	public static Message generateInviteMessage(String passwordSalt) {
		Element element = new Element("PasswordSalt");
		element.addAttribute(new Attribute("value", passwordSalt));
		
		Message message = new Message(MessageType.inviteClient);
		message.addDataElement(element);
		return message;
	}

	public static Message generateLoggedInMessage(User user) {
		Element element = UserConverter.convertUserToXML(user);
		Message message = new Message(MessageType.loginRequestAccepted);
		message.addDataElement(element);
		return message;
	}

	public static Message generateInvalidLoginMessage() {
		Message message = new Message(MessageType.loginRequestRejected);
		return message;
	}
}
