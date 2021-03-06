package fp.xmlConverters;

import nu.xom.Element;
import fp.dataObjects.Notification;
import fp.dataObjects.Notification.NotificationStatus;
import fp.dataObjects.Notification.NotificationType;
import fp.dataObjects.User;

public class NotificationConverter {
	//blabla

	
	public static void main(String[] args) {
		Notification not = new Notification(1, 3, NotificationStatus.Yes, NotificationType.newMeeting);
		System.out.println(convertNotificationToXML(not));
	}
	
	
public static Element convertNotificationToXML(Notification notification) {
	
	Element element = new Element("notification");
	
	Element userID = new Element("userID");
	userID.appendChild(notification.userID + "");
	
	Element meetingID = new Element("meetingID");
	meetingID.appendChild(notification.meetingID + "");
	
	Element acceptedMeeting = new Element("acceptedMeeting");
	acceptedMeeting.appendChild(notification.notificationStatus.toString());
	
	Element notificationType = new Element("notificationType");
	notificationType.appendChild(notification.notificationType.toString());

	element.appendChild(userID);
	element.appendChild(meetingID);
	element.appendChild(acceptedMeeting);
	element.appendChild(notificationType);
	return element;
}

	
//public static Notification convertXMLToPerson(String xml) {
//	
//}

public Notification toNotification(String xml) throws java.io.IOException, java.text.ParseException, nu.xom.ParsingException {
	nu.xom.Builder parser = new nu.xom.Builder(false);
	nu.xom.Document doc = parser.build(xml, "");
	return convertXMLToNotification(doc.getRootElement());
    }

public static Notification convertXMLToNotification(Element notificationElement) {
	String userID = null, meetingID = null;
	NotificationStatus notificationStatus = null;
	NotificationType nofiticationType = null;
	
	Element element = notificationElement.getFirstChildElement("userID");
	if (element != null) {
		userID = element.getValue();
	}
	element = notificationElement.getFirstChildElement("meetingID");
	if (element != null) {
		meetingID = element.getValue();
	}
	element = notificationElement.getFirstChildElement("acceptedMeeting");
	if (element != null) {
		notificationStatus = Enum.valueOf(NotificationStatus.class, element.getValue());
	}
	element = notificationElement.getFirstChildElement("notificationType");
	if (element != null) {
		nofiticationType = Enum.valueOf(NotificationType.class, element.getValue());
	}
	
	return new Notification(Integer.parseInt(userID), Integer.parseInt(meetingID), notificationStatus, nofiticationType);
}

}
