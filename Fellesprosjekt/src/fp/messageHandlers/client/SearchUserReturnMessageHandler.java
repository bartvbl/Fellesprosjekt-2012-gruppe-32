package fp.messageHandlers.client;

import java.util.ArrayList;

import fp.dataObjects.User;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.messageParsers.Message;
import fp.messageParsers.client.ClientMessageHandler;
import fp.net.client.ClientConnectionContext;

public class SearchUserReturnMessageHandler implements ClientMessageHandler{

	private EventDispatcher eventDispatcher;
	private ArrayList<User> users;
	
	public SearchUserReturnMessageHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}
	
	@Override
	public void handleMessage(Message message, ClientConnectionContext context) {
		
		
		eventDispatcher.dispatchEvent(new Event<ArrayList<User>>(EventType.SEARCH_USER_RESULT, users));

	}

}
