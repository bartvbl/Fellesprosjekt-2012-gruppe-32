package fp.messageHandlers.client;

import java.util.ArrayList;

import nu.xom.Element;

import fp.dataObjects.User;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.messageParsers.Message;
import fp.messageParsers.client.ClientMessageHandler;
import fp.net.client.ClientConnectionContext;
import fp.xmlConverters.UserConverter;

public class SearchUserReturnMessageHandler implements ClientMessageHandler{

	private EventDispatcher eventDispatcher;
	private ArrayList<User> users;
	
	public SearchUserReturnMessageHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		users = new ArrayList<User>();
	}
	
	@Override
	public void handleMessage(Message message, ClientConnectionContext context) {
		for (Element e : message.getDataElements()) {
			User user = UserConverter.convertXMLToUser(e);
			this.users.add(user);
			
		}
		eventDispatcher.dispatchEvent(new Event<ArrayList<User>>(EventType.SEARCH_USER_RESULT, users));
		System.out.println("message was returned and handled");
	}

}
