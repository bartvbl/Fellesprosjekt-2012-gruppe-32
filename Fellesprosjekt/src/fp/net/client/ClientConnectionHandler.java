package fp.net.client;

import fp.net.ConnectionHandler;

public class ClientConnectionHandler {
	private ConnectionHandler connectionHandler;
	
	public ClientConnectionHandler() {
		this.connectionHandler = ClientConnectionCreator.createConnection();
	}
}
