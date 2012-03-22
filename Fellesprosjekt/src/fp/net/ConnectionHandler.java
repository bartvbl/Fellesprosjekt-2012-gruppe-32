package fp.net;

import java.net.Socket;

import fp.dataObjects.ServerUserData;
import fp.messageParsers.Message;

public class ConnectionHandler {
	// Denne klassen må ha en XML-reader som konverterer meldingsstreng til et messageObject

	
	private Socket socket;

	// gir en string tilbake fra no.fp.net (kjernekode) 
	
	public ConnectionHandler(Socket socket) {
		this.socket = socket;
				
	}

	public Message pollConnection(){
		this.socket.
		
		
	}
	
}
