package fp.models;

import java.util.Calendar;
import java.util.Locale;

import fp.components.smallCalendar.CalendarDateConstructor;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;

public class DateSelectionModel {
	private java.util.Calendar calendar;
	private int selectedWeekNumber;
	private int selectedYearNumber;
	private EventDispatcher eventDispatcher;
	
	public DateSelectionModel(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		this.createCalendarInstance();
		this.initializeSelectedWeek();
	}
	
	private void createCalendarInstance() {
		this.calendar = java.util.Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
	}

	private void initializeSelectedWeek() {
		int weekNumber = this.calendar.get(Calendar.WEEK_OF_YEAR);
		int yearNumber = this.calendar.get(Calendar.YEAR);
		this.setSelectedWeekNumber(weekNumber, yearNumber);
	}

	public int getSelectedYear() {
		return this.selectedYearNumber;
	}
	
	public int getSelectedWeekNumber() {
		return this.selectedWeekNumber;
	}
	
	public void incrementWeek() {
		this.calendar.add(Calendar.WEEK_OF_YEAR, 1);
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.SELECTED_WEEK_CHANGED));
	}
	
	public void decrementWeek() {
		this.calendar.add(Calendar.WEEK_OF_YEAR, -1);
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.SELECTED_WEEK_CHANGED));
	}
	
	public String getSelectedMonthString() {
		return CalendarDateConstructor.generateMonthString(calendar);
	}
	
	public void setSelectedWeekNumber(int newWeekNumber, int yearNumber) {
		this.selectedWeekNumber = newWeekNumber;
		this.selectedYearNumber = yearNumber;
		this.calendar.set(Calendar.WEEK_OF_YEAR, newWeekNumber);
		this.calendar.set(Calendar.YEAR, yearNumber);
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.SELECTED_WEEK_CHANGED));
	}
}
