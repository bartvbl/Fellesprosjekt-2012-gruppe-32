package fp.xmlConverters;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;

public class XMLReader {
	public static Message convertXMLMessageIntoMessage(String XMLMessage) {
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

		Message message = new Message(Enum.valueOf(MessageType.class, messageType.getValue()));

		Elements dataElements = data.getChildElements();
		for(int i = 0; i < dataElements.size(); i++) {
			message.addDataElement(dataElements.get(i));
		}

		return message;
	}
}
