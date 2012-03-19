package fp.xmlConverters;

import nu.xom.Element;
import fp.dataObjects.MeetingRoom;
import fp.dataObjects.User;

public class MeetingRoomConverter {
	
	public static Element convertUserToXML(MeetingRoom meetingRoom) {
		Element element = new Element("meetingRoom");

		Element roomID = new Element("roomID");
		roomID.appendChild(meetingRoom.roomID + "");
		
		Element roomSize = new Element("roomSize");
		roomSize.appendChild(meetingRoom.roomSize + "");

		element.appendChild(roomID);
		element.appendChild(roomSize);
		
		return element;
	}
	
	public MeetingRoom toMeetingRoom(String xml) throws java.io.IOException, java.text.ParseException, nu.xom.ParsingException {
		nu.xom.Builder parser = new nu.xom.Builder(false);
		nu.xom.Document doc = parser.build(xml, "");
		return convertXMLToMeetingRoom(doc.getRootElement());
	    }
	
	public static MeetingRoom convertXMLToMeetingRoom(Element userElement) {
		String roomID = null, roomSize = null;
		Element element = userElement.getFirstChildElement("roomID");
		if (element != null) {
			roomID = element.getValue();
		}
		element = userElement.getFirstChildElement("roomSize");
		if (element != null) {
			roomSize = element.getValue();
		}
		
		return new MeetingRoom(Integer.parseInt(roomID), Integer.parseInt(roomSize));
		
	}
}
