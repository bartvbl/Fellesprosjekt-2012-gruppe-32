package fp.core;

import java.sql.SQLException;

import nu.xom.Element;
import nu.xom.Elements;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.Status;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.messageHandlers.AddMeetingHandler;
import fp.messageHandlers.GetMeetingsInWeekHandler;
import fp.messageHandlers.GetObjectsFromDatabaseHandler;
import fp.messageHandlers.GetUserHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerMain;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.UserConverter;
import fp.xmlConverters.WeekConverter;

public class ServerRunner {
	public static void main(String[] args) {
		ServerMain main = new ServerMain();
		main.initialize();
		Thread server = new Thread(main);
		server.start();
		try {
			testGetMeetingRooms();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testGetMeetingRooms() throws SQLException {
		Element result = GetObjectsFromDatabaseHandler
				.meetingRoomSearch(1, "2012-02-01 00:00:00", "2012-03-01 00:00:00");
		Elements elements = result.getChildElements();
		Element e = elements.get(0);
		System.out.println(result.toXML());
	}

	public static void testGetMeetingsInWeekHandler() {
		Element e = WeekConverter.convertWeekYearToXML(12, 3, 2012);
		Message m = new Message(MessageType.getMeetingsInWeek, e);
		GetMeetingsInWeekHandler h = new GetMeetingsInWeekHandler();
		try {
			h.handleMessage(m, new ServerUserData(new User(12, "Neshyy",
					"roflmao", "Flanders", "Trondboe", "flanders@boe.com",
					"81549300")));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void testAddUserHandler() {
		User user = new User(13, "Neshyy", "roflmao", "Flanders", "Trond",
				"boe@lool.com", "81549300");
		Message m = new Message(MessageType.getUser,
				UserConverter.convertUserToXML(user));
		GetUserHandler h = new GetUserHandler();
		ServerUserData serverData = new ServerUserData(user);

		try {
			h.handleMessage(m, serverData);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testAddMeetingHandler() {
		Meeting meeting = new Meeting(12, "Lolmøte", "på do",
				LocationType.location, "2012-3-22 0:0:0", "2012-3-2 0:0:1",
				Status.active, 12, 12, MeetingType.appointment);
		Element e = MeetingConverter.convertMeetingToXML(meeting);
		Message m = new Message(MessageType.addMeeting, e);
		AddMeetingHandler amh = new AddMeetingHandler();
		try {
			amh.handleMessage(m, new ServerUserData(new User(12, "username",
					"password", "firstname", "lastname", "email", "124325")));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
