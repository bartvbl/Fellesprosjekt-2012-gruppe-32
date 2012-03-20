package fp.messageHandlers;

import fp.dataObjects.Meeting;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class RemoveMeetingHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message) {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		
		String queryString = "REMOVE MEETING FROM MEETING WHERE MeetingID = " + meeting.meetingID + ";";
	}
	
}
