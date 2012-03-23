package fp.components.newMeeting;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

import nu.xom.Element;
import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.dataObjects.User;
import fp.events.EventDispatcher;
import fp.messageHandlers.GetObjectsFromDatabaseHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.xmlConverters.MeetingConverter;

public class NewMeetingController extends AbstractComponentController implements PropertyChangeListener {

	NewMeetingModel meeting;
	ArrayList<User> users;
	
	public NewMeetingController(EventDispatcher eventDispatcher,NewMeetingModel meeting){
		super(ComponentControllerType.NEW_MEETING_VIEW, eventDispatcher);
		this.meeting = meeting;
		meeting.addPropertyChangeListener(this);
		
	}
	
	public void create(){
		//opprett melding
		meeting.getMeeting();
		Message message1 = new Message(MessageType.addMeeting, MeetingConverter.convertMeetingToXML(meeting.getMeeting()));
		
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == NewMeetingModel.DESCRIPTION){
			
		}
		else if(evt.getPropertyName() == NewMeetingModel.CREATE_MEETING){
			
		}
		else if(evt.getPropertyName() == NewMeetingModel.INVITED){
			
		}		
		else if(evt.getPropertyName() == NewMeetingModel.PARTICIPANT_SEARCH){
			
		}		
		else if(evt.getPropertyName() == NewMeetingModel.MEETING_ROOM_SEARCH){
			
		}
		else if(evt.getPropertyName() == NewMeetingModel.MEETING_TYPE){
			
		}
		else if(evt.getPropertyName() == NewMeetingModel.LOCATION_TYPE){
			
		}
		else if(evt.getPropertyName() == NewMeetingModel.LOCATION){
			
		}
		
	}

}
