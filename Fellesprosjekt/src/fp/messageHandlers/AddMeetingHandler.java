package fp.messageHandlers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import nu.xom.Element;
import nu.xom.Elements;

import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.Notification;
import fp.dataObjects.Notification.NotificationType;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.events.ConcurrentEventDispatcher;
import fp.events.EventType;
import fp.events.ServerEvent;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
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
		
		if(registeredMeeting.meetingType == MeetingType.appointment) {return;}
		
		Element participantsElement = message.getDataElements().get(1);
		Elements participants = participantsElement.getChildElements();
		for(int i = 0; i < participants.size(); i++) {
			User user = UserConverter.convertXMLToUser(participants.get(i));
			DatabaseConnection.executeWriteQuery("INSERT INTO Notifications VALUES ("+user.userID+", " + meetingID + ", NULL, 'newMeeting')");
			if(user.userID != clientContext.user.userID) {
				Notification registeredNotification = new Notification(user.userID, meetingID, null, NotificationType.newMeeting);
				MeetingNotification notification = new MeetingNotification(registeredMeeting, registeredNotification);
				this.eventDispatcher.dispatchEvent(new ServerEvent<MeetingNotification>(EventType.SERVER_MEETING_REGISTERED, notification, user.userID));
			}
		}
		Message result = new Message(MessageType.addMeeting);
		clientContext.connectionHandler.sendMessage(result);
	}
	
	private String generateSQLQuery(Meeting meeting, User creator) {
		String query = "INSERT INTO Meeting VALUES(NULL, '" 	+ meeting.status + "','" + meeting.description + "', '" + meeting.locationType + "', '"
		+ meeting.location + "', '" 
		 + meeting.roomID + "', '" + stupidDateFormatToDateTime(meeting.startTime) + "', '" 
		+ stupidDateFormatToDateTime(meeting.endTime) + "', '" + creator.userID + "','" + meeting.meetingType + "');";
		return query;
	}
	
	private String stupidDateFormatToDateTime(String stupidFormat) {
		String[] dateTimeParts = stupidFormat.split(" ");
		String[] dateParts = dateTimeParts[0].split("/");
		String[] timeParts = dateTimeParts[1].split(":");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(dateParts[2]));
		cal.set(Calendar.WEEK_OF_YEAR, Integer.parseInt(dateParts[1]));
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateParts[0]));
		
		cal.set(Calendar.HOUR, Integer.parseInt(timeParts[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]));
		cal.set(Calendar.SECOND, Integer.parseInt(timeParts[2]));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		return format.format(cal.getTime());
	}
}
