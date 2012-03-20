package fp.components.smallCalendar;

import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import fp.views.SmallCalendarPanel;

public class SmallCalendarModel {
	private java.util.Calendar calendar;
	private int selectedWeekNumber;
	
	public SmallCalendarModel() {
		this.calendar = java.util.Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
		this.selectedWeekNumber = this.calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	public void incrementMonth() {
		int currentMonth = this.calendar.get(Calendar.MONTH);
		currentMonth++;
		if(currentMonth > 11) {
			currentMonth = 0;
			this.calendar.set(Calendar.YEAR, this.calendar.get(Calendar.YEAR) + 1);
		}
		this.calendar.set(Calendar.MONTH, currentMonth);
	}
	
	public void decrementMonth() {
		int currentMonth = this.calendar.get(Calendar.MONTH);
		currentMonth--;
		if(currentMonth < 0) {
			currentMonth = 11;
			this.calendar.set(Calendar.YEAR, this.calendar.get(Calendar.YEAR) - 1);
		}
		this.calendar.set(Calendar.MONTH, currentMonth);
	}
	
	public int[][] getDateRows() {
		return CalendarDateConstructor.getDateMatrix(this.calendar);
	}
	
	public String getMonthName() {
		return this.calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK);
	}
	
	public int getYear() {
		return this.calendar.get(Calendar.YEAR);
	}
	
	public int getSelectedWeekNumber() {
		return this.selectedWeekNumber;
	}
	
	public void setSelectedWeekNumber(int newWeekNumber) {
		this.selectedWeekNumber = newWeekNumber;
	}
	
	public int[] getWeekNumbersOfCurrentMonth() {
		return CalendarDateConstructor.getWeekListOfCurrentMonth(calendar);
	}
}
