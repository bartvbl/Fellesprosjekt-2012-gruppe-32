package fp.dataObjects;

public class Meeting {
	
	public final int meetingID;
	public final String description;
	public final String location;
	public final LocationType locationType;
	public enum LocationType{
		meetingroom {
			public String toString(){
				return "meetingroom";
			}
		},
		location {
			public String toString(){
				return "location";
			}
		}			
	}

	public final String startTime;
	public final String endTime;
	public final MeetingStatus status;
	public enum MeetingStatus{
		active{
			public String toString(){
				return "active";
			}
		},
		cancelled{
			public String toString(){
				return "cancelled";
			}
		}
	}
	public final int creatorID;
	public final int roomID;
	public final MeetingType meetingType;
	public enum MeetingType{
		meeting{
			 public String toString(){
				 return "meeting";
			 }
		},
		appointment{
			public String toString(){
				return "appointment";
			}
		}
	}
	
	public Meeting(int meetingID, String description, String location,
			LocationType locationType, String startTime, String endTime,
			MeetingStatus status, int creatorID, int roomID, MeetingType meetingtype) {
		this.meetingID = meetingID;
		this.description = description;
		this.location = location;
		this.locationType = locationType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.creatorID = creatorID;
		this.roomID = roomID;
		this.meetingType = meetingtype;
	}	
}
