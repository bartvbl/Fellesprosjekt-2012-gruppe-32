package fp.xmlConverters;

import java.sql.SQLException;

import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.messageParsers.Message;
import fp.messageParsers.MessageParser;
import fp.server.ServerClientContext;
import nu.xom.Attribute;
import nu.xom.Element;

public class XMLWriter {

	

	// message til string

	public static Element convertReturnMessageIntoXMLElement(Element databaseResult) {
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
}
