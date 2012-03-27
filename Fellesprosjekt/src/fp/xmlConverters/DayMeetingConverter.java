package fp.xmlConverters;

import fp.dataObjects.CalendarDate;
import fp.dataObjects.DayMeetingList;
import fp.dataObjects.Meeting;
import nu.xom.Element;
import nu.xom.Elements;

public class DayMeetingConverter {
	public static Element convertDayMeetingToXML(DayMeetingList dayMeeting) {
		Element dayMeetingListElement = new Element("dayMeeting");
		
		Element dateElement = CalendarDateConverter.convertCalendarDateToXML(dayMeeting.date);
		dayMeetingListElement.appendChild(dateElement);
		
		Element meetingListElement = new Element("meetings");
		dayMeetingListElement.appendChild(meetingListElement);
		
		for(int i = 0; i < dayMeeting.getNumberOfMeetings(); i++) {
			Element meetingElement = MeetingConverter.convertMeetingToXML(dayMeeting.getMeeting(i));
			meetingListElement.appendChild(meetingElement);
		}
		
		return dayMeetingListElement;
	}
	
	public static DayMeetingList convertXMLToDayMeeting(Element dataElement) {
		CalendarDate date = CalendarDateConverter.convertXMLToCalendarDate(dataElement.getChildElements().get(0));
		DayMeetingList meetingList = new DayMeetingList(date);
		Elements meetingElements = dataElement.getFirstChildElement("meetings").getChildElements();
		for(int i = 0; i < meetingElements.size(); i++) {
			Meeting currentMeeting = MeetingConverter.convertXMLToMeeting(meetingElements.get(i));
			meetingList.addMeeting(currentMeeting);
		}
		return meetingList;
	}
}
