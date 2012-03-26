package fp.xmlConverters;

import fp.dataObjects.Meeting;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import nu.xom.Element;

public class MeetingNotificationConverter {
	public static Element convertMeetingotificationToXML(MeetingNotification notification) {
		Element notificationElement = NotificationConverter.convertNotificationToXML(notification.notification);
		Element meetingElement = MeetingConverter.convertMeetingToXML(notification.meeting);
		
		notificationElement.appendChild(meetingElement);
		
		return notificationElement;
	}
	
	public static MeetingNotification converXMLToMeetingNofitication(Element notificationElement) {
		Notification notification = NotificationConverter.convertXMLToNotification(notificationElement);
		Meeting meeting = MeetingConverter.convertXMLToMeeting(notificationElement.getChildElements().get(0));
		
		return new MeetingNotification(meeting, notification);
	}
}
