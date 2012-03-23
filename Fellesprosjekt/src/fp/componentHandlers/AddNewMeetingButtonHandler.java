package fp.componentHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.components.newMeeting.NewMeetingHandler;
import fp.components.newMeeting.NewMeetingModel;
import fp.events.EventDispatcher;
import fp.views.DatePanel;
import fp.views.NewMeetingWindow;

public class AddNewMeetingButtonHandler extends AbstractComponentHandler implements ActionListener{

	private NewMeetingModel model;
	
	public AddNewMeetingButtonHandler(EventDispatcher eventDispatcher) {
		super(ComponentHandlerType.ADD_NEW_MEETING_BUTTON, eventDispatcher);
		addEventListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void addEventListeners(){
	}

}
