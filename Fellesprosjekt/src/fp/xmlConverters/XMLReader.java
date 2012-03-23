package fp.xmlConverters;

import java.util.HashMap;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import fp.dataObjects.User;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.ConnectionHandler;

public class XMLReader {


private static HashMap<String, MessageType> getMessageType = new HashMap<String, MessageType>();;
	
	public static void initiateGetMessageType(){
		getMessageType.put("getUser", MessageType.getUser);
		getMessageType.put("getMeeting", MessageType.getMeeting);
		getMessageType.put("getMeetingsInWeek", MessageType.getMeetingsInWeek);
		getMessageType.put("addMeeting", MessageType.addMeeting);
		getMessageType.put("addFavourite", MessageType.addFavourite);
		getMessageType.put("updateMeeting", MessageType.updateMeeting);
		getMessageType.put("removeMeeting", MessageType.removeMeeting);
	}

	public static Message convertXMLMessageIntoMessage(String XMLMessage) {
		if (getMessageType.size() == 0){
			initiateGetMessageType();
		}
		Document doc = null;
		try {
			Builder parser = new Builder(false);
			doc = parser.build(XMLMessage, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element root = null;
		if (doc != null) {
			root = doc.getRootElement();
		}
		Element header = root.getFirstChildElement("header");
		Attribute messageType = header.getAttribute("messageType");

		Element data = root.getFirstChildElement("data");

		Message message = new Message(
				getMessageType.get(messageType.getValue()), data);

		return message;
	}
}
