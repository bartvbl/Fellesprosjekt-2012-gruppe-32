package fp.server;

import fp.dataObjects.User;
import fp.net.ConnectionHandler;


public class ServerClientContext {
	public final ConnectionHandler connectionHandler;
	public User user = null;
	private boolean isLoggedIn;
	
	public ServerClientContext(ConnectionHandler connectionHandler){
		this.connectionHandler = connectionHandler;
	}
	
	public boolean isLoggedIn() {
		return this.isLoggedIn;
	}
	
	public void markAsLoggedIn() {
		this.isLoggedIn = true;
	}
}
