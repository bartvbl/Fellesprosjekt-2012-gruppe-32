package fp.xmlConverters;

import java.util.ArrayList;

import fp.messageParsers.Message;
import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Elements;
public class XMLWriter {
	public static String convertMessageIntoXMLElement(Message message) {
		Element xmlMessage = generateXMLTree(message);
		return xmlMessage.toXML();
	}

	private static Element generateXMLTree(Message message) {
		Element rootElement = new Element("callendarMessage");
		Attribute version = new Attribute("version", "0.1");
		rootElement.addAttribute(version);

		Element header = new Element("header");
		Attribute messageType = new Attribute("messageType", message.type.toString());
		header.addAttribute(messageType);

		Element data = new Element("data");
		rootElement.appendChild(header);
		rootElement.appendChild(data);
		
		ArrayList<Element> dataElements = message.getDataElements();
		for(Element dataElement : dataElements) {
			data.appendChild(dataElement);
		}

		return rootElement;
	}
}
