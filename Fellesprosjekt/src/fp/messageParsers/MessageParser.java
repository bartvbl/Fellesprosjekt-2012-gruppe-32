package fp.messageParsers;

import java.sql.SQLException;
import java.util.HashMap;

import fp.messageHandlers.AddFavouriteMeetingHandler;
import fp.messageHandlers.AddMeetingHandler;
import fp.messageHandlers.GetMeetingHandler;
import fp.messageHandlers.GetUserHandler;
import fp.messageHandlers.MessageHandler;
import fp.messageHandlers.UpdateMeetingHandler;

public class MessageParser {
	
	private static HashMap<MessageType, MessageHandler> typeForHandlerMap = new HashMap<MessageType, MessageHandler>();
	
	
	public MessageParser(){
		typeForHandlerMap.put(MessageType.addMeeting, new AddMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.updateMeeting, new UpdateMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getUser, new GetUserHandler());
		typeForHandlerMap.put(MessageType.addFavourite, new AddFavouriteMeetingHandler());
		
	}
	
	public static void parseMessage(Message message) throws SQLException{
		typeForHandlerMap.get(message.type).handleMessage(message);
	}
	
	

}
