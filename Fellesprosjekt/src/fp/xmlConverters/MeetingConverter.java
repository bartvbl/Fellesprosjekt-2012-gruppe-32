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
	
	
//	public static Meeting convertXMLToMeeting(String xml) {
//		
//	}
}
