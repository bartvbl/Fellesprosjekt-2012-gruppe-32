package fp.messageParsers;

import nu.xom.Element;

public class Message {
	//hahahahahah
	
	private MessageType type;
	private Element data;
	
	public Message(MessageType type, Element data){
		this.type = type;
		this.data = data;
	}

	public MessageType getType() {
		return type;
	}

	public Element getData() {
		return data;
	}
	
	
}
