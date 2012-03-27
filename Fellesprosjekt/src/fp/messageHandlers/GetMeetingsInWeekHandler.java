package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import nu.xom.Element;
import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingStatus;
import fp.dataObjects.Meeting.MeetingType;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.MeetingRoomConverter;

public class GetMeetingsInWeekHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		// skal hente møte basert på starttime og endtime
		String[] fromDateToDate = extractDatesFromMessageData(message).split("#");
		String fromDate = fromDateToDate[0];
		String toDate = fromDateToDate[1];
		
		Element meetingElement = new Element("MeetingElement");
		int meetingID = 0;
		String description = null;
		String location = null;
		LocationType locationType = null;
		String startTime = null;
		String endTime = null;
		MeetingStatus status = null;
		int creatorID = 0;
		int roomID = 0;
		MeetingType meetingType = null;
		
		
		String sqlQuery = "SELECT * FROM Meeting WHERE StartTime >= '" + fromDate + "' AND Endtime <= '" + toDate + "';";
		System.out.println(sqlQuery);
		ResultSet resultSet = DatabaseConnection.executeReadQuery(sqlQuery);
		
		while (resultSet.next()){
			
			meetingID=resultSet.getInt("MeetingID");				
			description= resultSet.getString("Description");		
			location=resultSet.getString("Location");
			locationType=Enum.valueOf(LocationType.class, resultSet.getString("LocationType"));
			startTime=resultSet.getString("StartTime");
			endTime=resultSet.getString("EndTime");
			status=Enum.valueOf(MeetingStatus.class, resultSet.getString("Status"));
			creatorID=resultSet.getInt("CreatorID");
			roomID=resultSet.getInt("RoomID");
			meetingType=Enum.valueOf(MeetingType.class, resultSet.getString("Meetingtype"));

			
			Meeting meeting = new Meeting(meetingID, description, location, locationType, startTime, endTime, status, creatorID,roomID,meetingType);
			
			Element element = MeetingConverter.convertMeetingToXML(meeting);
			meetingElement.appendChild(element);
		}
		
		//System.out.println(meetingElement.toXML());
		Message result = new Message(MessageType.getMeetingsInWeek);
		result.addDataElement(meetingElement);
		clientContext.connectionHandler.sendMessage(result);
		
	}
	
	public String extractDatesFromMessageData(Message message){
		String fromDate = null, toDate = null;
		Element element = message.getDataElements().get(0).getFirstChildElement("fromDate");
		if (element != null) {
			fromDate = element.getValue();
		}
		element = message.getDataElements().get(0).getFirstChildElement("toDate");
		if (element != null) {
			toDate = element.getValue();
		}
		
		return fromDate + "#" + toDate;
	}

}
