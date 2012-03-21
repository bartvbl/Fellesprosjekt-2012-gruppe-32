package fp.components.calendarViewer;

import java.util.Calendar;
import java.util.Date;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.components.smallCalendar.CalendarDateConstructor;
import fp.events.EventDispatcher;
import fp.models.DateSelectionModel;
import fp.views.CalendarView;
import fp.views.CalendarViewerView;

public class CalendarViewerController extends AbstractComponentController {

	private DateSelectionModel model;

	public CalendarViewerController(EventDispatcher eventDispatcher, DateSelectionModel model) {
		super(ComponentControllerType.CALENDAR_VIEW_CALENDAR_VIEWER, eventDispatcher);
		this.model = model;
	}

	public void updateWeek() {
		int weekNumber = this.model.getSelectedWeekNumber();
		int yearNumber = this.model.getSelectedYear();
		int[] dates = CalendarDateConstructor.getWeekDayDates(weekNumber, yearNumber);
		for(int i = 0; i < dates.length; i++) {
			CalendarViewerView.dayDatePanels[i].dateDayLabel.setText(" "+dates[i]);
		}
		String monthString = this.model.getSelectedMonthString();
		CalendarView.monthNameLabel.setText(monthString + " (week " + weekNumber + ")");
	}
	
	public void incrementSelectedWeek() {
		this.model.incrementWeek();
	}
	
	public void decrementSelectedWeek() {
		this.model.decrementWeek();
	}
	
	public void today(){
		Calendar CurrentDate = Calendar.getInstance();
	}

}
