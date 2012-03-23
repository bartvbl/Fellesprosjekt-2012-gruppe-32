package fp.packetBuilders;

import nu.xom.Attribute;
import nu.xom.Element;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;

public class InitialHandshakePacketBuilder {
	public static Message generateInviteMessage(String passwordSalt) {
		Element element = new Element("PasswordSalt");
		element.addAttribute(new Attribute("value", passwordSalt));
		return new Message(MessageType.inviteClient, element);
	}
}
