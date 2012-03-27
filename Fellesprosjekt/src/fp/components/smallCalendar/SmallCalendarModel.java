package fp.components.smallCalendar;

import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import fp.views.SmallCalendarPanel;

public class SmallCalendarModel {
	private java.util.Calendar calendar;
	
	public SmallCalendarModel() {
		this.calendar = java.util.Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
		this.calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	}
	
	public void incrementMonth() {
		this.calendar.add(Calendar.MONTH, 1);
	}
	
	public void decrementMonth() {
		this.calendar.add(Calendar.MONTH, -1);
	}
	
	public int[][] getDateRows() {
		return CalendarDateConstructor.getDateMatrix(getMonth(), getYear());
	}
	
	public String getMonthName() {
		return this.calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK);
	}
	
	public int getYear() {
		return this.calendar.get(Calendar.YEAR);
	}
	
	public int getMonth() {
		return this.calendar.get(Calendar.MONTH);
	}
	
	public int[] getWeekNumbersOfCurrentMonth() {
		return CalendarDateConstructor.getWeekListOfCurrentMonth(getMonth(), getYear());
	}
}
