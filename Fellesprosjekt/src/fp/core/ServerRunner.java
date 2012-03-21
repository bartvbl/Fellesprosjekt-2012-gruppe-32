package fp.core;


import java.sql.SQLException;

import nu.xom.Element;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.Status;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.messageHandlers.AddMeetingHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerMain;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.UserConverter;

public class ServerRunner {
	public static void main(String[] args) {
		ServerMain main = new ServerMain();
		main.initialize();
		Thread server = new Thread(main);
		server.start();
		//YYYY-MM-DD HH:MM:SS
		Meeting meeting = new Meeting(12, "Lolmøte", "på do", LocationType.location, "2012-12-12 12:12:12", "2012-12-13 12:12:12", Status.active, 14, 12, MeetingType.appointment);
		Element e = MeetingConverter.convertMeetingToXML(meeting);
		Message m = new Message(MessageType.addMeeting, e);
		AddMeetingHandler amh = new AddMeetingHandler();
		try {
			amh.handleMessage(m, new ServerUserData(new User(12, "username", "password", "firstname", "lastname", "email", "124325")));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
