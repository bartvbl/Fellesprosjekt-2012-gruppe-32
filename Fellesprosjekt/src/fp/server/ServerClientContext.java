package fp.server;

import java.sql.SQLException;
import java.util.HashMap;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.messageParsers.Message;
import fp.messageParsers.MessageParser;
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
	
	public void revieceXMLMessage(String m) throws SQLException{
		Message message = convertXMLMessageIntoMessage(m);
		MessageParser.parseMessage(message, new ServerUserData(this.user));
	}
	
	public void recieveReturnMessage(Element returnData){
		Element returnElement = convertReturnMessageIntoXMLElement(returnData);
		
	}
	
	public Element convertReturnMessageIntoXMLElement(Element databaseResult){
		Element rootElement = new Element("callendarMessage");
		Attribute version = new Attribute("version", "0.1");
		rootElement.addAttribute(version);
		
		Element header = new Element("header");
		Attribute messageType = new Attribute("messageType", "returnMessage");
		header.addAttribute(messageType);
		
		Element data = new Element("data");
		data.appendChild(databaseResult);
		rootElement.appendChild(header);
		rootElement.appendChild(data);
		
		return rootElement;
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
