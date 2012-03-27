package fp.components.newMeeting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fp.componentHandlers.AbstractComponentHandler;
import fp.componentHandlers.ComponentHandlerType;
import fp.dataObjects.CalendarDate;
import fp.dataObjects.Meeting;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.views.NewMeetingWindow;

public class NewMeetingHandler extends AbstractComponentHandler implements ActionListener, ListSelectionListener, KeyListener, EventHandler{
	
	NewMeetingController controller;

	public NewMeetingHandler(EventDispatcher eventDispatcher, NewMeetingController controller) {
		super(ComponentHandlerType.NEW_MEETING_VIEW, eventDispatcher);
		this.controller = controller;
		this.addEventListeners();
		}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == NewMeetingWindow.createButton) {
			controller.create();
		} else if(event.getSource() == NewMeetingWindow.cancelButton) {
			controller.cancel();
		} else if(event.getSource() == NewMeetingWindow.newAppointmentButton) {
			controller.setMeetingType(Meeting.MeetingType.appointment);
		} else if(event.getSource() == NewMeetingWindow.newMeetingButton) {
			controller.setMeetingType(Meeting.MeetingType.meeting);
			controller.searchForMeetingRoom();
		}
//		else if(event.getSource() == NewMeetingWindow.addParticipantButton) {
//			if(!NewMeetingWindow.participantSearchResultList.isSelectionEmpty()) {
//				User user = (User) NewMeetingWindow.participantSearchResultList.getSelectedValue();
//				controller.addParticipant(user);
//			}
//		} else if(event.getSource() == NewMeetingWindow.removeParticipantButton) {
//			if(!NewMeetingWindow.invitedParticipantsList.isSelectionEmpty()) {
//				User user = (User) NewMeetingWindow.invitedParticipantsList.getSelectedValue();
//				controller.removeParticipant(user);
//			}
//		}
	}

	
	public void addEventListeners(){
		this.eventDispatcher.addEventListener(this, EventType.SHOW_NEW_MEETING);
		NewMeetingWindow.createButton.addActionListener(this);
		NewMeetingWindow.cancelButton.addActionListener(this);
		NewMeetingWindow.newAppointmentButton.addActionListener(this);
		NewMeetingWindow.newMeetingButton.addActionListener(this);
		NewMeetingWindow.meetingRoomSearchResultList.getSelectionModel().addListSelectionListener(this);
		NewMeetingWindow.startDateTextPane.addKeyListener(this);
		NewMeetingWindow.startTimeTextPane.addKeyListener(this);
		NewMeetingWindow.endDateTextPane.addKeyListener(this);
		NewMeetingWindow.endDateTextPane.addKeyListener(this);
		NewMeetingWindow.appointmentTitleTextPane.addKeyListener(this);
		NewMeetingWindow.locationSearchTextPane.addKeyListener(this);
		NewMeetingWindow.manualLocationTextPane.addKeyListener(this);
		NewMeetingWindow.participantSearchTextPane.addKeyListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		DefaultListSelectionModel listModel = (DefaultListSelectionModel)event.getSource();
		if(listModel == NewMeetingWindow.meetingRoomSearchResultList.getSelectionModel()){
			if(listModel.getLeadSelectionIndex() != -1) {
				controller.setRoomID((Integer) NewMeetingWindow.meetingRoomSearchResultList.getSelectedValue());
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==NewMeetingWindow.appointmentTitleTextPane){
			controller.setDescription(NewMeetingWindow.appointmentTitleTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.startDateTextPane){
			controller.setStartDate(NewMeetingWindow.startDateTextPane.getText());
			controller.searchForMeetingRoom();
		}
		else if(e.getSource()==NewMeetingWindow.startTimeTextPane){
			controller.setStartTime(NewMeetingWindow.startTimeTextPane.getText());
			controller.searchForMeetingRoom();
		}
		else if(e.getSource()==NewMeetingWindow.endDateTextPane){
			controller.setEndDate(NewMeetingWindow.endDateTextPane.getText());
			controller.searchForMeetingRoom();
		}
		else if(e.getSource()==NewMeetingWindow.endTimeTextPane){
			controller.setEndTime(NewMeetingWindow.endTimeTextPane.getText());
			controller.searchForMeetingRoom();
		}
		else if(e.getSource()==NewMeetingWindow.participantSearchTextPane){
			controller.setParticipantSearch(NewMeetingWindow.participantSearchTextPane.getText());
		}		
		else if(e.getSource()==NewMeetingWindow.locationSearchTextPane){
			controller.setMeetingRoomSearch(NewMeetingWindow.locationSearchTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.manualLocationTextPane){
			controller.setLocation(NewMeetingWindow.manualLocationTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.)

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEvent(Event<?> event) {
		switch(event.eventType) {
			case SHOW_NEW_MEETING:
				controller.setModel(new NewMeetingModel((CalendarDate) event.getEventParameterObject()));
				break;
		}
	}

}
