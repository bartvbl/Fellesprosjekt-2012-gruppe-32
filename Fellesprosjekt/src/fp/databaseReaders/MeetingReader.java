package fp.databaseReaders;

import java.sql.ResultSet;
import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.MeetingStatus;

public class MeetingReader {

	public static Meeting readMeetingFromResultSet(ResultSet result) throws SQLException {
		System.out.println("reading_: " + result.getString("LocationType"));
		LocationType type = Enum.valueOf(LocationType.class, result.getString("LocationType"));
		MeetingStatus meetingStatus = Enum.valueOf(MeetingStatus.class, result.getString("Status"));
		MeetingType meetingType = Enum.valueOf(MeetingType.class, result.getString("MeetingType"));
		return new Meeting(	result.getInt("MeetingID"), 
							result.getString("Description"), 
							result.getString("Location"),
							type,
							result.getString("StartTime"),
							result.getString("EndTime"),
							meetingStatus,
							result.getInt("CreatorID"),
							result.getInt("RoomID"),
							meetingType);
	}

}
