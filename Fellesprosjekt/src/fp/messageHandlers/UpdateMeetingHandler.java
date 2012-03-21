package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class UpdateMeetingHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerUserData userdata) throws SQLException {
		
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		
		String sqlQurey = "UPDATE Meeting SET description='" 	+ meeting.description + "', status = '" + meeting.status + "', startTime = '"
																+ meeting.startTime + "', endTime = '" + meeting.endTime + "', location = '" 
																+ meeting.location + "', locationTyoe = '" + meeting.locationType + "', roomID = '"
																+ meeting.roomID + "', creatorID = '" + meeting.creatorID + "', meetingType = '"
																+ meeting.meetingType + "' WHERE meetingID = '" + meeting.meetingID + "';";

		DatabaseConnection.executeWriteQuery(sqlQurey);
		

	}

}
