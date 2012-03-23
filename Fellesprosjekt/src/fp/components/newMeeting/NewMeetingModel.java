package fp.components.newMeeting;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.Status;
import fp.dataObjects.MeetingRoom;

public class NewMeetingModel {
	
	private Meeting meeting;
	private PropertyChangeSupport pcs;
	
	private String description;
	private String location;
	private LocationType locationType;
	private String startTime;
	private String endTime;
	private int roomID;
	private MeetingType meetingtype;
	private String startDate;
	private String endDate;
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

	public NewMeetingModel(){
		pcs = new PropertyChangeSupport(this);
		description = null;
		location = null;
		locationType = null;
		startTime = null;
		endTime = null;
		roomID = 0;
		meetingtype = null;
		startDate = null;
		endDate = null;
		fullStartTime = null;
		fullEndTime = null;
		participantSearch = null;
		meetingRoomSearch = null;
		invited = new ArrayList<String>();
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		pcs.addPropertyChangeListener(listener);
	}
	
	public void addInvited(String participant){
		if(!invited.contains(participant)){
			ArrayList<String> oldInv = invited;
			invited.add(participant);
			pcs.firePropertyChange(INVITED, oldInv, invited);
		}
	}
	
	public void removeInvited(String participant){
		if(invited.contains(participant)){
			ArrayList<String> oldInv = invited;
			invited.remove(participant);
			pcs.firePropertyChange(INVITED, oldInv, invited);
		}
	}
	
	public String getParticipantSearch() {
		return participantSearch;
	}

	public void setParticipantSearch(String participantSearch) {
		String oldValue = this.participantSearch;
		this.participantSearch = participantSearch;
		pcs.firePropertyChange(PARTICIPANT_SEARCH, oldValue, this.participantSearch);
	}

	public String getMeetingRoomSearch() {
		return meetingRoomSearch;
	}

	public void setMeetingRoomSearch(String meetingRoomSearch) {
		String oldValue = this.meetingRoomSearch;
		this.meetingRoomSearch = meetingRoomSearch;
		pcs.firePropertyChange(MEETING_ROOM_SEARCH, oldValue, this.meetingRoomSearch);
		if(locationType == LocationType.location){
			locationType = LocationType.meetingroom;
			pcs.firePropertyChange(LOCATION_TYPE, LocationType.location, LocationType.meetingroom);
		}
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
//		String oldvalue = this.startDate;
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
		pcs.firePropertyChange(CREATE_MEETING, null, meeting);
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
		String oldValue = this.location;
		this.location = location;
		pcs.firePropertyChange(LOCATION, oldValue, this.location);
		if(!(locationType == LocationType.location)){
			locationType = LocationType.location;
			pcs.firePropertyChange(LOCATION_TYPE, LocationType.meetingroom, LocationType.location);
		}
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
		MeetingType oldValue = this.meetingtype;
		this.meetingtype = meetingtype;
		pcs.firePropertyChange(MEETING_TYPE, oldValue, this.meetingtype);
	}

	public void setMeetingRooms(ArrayList<MeetingRoom> meetingRooms) {
		this.meetingRooms = meetingRooms;
	}

	public ArrayList<MeetingRoom> getMeetingRooms() {
		return meetingRooms;
	}
	
}
