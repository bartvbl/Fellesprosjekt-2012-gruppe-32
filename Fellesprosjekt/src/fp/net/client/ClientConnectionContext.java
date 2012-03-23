package fp.net.client;

import fp.events.EventDispatcher;

public class ClientConnectionContext {
	public final ClientConnectionHandler connectionHandler;
	public final EventDispatcher eventDispatcher;
	public String passwordSalt;
	
	public ClientConnectionContext(ClientConnectionHandler connectionHandler, EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.connectionHandler = connectionHandler;
	}
}
