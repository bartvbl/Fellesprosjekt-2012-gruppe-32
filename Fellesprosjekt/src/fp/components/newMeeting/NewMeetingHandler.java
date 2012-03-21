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
		} else if(event.getSource() == NewMeetingWindow.cancelButton) {
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
		DefaultListSelectionModel model = (DefaultListSelectionModel)event.getSource();
		if(model.getLeadSelectionIndex() != -1) {
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==NewMeetingWindow.appointmentTitleTextPane){
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
