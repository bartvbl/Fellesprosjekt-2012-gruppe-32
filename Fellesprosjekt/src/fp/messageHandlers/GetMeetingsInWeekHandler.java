package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import nu.xom.Element;
import fp.dataObjects.ServerUserData;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;

public class GetMeetingsInWeekHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerUserData userdata) throws SQLException {
		// skal hente møte basert på starttime og endtime
		String[] fromDateToDate = extractDatesFromMessageData(message).split("#");
		String fromDate = fromDateToDate[0];
		String toDate = fromDateToDate[1];
		System.out.println(fromDateToDate.length + "");
		
		String sqlQuery = "SELECT * FROM Meeting WHERE StartTime >= '" + fromDate + "' AND Endtime <= '" + toDate + "';";
		System.out.println(sqlQuery);
		ResultSet rs = DatabaseConnection.executeReadQuery(sqlQuery);
		while (rs.next()){
			System.out.println("rofl");
			System.out.println(rs.getString("Description"));
			
		}
	}
	
	public String extractDatesFromMessageData(Message message){
		
		String fromDate = null, toDate = null;
		Element element = message.getData().getFirstChildElement("fromDate");
		if (element != null) {
			fromDate = element.getValue();
		}
		element = message.getData().getFirstChildElement("toDate");
		if (element != null) {
			toDate = element.getValue();
		}
		
		return fromDate + "#" + toDate;
	}

}
