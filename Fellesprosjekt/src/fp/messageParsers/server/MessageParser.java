package fp.messageParsers.server;

import java.sql.SQLException;
import java.util.HashMap;

import fp.events.ConcurrentEventDispatcher;
import fp.messageHandlers.AddFavouriteMeetingHandler;
import fp.messageHandlers.AddMeetingHandler;
import fp.messageHandlers.GetMeetingHandler;
import fp.messageHandlers.GetMeetingsInWeekHandler;
import fp.messageHandlers.GetUserHandler;
import fp.messageHandlers.MeetingListRequestHandler;
import fp.messageHandlers.MessageHandler;
import fp.messageHandlers.NotificationResponseHandler;
import fp.messageHandlers.SearchMeetingRoomHandler;
import fp.messageHandlers.SearchUserHandler;
import fp.messageHandlers.UpdateMeetingHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;

public class MessageParser {
	
	private static HashMap<MessageType, MessageHandler> typeForHandlerMap = new HashMap<MessageType, MessageHandler>();
	
	public MessageParser(ConcurrentEventDispatcher eventDispatcher) {
		if (typeForHandlerMap.size() == 0){
			initiate(eventDispatcher);
		}
	}
	
	public static void initiate(ConcurrentEventDispatcher eventDispatcher){
		typeForHandlerMap.put(MessageType.addMeeting, new AddMeetingHandler(eventDispatcher));
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.updateMeeting, new UpdateMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeeting, new GetMeetingHandler());
		typeForHandlerMap.put(MessageType.getMeetingsInWeek, new GetMeetingsInWeekHandler());
		typeForHandlerMap.put(MessageType.getUser, new GetUserHandler());
		typeForHandlerMap.put(MessageType.addFavourite, new AddFavouriteMeetingHandler());
		typeForHandlerMap.put(MessageType.loginRequest, new UserLoginHandler());
		typeForHandlerMap.put(MessageType.registerNotificationResponse, new NotificationResponseHandler());
		typeForHandlerMap.put(MessageType.searchMeetingRoom, new SearchMeetingRoomHandler());
		typeForHandlerMap.put(MessageType.searchUser, new SearchUserHandler());
		typeForHandlerMap.put(MessageType.listMeetingsRequest, new MeetingListRequestHandler());
	}
	
	public static void parseMessage(Message message, ServerClientContext clientContext) throws SQLException{
		MessageHandler handler = typeForHandlerMap.get(message.type);
		if(handler != null) {
			handler.handleMessage(message, clientContext);
		}
	}

}
