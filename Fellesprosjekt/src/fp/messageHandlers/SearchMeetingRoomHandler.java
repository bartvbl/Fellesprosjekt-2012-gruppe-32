package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nu.xom.Element;

import fp.dataObjects.MeetingRoom;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingRoomConverter;

public class SearchMeetingRoomHandler implements MessageHandler{

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext)
			throws SQLException {
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
	
	public static Element searchMeeting(int capacity, String fromDateTime, String toDateTime) throws SQLException{
		
		Element meetingRoomElement = new Element("MeetingRoomElement");
		
		int meetingRoomID = 0;
		int size = 0;
		String name = null;
		
		String query = 	"SELECT * FROM MeetingRoom WHERE Size >= " + capacity + " " + "AND RoomID NOT IN (SELECT RoomID FROM Meeting WHERE (('" + fromDateTime + "' >= StartTime AND '" + fromDateTime + "' < Endtime) OR ('" + fromDateTime + "' < StartTime AND '" + toDateTime + "' > StartTime)));";
		
		ResultSet rs = DatabaseConnection.executeReadQuery(query);
		while(rs.next()){
			meetingRoomID = rs.getInt("RoomID");
			size = rs.getInt("Size");
			name = rs.getString("RoomName");
			
			MeetingRoom meetingRoom = new MeetingRoom(meetingRoomID, size, name);
			Element element = MeetingRoomConverter.convertMeetingRoomToXML(meetingRoom);
			meetingRoomElement.appendChild(element);
		}
		
		return meetingRoomElement; 
	}

}
