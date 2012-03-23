package fp.net.client;

public class ClientConnector {
	private ClientConnectionContext connectionContext;
	
	public ClientConnector() {
		ClientConnectionHandler connectionHandler = new ClientConnectionHandler();
		this.connectionContext = new ClientConnectionContext(connectionHandler);
	}
}
