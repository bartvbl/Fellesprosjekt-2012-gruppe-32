package fp.xmlConverters;

import nu.xom.Element;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.Status;

public class MeetingConverter {

	/*
	public static void main (String[] args){
		
		Meeting mote = new Meeting(12,"haha", "her", LocationType.meetingroom, "12:00", "13:00", Status.active, 123, 321, MeetingType.meeting );
		
		System.out.println(mote);
		Element el1 = convertMeetingToXML(mote);
		System.out.println(el1);
		
		System.out.println(mote.meetingID + " asdasd " + mote.creatorID + " asdasd " + mote.roomID);
		System.out.println(el1.toXML());
		
		
		Meeting mote2 = convertXMLToMeeting(el1);
		System.out.println(mote2);
		
		
	}
	*/
	
	
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
		
		Element creatorID = new Element("creatorID");
		creatorID.appendChild(meeting.creatorID + "");
		
		Element roomID = new Element("roomID");
		roomID.appendChild(meeting.roomID + "");
		
		Element meetingType = new Element("meetingType");
		meetingType.appendChild(meeting.meetingType.toString());
		
		
		element.appendChild(meetingID);
		element.appendChild(description);
		element.appendChild(status);
		element.appendChild(location);
		element.appendChild(locationType);
		element.appendChild(roomID);
		element.appendChild(startTime);
		element.appendChild(endTime);
		element.appendChild(creatorID);
		element.appendChild(meetingType);
		
		return element;
	}
	
	public Meeting toMeeting(String xml) throws java.io.IOException, java.text.ParseException, nu.xom.ParsingException {
		nu.xom.Builder parser = new nu.xom.Builder(false);
		nu.xom.Document doc = parser.build(xml, "");
		return convertXMLToMeeting(doc.getRootElement());
	    }
	
	public static Meeting convertXMLToMeeting(Element meetingElement) {
		String meetingID = null, description = null, location = null, startTime = null, endTime = null, locType = null, meetType = null, stat = null, creatorID = null, roomID = null;
		LocationType locationType = null;
		Status status = null;
		MeetingType meetingType = null;
		
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
		
		
		element = meetingElement.getFirstChildElement("creatorID");
		if (element != null) {
			creatorID = element.getValue();
		}
		element = meetingElement.getFirstChildElement("roomID");
		if (element != null) {
			roomID = element.getValue();
		}
		element = meetingElement.getFirstChildElement("meetingType");
		if (element != null) {
			meetType = element.getValue();
			if(meetType.equals("meeting")){
				meetingType = MeetingType.meeting;
			}
			else{
				meetingType = MeetingType.appointment;
			}
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
		return new Meeting(Integer.parseInt(meetingID), description, location, locationType, startTime, endTime, status, Integer.parseInt(creatorID), Integer.parseInt(roomID), meetingType);
		
	}

}
