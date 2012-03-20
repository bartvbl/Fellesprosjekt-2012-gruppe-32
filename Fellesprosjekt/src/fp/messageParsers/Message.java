package fp.messageParsers;

import fp.database.DatabaseConnection;
import nu.xom.Element;

public class Message {
	
	
	public static void main(String[] args) {
		DatabaseConnection.connect();
		System.out.println("koblet til");
	}
	
	
	MessageType type;
	Element data;
	
	public Message(MessageType type, Element data){
		this.type = type;
		this.data = data;
	}
	
}
