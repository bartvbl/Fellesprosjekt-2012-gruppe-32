package fp.components.newMeeting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fp.componentHandlers.AbstractComponentHandler;
import fp.componentHandlers.ComponentHandlerType;
import fp.events.EventDispatcher;
import fp.views.NewMeetingWindow;
import fp.views.SmallCalendarPanel;

public class NewMeetingHandler extends AbstractComponentHandler implements ActionListener, ListSelectionListener{
	
	NewMeetingController controller;

	public NewMeetingHandler(EventDispatcher eventDispatcher, NewMeetingController controller) {
		super(ComponentHandlerType.NEW_MEETING_VIEW, eventDispatcher);
		this.controller = controller;
		this.addEventListeners();
		}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == NewMeetingWindow.createButton) {
			this.controller.create();
		} else if(event.getSource() == SmallCalendarPanel.prevMonthButton) {
			this.controller.cancel();
		}
	}
	
	public void addEventListeners(){
		NewMeetingWindow.createButton.addActionListener(this);
		NewMeetingWindow.cancelButton.addActionListener(this);
		NewMeetingWindow.newAppointmentButton.addActionListener(this);
		NewMeetingWindow.newMeetingButton.addActionListener(this);
		NewMeetingWindow.meetingRoomSearchResultList.getSelectionModel().addListSelectionListener(this);
		NewMeetingWindow.participantSearchResultList.getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
