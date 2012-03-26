package fp.messageHandlers;

import java.sql.SQLException;

import nu.xom.Element;
import nu.xom.Elements;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.events.ConcurrentEventDispatcher;
import fp.events.EventType;
import fp.events.ServerEvent;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.UserConverter;

public class AddMeetingHandler implements MessageHandler {
	/* this handler expects the following data tag structure:
	 * 	<data>
	 * 		<meeting />
	 * 		<participants>
	 * 			<user />
	 * 		</participants>
	 * 	</data>
	 */
	
	private ConcurrentEventDispatcher eventDispatcher;

	public AddMeetingHandler(ConcurrentEventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		Meeting meeting = MeetingConverter.convertXMLToMeeting(message.getDataElements().get(0));
		String query = generateSQLQuery(meeting, clientContext.user);
		int meetingID = DatabaseConnection.exectuteWriteQueryAndReturnID(query);
		
		Meeting registeredMeeting = new Meeting(meetingID, meeting.description, meeting.location, meeting.locationType, meeting.startTime, meeting.endTime, meeting.status, clientContext.user.userID, meeting.roomID, meeting.meetingType);
		
		Element participantsElement = message.getDataElements().get(1);
		Elements participants = participantsElement.getChildElements();
		for(int i = 0; i < participants.size(); i++) {
			User user = UserConverter.convertXMLToUser(participants.get(i));
			DatabaseConnection.executeWriteQuery("INSERT INTO Notifications VALUES ("+user.userID+", " + meetingID + ", NULL, 'newMeeting')");
			if(user.userID != clientContext.user.userID) {
				this.eventDispatcher.dispatchEvent(new ServerEvent<Meeting>(EventType.SERVER_MEETING_REGISTERED, registeredMeeting, user.userID));
			}
		}
	}
	
	private String generateSQLQuery(Meeting meeting, User creator) {
		String query = "INSERT INTO Meeting VALUES(NULL, '" 	+ meeting.status + "','" + meeting.description + "', '" + meeting.locationType + "', '"
		+ meeting.location + "', '" 
		 + meeting.roomID + "', '" + meeting.startTime + "', '" 
		+ meeting.endTime + "', '" + creator.userID + "','" + meeting.meetingType + "');";
		return query;
	}
}
