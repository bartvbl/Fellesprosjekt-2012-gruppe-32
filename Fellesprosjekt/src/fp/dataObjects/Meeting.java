package fp.dataObjects;

public class Meeting {
	
	public final int meetingID;
	public final String description;
	public final String location;
	public final LocationType locationType;
	public enum LocationType{
		meeting, appointment
	}
	public final String startTime;
	public final String endTime;
	public final Status status;
	public enum Status{
		active, cancelled
	}
	
	public Meeting(int meetingID, String description, String location,
			LocationType locationType, String startTime, String endTime,
			Status status) {
		this.meetingID = meetingID;
		this.description = description;
		this.location = location;
		this.locationType = locationType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}	
}
