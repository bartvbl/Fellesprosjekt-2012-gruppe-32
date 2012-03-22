package fp.models;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import fp.components.smallCalendar.CalendarDateConstructor;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.views.SmallCalendarPanel;

public class SmallCalendarModel {
	private java.util.Calendar calendar;
	private int[] currentWeekList;
	private int selectedWeekNumber;
	private EventDispatcher eventDispatcher;
	private int[][] dateMatrix;
	
	public SmallCalendarModel(EventDispatcher eventDispatcher) {
		this.calendar = java.util.Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
		this.eventDispatcher = eventDispatcher;
	}
	
	public void incrementMonth() {
		this.calendar.add(Calendar.MONTH, 1);
		this.update();
	}
	
	public void decrementMonth() {
		this.calendar.add(Calendar.MONTH, -1);
		this.update();
	}
	
	public void update() {
		this.currentWeekList = CalendarDateConstructor.getWeekListOfCurrentMonth(calendar);
		this.dateMatrix = CalendarDateConstructor.getDateMatrix(this.calendar);
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.SMALL_CALENDAR_MONTH_CHANGED));
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

	public void setSelectedTableIndex(int selectedTableIndex) {
		this.selectedWeekNumber = this.currentWeekList[selectedTableIndex];
	}

	public int getWeek() {
		return this.selectedWeekNumber;
	}
	
	public int getYear() {
		return this.calendar.get(Calendar.YEAR);
	}
	
	public String getMonthName() {
		return this.calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK);
	}
	
	public int[][] getDateTableRows() {
		return this.dateMatrix;
	}
}
