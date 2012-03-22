package fp.components.newMeeting;

import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.Status;

public class NewMeetingModel {
	
	private Meeting meeting;
	
	private String description = null;
	private String location = null;
	private LocationType locationType = null;
	private String startTime = null;
	private String endTime = null;
	private int creatorID = 0;
	private int roomID = 0;
	private MeetingType meetingtype;
	private String startDate = null;
	private String endDate = null;
	private String fullStartTime = null;
	private String fullEndTime = null;
	private String participantSearch = null;
	private String meetingRoomSearch = null;
	
	public String getParticipantSearch() {
		return participantSearch;
	}

	public void setParticipantSearch(String participantSearch) {
		this.participantSearch = participantSearch;
	}

	public String getMeetingRoomSearch() {
		return meetingRoomSearch;
	}

	public void setMeetingRoomSearch(String meetingRoomSearch) {
		this.meetingRoomSearch = meetingRoomSearch;
		locationType = LocationType.meetingroom;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void createMeeting(){
		meeting = new Meeting(0, description, location, locationType, fullStartTime, fullEndTime, null, creatorID, roomID, meetingtype);
	}
	
	public Meeting getMeeting() {
		return meeting;
	}
	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
		locationType = LocationType.location;
	}
	public LocationType getLocationType() {
		return locationType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getCreatorID() {
		return creatorID;
	}
	public void setCreatorID(int creatorID) {
		this.creatorID = creatorID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public MeetingType getMeetingtype() {
		return meetingtype;
	}
	public void setMeetingtype(MeetingType meetingtype) {
		this.meetingtype = meetingtype;
	}
	
}
