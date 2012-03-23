package fp.server;

import java.util.HashMap;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import fp.dataObjects.User;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.ConnectionHandler;


public class ServerClientContext {
	ConnectionHandler connectionHandler;
	User user;
	HashMap<String, MessageType> getMessageType;
	
	public ServerClientContext(ConnectionHandler connectionHandler, User user){
		this.connectionHandler = connectionHandler;
		this.user = user;
		
		getMessageType.put("getUser", MessageType.getUser);
		getMessageType.put("getMeeting", MessageType.getMeeting);
		getMessageType.put("getMeetingsInWeek", MessageType.getMeetingsInWeek);
		getMessageType.put("addMeeting", MessageType.addMeeting);
		getMessageType.put("addFavourite", MessageType.addFavourite);
		getMessageType.put("updateMeeting", MessageType.updateMeeting);
		getMessageType.put("removeMeeting", MessageType.removeMeeting);
	}
	
	public void revieceXMLMessage(){
		
		
	}
	
	public void revieceReturnMessage(){
		
	}
	
	public Message convertXMLMessageIntoMessage(String XMLMessage){
		Document doc = null;
		try {
			Builder parser = new Builder(false);
			doc = parser.build(XMLMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element root = null;
		if (doc != null){			
			root = doc.getRootElement();
		}
		Element header = root.getFirstChildElement("header");
		Attribute messageType = header.getAttribute("messageType");
		
		Element data = root.getFirstChildElement("data");
		
		Message message = new Message(getMessageType.get(messageType.getValue()), data);
		
		return message;
	}

}
