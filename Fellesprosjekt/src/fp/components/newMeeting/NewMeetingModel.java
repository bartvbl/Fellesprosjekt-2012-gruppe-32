package fp.components.newMeeting;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.Meeting.Status;

public class NewMeetingModel {
	
	private Meeting meeting;
	private PropertyChangeSupport pcs;
	
	private String description;
	private String location;
	private LocationType locationType;
	private String startTime;
	private String endTime;
	private int creatorID;
	private int roomID;
	private MeetingType meetingtype;
	private String startDate;
	private String endDate;
	private String fullStartTime;
	private String fullEndTime;
	private String participantSearch;
	private String meetingRoomSearch;
	private ArrayList<String> invited;
	
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

	public NewMeetingModel(){
		pcs = new PropertyChangeSupport(this);
		description = null;
		location = null;
		locationType = null;
		startTime = null;
		endTime = null;
		creatorID = 0;
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
