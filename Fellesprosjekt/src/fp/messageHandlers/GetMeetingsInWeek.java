package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class GetMeetingsInWeek implements MessageHandler {

	@Override
	public void handleMessage(Message message) throws SQLException {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		// skal hente møte basert på starttime og endtime
		
		String sqlQurey = "SELECT Meeting FROM MEETING WHERE" + meeting.startTime + "" + meeting.endTime + ");";
		
		DatabaseConnection.executeWriteQuery(sqlQurey);		
	}

}
