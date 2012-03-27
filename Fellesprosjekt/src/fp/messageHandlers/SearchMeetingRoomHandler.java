package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import nu.xom.Element;

import fp.dataObjects.MeetingRoom;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingRoomConverter;

public class SearchMeetingRoomHandler implements MessageHandler{

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		
		Element data = message.getDataElements().get(0);
		int capacity = 0;
		String fromDateTime = null;
		String toDateTime = null;
		Element element = data.getFirstChildElement("capacity");
		if(element != null){
			capacity = Integer.parseInt(element.getValue());
		}
		element = data.getFirstChildElement("fromDateTime");
		if(element != null){
			fromDateTime = element.getValue();
		}
		element = data.getFirstChildElement("toDateTime");
		if(element != null){
			toDateTime = element.getValue();
		}
		data = searchMeeting(capacity, fromDateTime, toDateTime);
		Message result = new Message(MessageType.searchMeetingRoom);
		result.addDataElement(data);
		clientContext.connectionHandler.sendMessage(result);
	}
	
	public Element searchMeeting(int capacity, String fromDateTime, String toDateTime) throws SQLException{
		
		Element data = new Element("data");
		
		int meetingRoomID = 0;
		int size = 0;
		String name = null;
		
		fromDateTime = stupidDateFormatToDateTime(fromDateTime);
		toDateTime = stupidDateFormatToDateTime(toDateTime);
		
		String query = 	"SELECT * FROM MeetingRoom WHERE Size >= " + capacity + " " + "AND RoomID NOT IN (SELECT RoomID FROM Meeting WHERE (('" + fromDateTime + "' >= StartTime AND '" + fromDateTime + "' < Endtime) OR ('" + fromDateTime + "' < StartTime AND '" + toDateTime + "' > StartTime)));";
		
		ResultSet rs = DatabaseConnection.executeReadQuery(query);
		while(rs.next()){
			meetingRoomID = rs.getInt("RoomID");
			size = rs.getInt("Size");
			name = rs.getString("RoomName");
			
			MeetingRoom meetingRoom = new MeetingRoom(meetingRoomID, size, name);
			Element element = MeetingRoomConverter.convertMeetingRoomToXML(meetingRoom);
			data.appendChild(element);
		}
		
		return data; 
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
