package fp.xmlConverters;

import nu.xom.Element;
import fp.dataObjects.Notification;
import fp.dataObjects.User;

public class NotificationConverter {
	
public static String convertNotificationToXML(Notification notification) {
	
	Element element = new Element("notification");
	
	Element userID = new Element("userID");
	userID.appendChild(notification.userID + "");
	
	Element meetingID = new Element("meetingID");
	meetingID.appendChild(notification.meetingID + "");
	
	Element acceptedMeeting = new Element("acceptedMeeting");
	acceptedMeeting.appendChild(notification.aM.toString());
	
	Element notificationType = new Element("NotificationType");
	notificationType.appendChild(notification.nT.toString());

	element.appendChild(userID);
	element.appendChild(meetingID);
	element.appendChild(acceptedMeeting);
	element.appendChild(notificationType);

	return element.toXML();
}

	

	
//public static Notification convertXMLToPerson(String xml) {
//	
//}
}
