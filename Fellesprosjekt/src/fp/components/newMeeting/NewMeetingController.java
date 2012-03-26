package fp.components.newMeeting;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import nu.xom.Element;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.User;
import fp.events.EventDispatcher;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.views.NewMeetingWindow;
import fp.xmlConverters.MeetingConverter;

public class NewMeetingController extends AbstractComponentController {

	NewMeetingModel meeting;
	ArrayList<User> users;
	
	public NewMeetingController(EventDispatcher eventDispatcher,NewMeetingModel meeting){
		super(ComponentControllerType.NEW_MEETING_VIEW, eventDispatcher);
		this.meeting = meeting;
	}
	
	public void create(){
		//opprett melding
		meeting.getMeeting();
		Element meetingData = MeetingConverter.convertMeetingToXML(meeting.getMeeting());
		Message message = new Message(MessageType.addMeeting);
		message.addDataElement(meetingData);
		
		//connection til server og send melding til den/database
		
		
	}
	
	
	
	public void cancel(){
		
		//lukk vinduet
		
	}
	
	public void searchForMeetingRoom(){
		
		
	}
	
	
	public void searchForUsers(){
		
		
		
	}
	
	
	public void addUser(){
		
		
	}
	
	
	public void selectMeetingRoom(){
		
		
	}
	
	public void setRoomID(int id){
		
	}

	public void setDescription(String description){
		
	}
	
	public void setStartDate(String date){
		
	}
	
	public void setStartTime(String time){
		
	}
	
	public void setEndDate(String date){
		
	}
	
	public void setEndTime(String time){
		
	}
	public void setParticipantSearch(String searchText){
		
	}	
	
	public void setMeetingRoomSearch(String searchText){
		
	}
	
	public void setLocation(String location){
		
	}	

}
