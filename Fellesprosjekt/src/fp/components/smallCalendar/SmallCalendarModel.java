package fp.components.smallCalendar;

import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

public class SmallCalendarModel {
	private java.util.Calendar calendar;
	
	public SmallCalendarModel() {
		this.calendar = java.util.Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
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
}
