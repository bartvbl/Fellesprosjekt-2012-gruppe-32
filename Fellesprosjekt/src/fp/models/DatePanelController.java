package fp.models;

import fp.dataObjects.DayMeetingList;
import fp.dataObjects.Meeting;
import fp.views.DatePanel;
import fp.views.MeetingPanel;

public class DatePanelController {

	private DatePanel datePanel;
	private DayMeetingList currentMeetingList = null;
	private int MINUTES_IN_DAY = 1440;
	private int MIN_PANEL_HEIGHT = 100;

	public DatePanelController(DatePanel datePanel) {
		this.datePanel = datePanel;
	}
	
	public void displayMeetingList(DayMeetingList meetingList) {
		this.currentMeetingList = meetingList;
		this.redraw();
	}

	public void redraw() {
		this.datePanel.meetingViewLayeredPane.removeAll();
		if(this.currentMeetingList == null) {return;}
		for(int i = 0; i < this.currentMeetingList.getNumberOfMeetings(); i++) {
			Meeting currentMeeting = this.currentMeetingList.getMeeting(i);
			MeetingPanel meetingPanel = new MeetingPanel(currentMeeting);
			this.datePanel.meetingViewLayeredPane.add(meetingPanel, i);
			this.setPanelBounds(meetingPanel, currentMeeting);
		}
	}

	private void setPanelBounds(MeetingPanel meetingPanel, Meeting currentMeeting) {
		int panelHeight = this.datePanel.meetingViewLayeredPane.getBounds().height;
		int panelWidth = this.datePanel.getBounds().width;
		int startTimeInMinutes = this.getTimeInMinutes(currentMeeting.startTime);
		int endTimeInMinutes = this.getTimeInMinutes(currentMeeting.endTime);
		
		int meetingDuration = endTimeInMinutes - startTimeInMinutes;
		int meetingPanelHeight = (int) Math.max(MIN_PANEL_HEIGHT, ((double)panelHeight * ((double)meetingDuration / (double)MINUTES_IN_DAY)));
		int offsetY = (int) ((double)panelHeight * ((double)endTimeInMinutes / (double)MINUTES_IN_DAY));
		
		meetingPanel.setBounds(1, offsetY, panelWidth-3, meetingPanelHeight);
	}

	private int getTimeInMinutes(String dateTimeString) {
		int hours = Integer.parseInt(dateTimeString.substring(12,13));
		int minutes = Integer.parseInt(dateTimeString.substring(15,16));
		return 60*hours + minutes;
	}
	
}
