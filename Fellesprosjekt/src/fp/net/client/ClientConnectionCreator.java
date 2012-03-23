package fp.net.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import fp.net.ConnectionHandler;
import fp.util.FeedbackProvider;
import fp.views.CalendarView;

public class ClientConnectionCreator {
	private ConnectionHandler connectionHandler;

	public static ConnectionHandler createConnection() {
		try {
			Socket socket = establishConnection();
			return new ConnectionHandler(socket);
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
			FeedbackProvider.showConnectionFailedMessage("The server's host was not found.");
		} 
		catch (IOException e) {
			e.printStackTrace();
			FeedbackProvider.showConnectionFailedMessage(e.getMessage());
		}
		return null;
	}
	
	private static Socket establishConnection() throws UnknownHostException, IOException {
		ClientConnectionFileReader connectionFile = new ClientConnectionFileReader();
		Socket socket = new Socket(connectionFile.getServerHost(), connectionFile.getServerPort());
		return socket;
	}
}
