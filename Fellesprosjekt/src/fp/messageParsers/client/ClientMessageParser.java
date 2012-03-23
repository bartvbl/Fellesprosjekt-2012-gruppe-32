package fp.messageParsers.client;

import java.util.HashMap;

import fp.messageHandlers.MessageHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;

public class ClientMessageParser {

	private static HashMap<MessageType, ClientMessageHandler> messageHandlers = new HashMap<MessageType, ClientMessageHandler>();
	
	public static void parseMessage(Message message, ClientConnectionContext connectionContext) {
		
	}

}
