package fp.components.newMeeting;


import java.util.ArrayList;

import fp.dataObjects.CalendarDate;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.MeetingRoom;
import fp.net.client.ClientConnectionContext;

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
		meetingRooms = new ArrayList<MeetingRoom>();
	}

	public String getFullStartTime() {
		return fullStartTime;
	}

	public String getFullEndTime() {
		return fullEndTime;
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
	
	public ArrayList<String> getInvited(){
		return this.invited;
	}
	
	public int getNumberOfInvited(){
		return invited.size();
	}
	
	public String getParticipantSearch() {
		return participantSearch;
	}

	public void setParticipantSearch(String participantSearch) {
		this.participantSearch = participantSearch;
	}

	public String getMeetingRoomSearch() {
		
		ClientConnectionContext.getInstance();
		return meetingRoomSearch;
	}

	public void setMeetingRoomSearch(String meetingRoomSearch) {
		this.meetingRoomSearch = meetingRoomSearch;
		locationType = LocationType.MeetingRoom;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
		this.fullStartTime = startDate+" "+startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
		this.fullEndTime = endDate+" "+endTime;
	}

	public void createMeeting(){
		meeting = new Meeting(0, description, location, locationType, fullStartTime, fullEndTime, Meeting.MeetingStatus.Active, 0, roomID, meetingtype);
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
		locationType = LocationType.Location;
	}
	public LocationType getLocationType() {
		return locationType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
		this.fullStartTime = startDate+" "+startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
		this.fullEndTime = endDate+" "+endTime;
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
