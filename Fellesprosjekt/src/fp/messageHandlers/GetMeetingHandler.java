
package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class GetMeetingHandler implements MessageHandler{

	@Override
	public void handleMessage(Message message) throws SQLException {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		// skal hente møte basert på meetingID
		String sqlQurey = "SELECT Meeting FROM MEETING WHERE" + meeting.meetingID + ");";
		
		DatabaseConnection.executeWriteQuery(sqlQurey);

	}

}
