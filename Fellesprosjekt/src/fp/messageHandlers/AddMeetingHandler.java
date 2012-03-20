package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class AddMeetingHandler implements MessageHandler {


	@Override
	public void handleMessage(Message message) throws SQLException {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		
		String sqlQurey = "INSERT INTO Meeting VALUES(NULL, " + meeting.description + ", " + meeting.status + "," + meeting.location 
						+ ", " + meeting.locationType + ", " + meeting.roomID + ", " + meeting.startTime + ", " + meeting.endTime + ", " + meeting.creatorID + "," + meeting.meetingType + ");";
		
		DatabaseConnection.executeWriteQuery(sqlQurey);
		
	}
	
	
	
	

	

}
