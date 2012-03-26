package fp.models;

import java.util.Calendar;
import java.util.Locale;

import fp.components.smallCalendar.CalendarDateConstructor;

public class DateSelectionModel {
	private java.util.Calendar calendar;
	private int selectedWeekNumber;
	private int selectedYearNumber;
	
	public DateSelectionModel() {
		this.calendar = java.util.Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
		this.selectedWeekNumber = this.calendar.get(Calendar.WEEK_OF_YEAR);
		this.selectedYearNumber = this.calendar.get(Calendar.YEAR);
		this.calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	}
	
	public int getSelectedYear() {
		return this.selectedYearNumber;
	}
	
	public int getSelectedWeekNumber() {
		return this.selectedWeekNumber;
	}
	
	public void incrementWeek() {
		this.calendar.add(Calendar.WEEK_OF_YEAR, 1);
	}
	
	public void decrementWeek() {
		this.calendar.add(Calendar.WEEK_OF_YEAR, -1);
	}
	
	public String getSelectedMonthString() {
		return CalendarDateConstructor.generateMonthString(calendar);
	}
	
	public void setSelectedWeekNumber(int newWeekNumber, int yearNumber) {
		this.selectedWeekNumber = newWeekNumber;
		this.selectedYearNumber = yearNumber;
		this.calendar.set(Calendar.WEEK_OF_YEAR, newWeekNumber);
		this.calendar.set(Calendar.YEAR, yearNumber);
	}
	
	public void setCalendarToToday(){
		this.calendar = Calendar.getInstance();
	}
}
