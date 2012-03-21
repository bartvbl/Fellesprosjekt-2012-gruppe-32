package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class AddMeetingHandler implements MessageHandler {


	@Override
	public void handleMessage(Message message, ServerUserData userdata) throws SQLException {
		System.out.println("Starter konvertering...");
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		
		System.out.println("Konvertert til XML fil...");
		System.out.println("Oppretter SQL streng");
		
		String sqlQurey = "INSERT INTO Meeting VALUES(NULL, " 	+ meeting.status + "," + meeting.description + ", " + meeting.locationType + ", "
																+ meeting.location + ", " 
																 + meeting.roomID + ", " + meeting.startTime + ", " 
																+ meeting.endTime + ", " + meeting.creatorID + "," + meeting.meetingType + ");";
		
		System.out.println("Setter inn i database");
		DatabaseConnection.executeWriteQuery(sqlQurey);
		
		System.out.println("Ferdig");
	}
	

}
