package fp.messageParsers;

import java.util.ArrayList;

import nu.xom.Element;
import nu.xom.Elements;

public class Message {
	public final MessageType type;
	private ArrayList<Element> elementsList = new ArrayList<Element>();
	
	public Message(MessageType type){
		this.type = type;
	}
	
	public void addDataElement(Element element) {
		this.elementsList.add(element);
	}
	
	public ArrayList<Element> getDataElements() {
		return elementsList;
	}
	
	public String toString() {
		return "Message of type " + type;
	}
}
