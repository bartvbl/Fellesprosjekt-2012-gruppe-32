package fp.messageHandlers;

import java.sql.SQLException;

import nu.xom.Element;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.Status;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;

public class GetMeetingsInWeekHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerUserData userdata) throws SQLException {
		// skal hente møte basert på starttime og endtime
		
		String[] fromDateToDate = extractDatesFromMessageData(message).split("+");
		String fromDate = fromDateToDate[0];
		String toDate = fromDateToDate[1];
		
		String sqlQurey = "SELECT Meeting FROM MEETING WHERE" + fromDate + "" + toDate + ");";
		
		DatabaseConnection.executeWriteQuery(sqlQurey);		
	}
	
	public String extractDatesFromMessageData(Message message){
		
		
		String fromDate = null, toDate = null;
		Element element = message.getData().getFirstChildElement("fromDate");
		if (element != null) {
			fromDate = element.getValue();
		}
		element = message.getData().getFirstChildElement("locationType");
		if (element != null) {
			toDate = element.getValue();
					
		}
		
		return fromDate + "+" + toDate;
	}

}
