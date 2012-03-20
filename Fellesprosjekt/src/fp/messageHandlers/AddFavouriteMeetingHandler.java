package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class AddFavouriteMeetingHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerUserData userData) throws SQLException {
		
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getData());
		
		String sqlQurey = "INSERT INTO UserFavourites VALUES("+ userData.getUser().userID+" , appointment" +  + ", " + meeting.status + "," + meeting.location 
						+ ", " + meeting.locationType + ", " + meeting.roomID + ", " + meeting.startTime + ", " + meeting.endTime + ", " + meeting.creatorID + "," + meeting.meetingType + ");";
		
		DatabaseConnection.executeWriteQuery(sqlQurey);
	}

}
