package fp.net.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import fp.messageParsers.Message;
import fp.net.ConnectionHandler;
import fp.util.FeedbackProvider;

public class ClientConnectionHandler {
	private ConnectionHandler connectionHandler;
	
	public ClientConnectionHandler() {
		try {
			this.createConnection();
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
			FeedbackProvider.showUnknownHostMessage();
			System.exit(0);
		} 
		catch (IOException e) {
			e.printStackTrace();
			FeedbackProvider.showUnknownHostMessage();
			System.exit(0);
		}
	}

	private void createConnection() throws UnknownHostException, IOException {
		ClientConnectionFileReader connectionFile = new ClientConnectionFileReader();
		Socket socket = new Socket(connectionFile.getServerHost(), connectionFile.getServerPort());
		this.connectionHandler = new ConnectionHandler(socket);
	}

	public Message receive() {
		try {
			return this.connectionHandler.receiveMessage();
		} catch (IOException e) {e.printStackTrace();}
		return null;
	}

	public void sendMessage(Message message) {
		try {
			this.connectionHandler.sendMessage(message);
		} catch (IOException e) {e.printStackTrace();}
	}
}
