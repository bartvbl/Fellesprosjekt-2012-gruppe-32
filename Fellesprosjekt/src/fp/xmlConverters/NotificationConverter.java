package fp.xmlConverters;

import nu.xom.Element;
import fp.dataObjects.Notification;
import fp.dataObjects.Notification.acceptedMeeting;
import fp.dataObjects.Notification.notificationType;
import fp.dataObjects.User;

public class NotificationConverter {
	//blabla

	
	public static void main(String[] args) {
		Notification not = new Notification(1, 3, acceptedMeeting.Yes, notificationType.newMeeting);
		System.out.println(convertNotificationToXML(not));
	}
	
	
public static Element convertNotificationToXML(Notification notification) {
	
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
	acceptedMeeting aM = null;
	notificationType nT = null;
	

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
		if(element.getValue().equals("Yes")){
			aM = aM.Yes;
		}else if(element.getValue().equals("No")){
			nT = nT.newMeeting;
		}
	}
	element = notificationElement.getFirstChildElement("notificationType");
	if (element != null) {
		if(element.getValue().equals("newMeeting")){
			nT = nT.newMeeting;
		}else if(element.getValue().equals("meetingUpdated")){
			nT = nT.meetingUpdated;
		}else if(element.getValue().equals("meetingCancelled")){
			nT = nT.meetingCancelled;
		}
	}
	
	return new Notification(Integer.parseInt(userID), Integer.parseInt(meetingID), aM, nT);
	
}

}
