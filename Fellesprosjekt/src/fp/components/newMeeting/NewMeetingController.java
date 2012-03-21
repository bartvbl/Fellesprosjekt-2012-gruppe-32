package fp.components.newMeeting;

import nu.xom.Element;
import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.events.EventDispatcher;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.xmlConverters.MeetingConverter;

public class NewMeetingController extends AbstractComponentController {

	NewMeetingModel meeting;
	
	public NewMeetingController(EventDispatcher eventDispatcher,NewMeetingModel meeting){
		super(ComponentControllerType.NEW_MEETING_VIEW, eventDispatcher);
		this.meeting = meeting;
	}
	
	public void create(){
		meeting.createMeeting();
		Message message1 = new Message(MessageType.addMeeting, MeetingConverter.convertMeetingToXML(meeting.getMeeting()));
		
	}
	
	public void cancel(){
		
	}
	
	public void searchForMeetingRoom(){
		
	}
	
	public void searchForUsers(){
		
	}
	
	public void addUser(){
		
	}
	
	public void selectMeetingRoom(){
		
	}

}
