package fp.messageParsers.client;

import java.util.HashMap;

import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;

public class ClientMessageParser {
	private static boolean isInitialized = false;
	private static HashMap<MessageType, ClientMessageHandler> messageHandlers = new HashMap<MessageType, ClientMessageHandler>();
	
	public ClientMessageParser() {
		initialize();
	}
	
	public static void parseMessage(Message message, ClientConnectionContext connectionContext) {
		System.out.println("parsing message " + message.type);
		ClientMessageHandler handler = messageHandlers.get(message.type);
		if(handler != null) {
			handler.handleMessage(message, connectionContext);
		}
	}

	public static void initialize() {
		if(isInitialized) {return;}
		messageHandlers.put(MessageType.inviteClient, new SaltMessageHandler());
		messageHandlers.put(MessageType.loginRequestRejected, new RejectedMessageHandler());
		messageHandlers.put(MessageType.loginRequestAccepted, new LoginAcceptedHandler());
	}
}
