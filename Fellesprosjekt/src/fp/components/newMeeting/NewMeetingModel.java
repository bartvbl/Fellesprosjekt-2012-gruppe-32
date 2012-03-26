package fp.components.newMeeting;


import java.util.ArrayList;

import fp.dataObjects.CalendarDate;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.MeetingRoom;

public class NewMeetingModel {
	
	private Meeting meeting;
	
	private String description;
	private String location;
	private LocationType locationType;
	private String startTime;
	private String endTime;
	private int roomID;
	private MeetingType meetingtype;
	private String startDate;
	private String endDate;
	private CalendarDate startCalenderDate;
	private CalendarDate endCalenderDate;
	private String fullStartTime;
	private String fullEndTime;
	private String participantSearch;
	private String meetingRoomSearch;
	private ArrayList<String> invited;
	private ArrayList<MeetingRoom> meetingRooms;
	
	public final static String DESCRIPTION = "desc";
	public final static String LOCATION = "loc";
	public final static String LOCATION_TYPE= "loctyp";
	public final static String START_TIME = "start_time";
	public final static String END_TIME = "end_time";
	public final static String ROOM_ID = "room_id";
	public final static String MEETING_TYPE = "meetyp";
	public final static String START_DATE = "start_date";
	public final static String END_DATE = "end_date";
	public final static String INVITED = "inv";
	public final static String PARTICIPANT_SEARCH = "part_search";
	public final static String MEETING_ROOM_SEARCH = "meet_search";
	public final static String CREATE_MEETING = "create_meeting";

	public NewMeetingModel(CalendarDate date){
		startCalenderDate = date;
		endCalenderDate = date;
		description = null;
		location = null;
		locationType = null;
		startTime = "0:0:0";
		endTime = "0:0:0";
		startDate = startCalenderDate.toString();
		endDate = endCalenderDate.toString();
		fullStartTime = startDate+" "+startTime;
		fullEndTime = endDate+" "+endTime;
		roomID = 0;
		meetingtype = null;
		participantSearch = null;
		meetingRoomSearch = null;
		invited = new ArrayList<String>();
	}

	public void addInvited(String participant){
		if(!invited.contains(participant)){
			invited.add(participant);
		}
	}
	
	public void removeInvited(String participant){
		if(invited.contains(participant)){
			invited.remove(participant);
		}
	}
	
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
		meeting = new Meeting(0, description, location, locationType, fullStartTime, fullEndTime, null, 0, roomID, meetingtype);
	}
	
	public Meeting getMeeting() {
		return meeting;
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

	public void setMeetingRooms(ArrayList<MeetingRoom> meetingRooms) {
		this.meetingRooms = meetingRooms;
	}

	public ArrayList<MeetingRoom> getMeetingRooms() {
		return meetingRooms;
	}
}
