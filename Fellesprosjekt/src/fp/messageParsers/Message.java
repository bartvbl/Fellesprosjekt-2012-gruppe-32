package fp.messageParsers;

import nu.xom.Element;

public class Message {
	public final MessageType type;
	private Element data;
	
	public Message(MessageType type, Element data){
		this.type = type;
		this.data = data;
	}
	
	public Element getData() {
		return data;
	}
}
