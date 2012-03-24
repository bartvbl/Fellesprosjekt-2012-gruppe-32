package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;

public class RemoveMeetingHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getDataElements().get(0));
		
		String queryString = "REMOVE MEETING FROM MEETING WHERE MeetingID = '" + meeting.meetingID + "';";
	}
	
}
