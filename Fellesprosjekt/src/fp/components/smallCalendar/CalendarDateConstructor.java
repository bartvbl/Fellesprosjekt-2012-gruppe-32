package fp.components.smallCalendar;

import java.util.Calendar;
import java.util.Locale;

public class CalendarDateConstructor {
	private static Calendar calendar = null;
	
	private static Calendar getCalendar() {
		if(calendar == null){
			calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			}
		return calendar;
	}

	public static int[][] getDateMatrix(int month, int year) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int numberOfRows = getNumberOfWeeksInMonth(calendar);
		return createDateMatrix(numberOfRows, calendar);
	}
	
	public static int[] getWeekListOfCurrentMonth(int month, int year) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int startWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		int numberOfWeeks = getNumberOfWeeksInMonth(calendar);
		int[] weekList = new int[numberOfWeeks];
		for(int i = 0; i < numberOfWeeks; i++) {
			weekList[i] = startWeek + i;
		}
		return weekList;
	}

	private static int getNumberOfWeeksInMonth(Calendar calendar) {
		int daysInCurrentMonth = getDaysInCurrentMonth(calendar);
		int dayOfWeek = getDayOfTheWeek(calendar.get(Calendar.DAY_OF_WEEK));
		return ((daysInCurrentMonth + dayOfWeek - 2) / 7) + 1;
	}
	
	private static int getDaysInCurrentMonth(Calendar calendar) {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static int getDayOfTheWeek(int calendarDayOfWeek) {
		if(calendarDayOfWeek == Calendar.SUNDAY) { //workaround for Calendar's stupid setting that sunday is the start of the week
			calendarDayOfWeek = 7;
		} else {
			calendarDayOfWeek--;
		}
		return calendarDayOfWeek;
	}
	
	public static int convertDayOfWeekIndexToCalendarDayIndex(int dayOfWeek) {
		if(dayOfWeek == 6) {return 0;}
		return dayOfWeek++;
	}
	
	private static int[][] createDateMatrix(int numberOfRows, Calendar calendar) {
		int[][] matrix = new int[numberOfRows][7];
		int counter = 0;
		int daysInMonth = getDaysInCurrentMonth(calendar);
		for(int j = getDayOfTheWeek(calendar.get(Calendar.DAY_OF_WEEK))-1; j < 7; j++) {
			counter++;
			matrix[0][j] = counter;
		}
		for(int i = 1; i < numberOfRows; i++) {			
			for(int j = 0; j < 7; j++) {
				counter++;
				matrix[i][j] = counter;
				if(counter == daysInMonth) {return matrix;}
			}
		}
		return matrix;
	}
	
	public static int[] getWeekDayDates(int week, int year) {
		Calendar calendar = getCalendar();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		int[] dateNumberList = new int[7];
		for(int i = 0; i < 7; i++) {
			dateNumberList[i] = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		return dateNumberList;
	}

	public static String generateMonthString(int week, int year) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String monthString = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK);
		int currentMonth = calendar.get(Calendar.MONTH);
		calendar.add(Calendar.DAY_OF_MONTH, 6);
		if(calendar.get(Calendar.MONTH) != currentMonth) {
			monthString += "/" + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK);
		}
		calendar.add(Calendar.DAY_OF_MONTH, -6);
		return monthString;
	}

}
