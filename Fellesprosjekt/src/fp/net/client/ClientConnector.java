package fp.net.client;

import fp.events.EventDispatcher;
import fp.messageParsers.Message;
import fp.messageParsers.client.ClientMessageParser;

public class ClientConnector {
	private ClientConnectionContext connectionContext;
	private EventDispatcher eventDispatcher;
	
	public ClientConnector(EventDispatcher eventDispatcher) {
		ClientConnectionHandler connectionHandler = new ClientConnectionHandler();
		this.connectionContext = new ClientConnectionContext(connectionHandler, eventDispatcher);
	}

	public void receive() {
		Message message = this.connectionContext.connectionHandler.receive();
		if(message != null) {
			ClientMessageParser.parseMessage(message, connectionContext);
		}
	}
}
