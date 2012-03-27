package fp.xmlConverters;

import fp.dataObjects.Meeting;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import nu.xom.Element;

public class MeetingNotificationConverter {
	public static Element convertMeetingNotificationToXML(MeetingNotification notification) {
		Element meetingNotificationElement = new Element("meetingNotification");
		Element notificationElement = NotificationConverter.convertNotificationToXML(notification.notification);
		Element meetingElement = MeetingConverter.convertMeetingToXML(notification.meeting);
		
		meetingNotificationElement.appendChild(meetingElement);
		meetingNotificationElement.appendChild(notificationElement);
		return meetingNotificationElement;
	}
	
	public static MeetingNotification convertXMLToMeetingNofitication(Element notificationElement) {
		Notification notification = NotificationConverter.convertXMLToNotification(notificationElement.getFirstChildElement("notification"));
		Meeting meeting = MeetingConverter.convertXMLToMeeting(notificationElement.getFirstChildElement("meeting"));
		
		return new MeetingNotification(meeting, notification);
	}
}
