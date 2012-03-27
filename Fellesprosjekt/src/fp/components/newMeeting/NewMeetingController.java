package fp.components.newMeeting;


import java.util.ArrayList;

import nu.xom.Element;
import nu.xom.Elements;
import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingStatus;
import fp.dataObjects.Meeting.MeetingType;
import fp.dataObjects.MeetingRoom;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.client.ClientConnectionContext;
import fp.views.NewMeetingWindow;
import fp.xmlConverters.MeetingConverter;

public class NewMeetingController extends AbstractComponentController implements EventHandler{

	NewMeetingModel model;
	EventDispatcher eventDispatcher;
	
	public NewMeetingController(EventDispatcher eventDispatcher){
		super(ComponentControllerType.NEW_MEETING_VIEW, eventDispatcher);
		this.eventDispatcher = eventDispatcher;
	}
	
	public void setModel(NewMeetingModel model){
		this.model = model;
		
		if (model != null) {
			if (model.getMeetingtype() == null) {
				//TODO: unset the toggled button
			} else if (model.getMeetingtype() == Meeting.MeetingType.appointment) {
				NewMeetingWindow.newAppointmentButton.setSelected(true);
			} else if (model.getMeetingtype() == Meeting.MeetingType.meeting) {
				NewMeetingWindow.newMeetingButton.setSelected(true);
			}
			
			NewMeetingWindow.appointmentTitleTextPane.setText(model.getDescription());
			NewMeetingWindow.startDateTextPane.setText(model.getStartDate());
			NewMeetingWindow.startTimeTextPane.setText(model.getStartTime());
			NewMeetingWindow.endDateTextPane.setText(model.getEndDate());
			NewMeetingWindow.endTimeTextPane.setText(model.getEndTime());
			
			if (model.getLocationType() == null) {
				//TODO: Write room label
				NewMeetingWindow.manualLocationTextPane.setText("");
			} else if (model.getLocationType() == LocationType.MeetingRoom) {
				//TODO: Write room label
				NewMeetingWindow.manualLocationTextPane.setText("");
			} else if (model.getLocationType() == LocationType.Location) {
				//TODO: Write room label
				NewMeetingWindow.manualLocationTextPane.setText(model.getLocation());
			}
		}
	}
	
	public void create(){
		//opprett melding
		model.createMeeting();
		Element meetingData = MeetingConverter.convertMeetingToXML(model.getMeeting());
		Message message = new Message(MessageType.addMeeting);
		message.addDataElement(meetingData);
		
		//connection til server og send melding til den/database
		ClientConnectionContext.getInstance().connectionHandler.sendMessage(message);
		NewMeetingWindow.setFrameVisible(false);
	}
	
	
	
	public void cancel(){
		setModel(null);
		NewMeetingWindow.setFrameVisible(false);
		
		//lukk vinduet
				
	}
	
	public void searchForMeetingRoom(){
		if(model.getMeetingtype()==MeetingType.meeting){
			int cap = model.getNumberOfInvited();
			String from = model.getFullStartTime();
			String to = model.getFullEndTime();
			Element data = new Element("data");
			Element capacity = new Element("capacity");
			capacity.appendChild(Integer.toString(cap));			
			Element toDateTime = new Element("toDateTime");
			toDateTime.appendChild(to);
			Element fromDateTime = new Element("fromDateTime");
			fromDateTime.appendChild(from);
			data.appendChild(capacity);
			data.appendChild(fromDateTime);
			data.appendChild(toDateTime);
			Message message = new Message(MessageType.searchMeetingRoom);
			message.addDataElement(data);
			ClientConnectionContext.getInstance().connectionHandler.sendMessage(message);
		}
	}
	
	public void updateMeetingRoomSearch(ArrayList<MeetingRoom> result){
		
	}
	
	
	
	public void searchForUsers(){
		Element element = new Element("data");
		Element search = new Element("searchString");
		search.appendChild(model.getParticipantSearch());
		element.appendChild(search);
		Message message = new Message(MessageType.searchUser);
		message.addDataElement(element);
		ClientConnectionContext.getInstance().connectionHandler.sendMessage(message);
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
	
	public void setMeetingType(Meeting.MeetingType meetingType) {
		model.setMeetingtype(meetingType);
	}

	@Override
	public void handleEvent(Event<?> event) {
		switch(event.eventType) {
		case SEARCH_MEETINGROOM_RESULT:
			this.updateMeetingRoomSearch((ArrayList<MeetingRoom>) event.getEventParameterObject());
	}		
	}
}
