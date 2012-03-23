package fp.messageParsers.server;

import java.sql.SQLException;
import java.util.HashMap;

import fp.dataObjects.ServerUserData;
import fp.messageHandlers.AddFavouriteMeetingHandler;

import fp.messageHandlers.AddMeetingHandler;
import fp.messageHandlers.GetMeetingHandler;
import fp.messageHandlers.GetMeetingsInWeekHandler;
import fp.messageHandlers.GetUserHandler;
import fp.messageHandlers.MessageHandler;
import fp.messageHandlers.UpdateMeetingHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;

public class MessageParser {
	
	private static HashMap<MessageType, MessageHandler> typeForHandlerMap = new HashMap<MessageType, MessageHandler>();
	
	
	public static void initiate(){
		typeForHandlerMap.put(MessageType.addMeeting, new AddMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.updateMeeting, new UpdateMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeetingsInWeek, new GetMeetingsInWeekHandler());
		typeForHandlerMap.put(MessageType.getUser, new GetUserHandler());
		typeForHandlerMap.put(MessageType.addFavourite, new AddFavouriteMeetingHandler());
		
	}
	
	public static void parseMessage(Message message, ServerClientContext clientContext) throws SQLException{
		if (typeForHandlerMap.size() == 0){
			initiate();
		}
		System.out.println(message.type);
		typeForHandlerMap.get(message.type).handleMessage(message, clientContext);
	}

}
