package fp.messageParsers;

import nu.xom.Element;

public class Message {
	
	MessageType type;
	Element data;
	
	public Message(MessageType type, Element data){
		this.type = type;
		this.data = data;
	}
	
}
