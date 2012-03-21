package fp.components.smallCalendar;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import fp.views.SmallCalendarPanel;

public class SmallCalendarModel {
	private java.util.Calendar calendar;
	private int[] currentWeekList;
	
	public SmallCalendarModel() {
		this.calendar = java.util.Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
	}
	
	public void incrementMonth() {
		this.calendar.add(Calendar.MONTH, 1);
	}
	
	public void decrementMonth() {
		this.calendar.add(Calendar.MONTH, -1);
	}
	
	public int getYear() {
		return this.calendar.get(Calendar.YEAR);
	}
	
	public String getMonthName() {
		return this.calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK);
	}
	
	public int[][] generateDateRowsOfSmallCalendarTable() {
		this.currentWeekList = CalendarDateConstructor.getWeekListOfCurrentMonth(calendar);
		return CalendarDateConstructor.getDateMatrix(this.calendar);
	}
	
	public int getWeekBySmallCalendarTableRowID(int rowIndex) {
		return this.currentWeekList[rowIndex];
	}
	
	public boolean isWeekCurrentlyDisplayed(int selectedWeek, int selectedYear) {
		int currentSelectedWeekIndex = Arrays.binarySearch(this.currentWeekList, selectedWeek);
		int currentDisplayedYear = this.calendar.get(Calendar.YEAR);
		if((currentSelectedWeekIndex > -1) && (selectedWeek == currentDisplayedYear)){
			return true;
		} else {
			return false;
		}
	}

	public int getweekIndexByWeekNumber(int selectedWeek) {
		return Arrays.binarySearch(this.currentWeekList, selectedWeek);
	}
}
