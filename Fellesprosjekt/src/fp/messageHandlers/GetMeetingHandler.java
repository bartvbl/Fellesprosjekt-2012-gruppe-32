
package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Descriptor;

import nu.xom.Element;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.MeetingStatus;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.UserConverter;

public class GetMeetingHandler implements MessageHandler{

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		User user;
		String query;
		ResultSet resultSet;
		Element data;
		Meeting meeting;
		
		int meetingID=0;
		String description=null;
		String location=null;
		LocationType locationType=null;
		String startTime=null;
		String endTime=null;
		MeetingStatus status=null;
		int creatorID=0;
		int roomID=0;
		MeetingType meetingType=null;

		
		meeting = MeetingConverter.convertXMLToMeeting(message.getDataElements().get(0));		
		query = "SELECT Meeting FROM MEETING WHERE MeetindID ='" + meeting.meetingID + "');";
		
		DatabaseConnection.connect();
		resultSet = DatabaseConnection.executeReadQuery(query);
		DatabaseConnection.disconnect();
		while(resultSet.next()){
			
			meetingID = resultSet.getInt("MeetingID");
			description = resultSet.getString("Description");
			location = resultSet.getString("Location");
			locationType = Enum.valueOf(LocationType.class, resultSet.getString("LocationType"));
			startTime = resultSet.getString("StartTime");
			endTime = resultSet.getString("EndTime");
			status = Enum.valueOf(MeetingStatus.class, resultSet.getString("Status"));
			creatorID = resultSet.getInt("CreatorID");
			roomID = resultSet.getInt("RoomID");
			meetingType = Enum.valueOf(MeetingType.class, resultSet.getString("Meetingtype"));
			
		}
		
		meeting = new Meeting(meetingID, description, location, locationType, startTime, endTime, status, creatorID, roomID, meetingType);
		data = MeetingConverter.convertMeetingToXML(meeting);
	}

}