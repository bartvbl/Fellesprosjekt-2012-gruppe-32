package fp.messageParsers;

import java.util.HashMap;

import fp.messageHandlers.GetMeetingHandler;
import fp.messageHandlers.MessageHandler;

public class MessageParser {
	
	private static HashMap<MessageType, MessageHandler> typeForHandlerMap = new HashMap<MessageType, MessageHandler>();
	
	public MessageParser(){
		typeForHandlerMap.put(MessageType.addMeeting, new AddMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		
	}
	
	public static void parseMessage(Message message){

		
		
	}
	
	

}
