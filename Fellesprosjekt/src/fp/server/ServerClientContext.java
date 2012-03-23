package fp.server;

import fp.dataObjects.User;
import fp.net.ConnectionHandler;


public class ServerClientContext {
	public final ConnectionHandler connectionHandler;
	public User user = null;
	
	public ServerClientContext(ConnectionHandler connectionHandler){
		this.connectionHandler = connectionHandler;
	}
}
