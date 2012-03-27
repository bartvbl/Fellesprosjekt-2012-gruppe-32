package fp.dataObjects;

import java.util.ArrayList;

public class DayMeetingList {
	public final CalendarDate date;
	
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>();

	public DayMeetingList(CalendarDate date) {
		this.date = date;
	}
	
	public void addMeeting(Meeting meeting) {
		this.meetings.add(meeting);
	}
	
	public int getNumberOfMeetings() {
		return this.meetings.size();
	}
	
	public Meeting getMeeting(int index) {
		return this.meetings.get(index);
	}
}
