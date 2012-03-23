package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;

public class AddFavouriteMeetingHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		
		String sqlQurey = "INSERT INTO UserFavourites VALUES('"+ clientContext.user.userID+"' , 'appointment', NULL, '" + meeting.meetingID+"');";
		
		DatabaseConnection.executeWriteQuery(sqlQurey);
	}

	
}
