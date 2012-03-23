package fp.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import fp.messageParsers.Message;
import fp.messageParsers.MessageParser;
import fp.xmlConverters.XMLReader;

public class ConnectionHandler {
	// Denne klassen må ha en XML-reader som konverterer meldingsstreng til et messageObject
	
	
	private Socket socket;
	private BufferedReader bufferedReader;
	
	// gir en string tilbake fra no.fp.net (kjernekode) 
	
	public ConnectionHandler(Socket socket) {
		this.socket = socket;
		try {
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Message revieceMessage(String message) throws IOException{
		if (bufferedReader.ready()){
			Message parsedMessage = XMLReader.convertXMLMessageIntoMessage(bufferedReader.readLine());
			return parsedMessage;
		}
		
		return null;
	}
	
	public void sendMessage(){
		
	}
	
	public void convertMessageStringToMessage(String messageString){
		Message message = XMLReader.convertXMLMessageIntoMessage(messageString);
		
		
	}


	
}
