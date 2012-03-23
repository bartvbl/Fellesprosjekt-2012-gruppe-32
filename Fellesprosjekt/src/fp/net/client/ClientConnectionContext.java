package fp.net.client;

public class ClientConnectionContext {
	public final ClientConnectionHandler connectionHandler;
	public String passwordSalt;
	
	public ClientConnectionContext(ClientConnectionHandler connectionHandler) {
		this.connectionHandler = connectionHandler;
	}
}
