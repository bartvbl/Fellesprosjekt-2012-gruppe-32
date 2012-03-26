package fp.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import fp.messageParsers.Message;
import fp.messageParsers.server.MessageParser;
import fp.xmlConverters.XMLReader;
import fp.xmlConverters.XMLWriter;

public class ConnectionHandler {
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private Socket socket;
	
	public ConnectionHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.bufferedWriter = new BufferedWriter(new PrintWriter(socket.getOutputStream()));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public Message receiveMessage() throws IOException{
		if (bufferedReader.ready()){
			String inputLine = this.bufferedReader.readLine();
			Message parsedMessage = this.convertMessageStringToMessage(inputLine);
			return parsedMessage;
		}
		return null;
	}
	
	public void sendMessage(Message message){
		String convertedMessage = XMLWriter.convertMessageIntoXMLElement(message);
		try {
			this.bufferedWriter.write(convertedMessage);
			this.bufferedWriter.newLine();
			this.bufferedWriter.flush();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void closeConnection() throws IOException {
		this.socket.close();
	}
	
	private Message convertMessageStringToMessage(String messageString){
		return XMLReader.convertXMLMessageIntoMessage(messageString);
	}
}
