package fp.messageParsers;

import java.sql.SQLException;
import java.util.HashMap;

import fp.dataObjects.ServerUserData;
import fp.messageHandlers.AddFavouriteHandler;
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
		typeForHandlerMap.put(MessageType.addFavourite, new AddFavouriteHandler());
		
	}
	
	public static void parseMessage(Message message, ServerUserData userData) throws SQLException{
		typeForHandlerMap.get(message.type).handleMessage(message, userData);
	}
	
	

}
