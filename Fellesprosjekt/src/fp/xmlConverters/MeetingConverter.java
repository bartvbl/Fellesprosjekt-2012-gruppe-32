package fp.xmlConverters;

import nu.xom.Element;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.Status;

public class MeetingConverter {
	
	public static Element convertMeetingToXML(Meeting meeting) {
		Element element = new Element("meeting");
		
		Element meetingID = new Element("meetingID");
		meetingID.appendChild(meeting.meetingID + "");
		
		Element description = new Element("description");
		description.appendChild(meeting.description);
		
		Element location = new Element("location");
		location.appendChild(meeting.location);
		
		Element locationType = new Element("locationType");
		locationType.appendChild(meeting.locationType.toString());
		
		Element startTime = new Element("startTime");
		startTime.appendChild(meeting.startTime);
		
		Element endTime = new Element("endTime");
		endTime.appendChild(meeting.endTime);
		
		Element status = new Element("status");
		status.appendChild(meeting.status.toString());
		
		
		element.appendChild(meetingID);
		element.appendChild(description);
		element.appendChild(location);
		element.appendChild(locationType);
		element.appendChild(startTime);
		element.appendChild(endTime);
		return element;
	}
	
	public Meeting toMeeting(String xml) throws java.io.IOException, java.text.ParseException, nu.xom.ParsingException {
		nu.xom.Builder parser = new nu.xom.Builder(false);
		nu.xom.Document doc = parser.build(xml, "");
		return convertXMLToMeeting(doc.getRootElement());
	    }
	
	public static Meeting convertXMLToMeeting(Element meetingElement) {
		String meetingID = null, description = null, location = null, startTime = null, endTime = null, locType = null, stat = null;
		LocationType locationType = null;
		Status status = null;
		
		Element element = meetingElement.getFirstChildElement("meetingID");
		if (element != null) {
			meetingID = element.getValue();
		}
		element = meetingElement.getFirstChildElement("description");
		if (element != null) {
			description = element.getValue();
		}
		element = meetingElement.getFirstChildElement("location");
		if (element != null) {
			location = element.getValue();
		}
		element = meetingElement.getFirstChildElement("startTime");
		if (element != null) {
			startTime = element.getValue();
		}
		element = meetingElement.getFirstChildElement("endTime");
		if (element != null) {
			endTime = element.getValue();
		}
		element = meetingElement.getFirstChildElement("locationType");
		if (element != null) {
			locType = element.getValue();
			if(locType.equals("meetingroom")){
				locationType = LocationType.meetingroom;
			}
			else{
				locationType = LocationType.location;
			}
					
		}
		element = meetingElement.getFirstChildElement("status");
		if (element != null) {
			stat = element.getValue();
			if(stat.equals("active")){
				status = Status.active;
			}
			else{
				status = Status.cancelled;
			}
		}
		return new Meeting(Integer.parseInt(meetingID), description, location, locationType, startTime, endTime, status);
		
	}

}
