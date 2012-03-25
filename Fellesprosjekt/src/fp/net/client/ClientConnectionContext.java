package fp.net.client;

import fp.dataObjects.User;
import fp.events.EventDispatcher;

public class ClientConnectionContext {
	public final ClientConnectionHandler connectionHandler;
	public final EventDispatcher eventDispatcher;
	public String passwordSalt = null;
	private static ClientConnectionContext context = null;
	public User user;
	
	public ClientConnectionContext(ClientConnectionHandler connectionHandler, EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.connectionHandler = connectionHandler;
		context = this;
	}
	
	public static ClientConnectionContext getInstance() {
		return context;
	}
}
