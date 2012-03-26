package fp.server.events;

import java.util.ArrayList;
import java.util.HashMap;

import fp.events.EventType;
import fp.events.ServerEvent;
import fp.events.ServerEventHandler;
import fp.server.ServerClientContext;

public class EventParser {
	private static HashMap<EventType, ServerEventHandler> eventHandlerMap = new HashMap<EventType, ServerEventHandler>();
	
	public EventParser() {
		this.eventHandlerMap.put(EventType.SERVER_MEETING_REGISTERED, new NewMeetingNotificationEventHandler());
	}
	
	public static void parseEvents(ArrayList<ServerEvent<?>> eventList, ServerClientContext context) {
		for(ServerEvent<?> event : eventList) {
			
		}
	}

}
