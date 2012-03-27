package fp.components.newMeeting;


import nu.xom.Element;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingStatus;
import fp.dataObjects.Meeting.MeetingType;
import fp.events.EventDispatcher;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;
import fp.xmlConverters.MeetingConverter;

public class NewMeetingController extends AbstractComponentController {

	NewMeetingModel model;
	
	public NewMeetingController(EventDispatcher eventDispatcher){
		super(ComponentControllerType.NEW_MEETING_VIEW, eventDispatcher);
	}
	
	public void setModel(NewMeetingModel model){
		this.model = model;
	}
	
	public void create(){
		//opprett melding
		model.createMeeting();
		Element meetingData = MeetingConverter.convertMeetingToXML(model.getMeeting());
		Message message = new Message(MessageType.addMeeting);
		message.addDataElement(meetingData);
		
		//connection til server og send melding til den/database
		ClientConnectionContext.getInstance().connectionHandler.sendMessage(message);
		System.out.println("SENDER MELDING!!!!!");
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
		model.setRoomID(id);
	}

	public void setDescription(String description){
		model.setDescription(description);
	}
	
	public void setStartDate(String date){
		model.setStartDate(date);
	}
	
	public void setStartTime(String time){
		model.setStartTime(time);
	}
	
	public void setEndDate(String date){
		model.setEndDate(date);
	}
	
	public void setEndTime(String time){
		model.setEndTime(time);
	}
	
	public void setParticipantSearch(String searchText){
		model.setParticipantSearch(searchText);
	}	
	
	public void setMeetingRoomSearch(String searchText){
		model.setMeetingRoomSearch(searchText);
	}
	
	public void setLocation(String location){
		model.setLocation(location);
	}	

}
