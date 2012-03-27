package fp.messageParsers.client;

import java.util.HashMap;

import fp.events.EventDispatcher;
import fp.messageHandlers.client.ListMeetingsResponseMessageHandler;
import fp.messageHandlers.client.SearchMeetingRoomReturnMessageHandler;
import fp.messageHandlers.client.SearchUserReturnMessageHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;

public class ClientMessageParser {
	private static boolean isInitialized = false;
	private static HashMap<MessageType, ClientMessageHandler> messageHandlers = new HashMap<MessageType, ClientMessageHandler>();
	
	public ClientMessageParser(EventDispatcher eventDispatcher) {
		initialize(eventDispatcher);
	}
	
	public static void parseMessage(Message message, ClientConnectionContext connectionContext) {
		System.out.println("parsing message " + message.type);
		ClientMessageHandler handler = messageHandlers.get(message.type);
		if(handler != null) {
			handler.handleMessage(message, connectionContext);
		}
	}

	public static void initialize(EventDispatcher eventDispatcher) {
		if(isInitialized) {return;}
		messageHandlers.put(MessageType.inviteClient, new SaltMessageHandler());
		messageHandlers.put(MessageType.loginRequestRejected, new RejectedMessageHandler());
		messageHandlers.put(MessageType.loginRequestAccepted, new LoginAcceptedHandler());
		messageHandlers.put(MessageType.meetingNotification, new MeetingNotificationHandler(eventDispatcher));
		messageHandlers.put(MessageType.searchMeetingRoom, new SearchMeetingRoomReturnMessageHandler(eventDispatcher));
		messageHandlers.put(MessageType.searchUser, new SearchUserReturnMessageHandler(eventDispatcher));
		messageHandlers.put(MessageType.listMeetingsResponse, new ListMeetingsResponseMessageHandler(eventDispatcher));
	}
}
