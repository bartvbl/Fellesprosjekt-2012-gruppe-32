package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import nu.xom.Element;

import fp.dataObjects.MeetingRoom;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingRoomConverter;

public class SearchMeetingHandler implements MessageHandler{

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public static Element meetingRoomSearch(int capacity, String fromDateTime, String toDateTime) throws SQLException{
		
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
