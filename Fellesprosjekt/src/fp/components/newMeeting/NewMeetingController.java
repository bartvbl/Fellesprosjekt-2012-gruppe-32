package fp.components.newMeeting;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.events.EventDispatcher;

public class NewMeetingController extends AbstractComponentController {

	NewMeetingModel meeting;
	
	public NewMeetingController(EventDispatcher eventDispatcher,NewMeetingModel meeting){
		super(ComponentControllerType.NEW_MEETING_VIEW, eventDispatcher);
		this.meeting = meeting;
	}
	
	public void create(){
		
	}
	
	public void cancel(){
		
	}

}
