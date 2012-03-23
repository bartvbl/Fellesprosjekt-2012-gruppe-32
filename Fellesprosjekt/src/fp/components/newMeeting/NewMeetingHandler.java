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
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.views.NewMeetingWindow;
import fp.views.SmallCalendarPanel;

public class NewMeetingHandler extends AbstractComponentHandler implements ActionListener, ListSelectionListener, KeyListener{
	
	NewMeetingModel model;

	public NewMeetingHandler(EventDispatcher eventDispatcher, NewMeetingModel model) {
		super(ComponentHandlerType.NEW_MEETING_VIEW, eventDispatcher);
		this.model = model;
		this.addEventListeners();
		}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == NewMeetingWindow.createButton) {
			model.createMeeting();
		} else if(event.getSource() == NewMeetingWindow.cancelButton) {
			cancelMeeting();
		}
	}
	
	public void createMeeting(){
		model.createMeeting();
	}
	
	public void cancelMeeting(){
		
	}
	
	public void addEventListeners(){
		NewMeetingWindow.createButton.addActionListener(this);
		NewMeetingWindow.cancelButton.addActionListener(this);
		NewMeetingWindow.newAppointmentButton.addActionListener(this);
		NewMeetingWindow.newMeetingButton.addActionListener(this);
		NewMeetingWindow.meetingRoomSearchResultList.getSelectionModel().addListSelectionListener(this);
		NewMeetingWindow.participantSearchResultList.getSelectionModel().addListSelectionListener(this);
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
				model.setRoomID((Integer) NewMeetingWindow.meetingRoomSearchResultList.getSelectedValue());
			}	
		}
		else if(listModel == NewMeetingWindow.participantSearchResultList.getSelectionModel()){
			if(listModel.getLeadSelectionIndex() != -1) {
				
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
			model.setDescription(NewMeetingWindow.appointmentTitleTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.startDateTextPane){
			model.setStartDate(NewMeetingWindow.startDateTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.startTimeTextPane){
			model.setStartTime(NewMeetingWindow.startTimeTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.endDateTextPane){
			model.setEndDate(NewMeetingWindow.endDateTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.endTimeTextPane){
			model.setEndTime(NewMeetingWindow.endTimeTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.participantSearchTextPane){
			model.setParticipantSearch(NewMeetingWindow.participantSearchTextPane.getText());
		}		
		else if(e.getSource()==NewMeetingWindow.locationSearchTextPane){
			model.setMeetingRoomSearch(NewMeetingWindow.locationSearchTextPane.getText());
		}
		else if(e.getSource()==NewMeetingWindow.manualLocationTextPane){
			model.setLocation(NewMeetingWindow.manualLocationTextPane.getText());
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
