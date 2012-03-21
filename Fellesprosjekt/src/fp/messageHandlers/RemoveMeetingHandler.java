package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class RemoveMeetingHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerUserData userdata) throws SQLException {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		
		String queryString = "REMOVE MEETING FROM MEETING WHERE MeetingID = '" + meeting.meetingID + "';";
	}
	
}
