package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;

public class RemoveMeetingHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getDataElements().get(0));
		
		String query = "DELETE FROM Meeting WHERE MeetingID = " + meeting.meetingID + ";";
		DatabaseConnection.executeWriteQuery(query);
		
		Message result = new Message(MessageType.removeMeeting);
		clientContext.connectionHandler.sendMessage(result);
	}
}
