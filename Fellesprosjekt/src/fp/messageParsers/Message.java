package fp.messageParsers;

import fp.database.DatabaseConnection;
import nu.xom.Element;

public class Message {
	
	
	MessageType type;
	Element data;
	
	public Message(MessageType type, Element data){
		this.type = type;
		this.data = data;
	}
	
}
