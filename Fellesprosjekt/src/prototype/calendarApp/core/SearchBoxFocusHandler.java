package prototype.calendarApp.core;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import prototype.calendarApp.views.CalendarView;

public class SearchBoxFocusHandler implements FocusListener {
	public static final String searchBoxMessage = "Search for people, appointments and meetings";
	
	@Override
	public void focusGained(FocusEvent arg0) {
		if(CalendarView.searchTextPane.getText().equals(searchBoxMessage)){
			CalendarView.searchTextPane.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if(CalendarView.searchTextPane.equals("")) {
			CalendarView.searchTextPane.setText(searchBoxMessage);
		}
	}

}
