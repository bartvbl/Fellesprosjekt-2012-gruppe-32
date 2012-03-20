package fp.components.smallCalendar;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class CalendarDateConstructor {

	public static int[][] getDateMatrix(Calendar calendar) {
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int numberOfRows = getNumberOfWeeksInMonth(calendar);
		return createDateMatrix(numberOfRows, calendar);
	}
	
	public static int[] getWeekListOfCurrentMonth(Calendar calendar) {
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
		int dayOfWeek = getDayOfTheWeek(calendar);
		return ((daysInCurrentMonth + dayOfWeek - 2) / 7) + 1;
	}
	
	private static int getDaysInCurrentMonth(Calendar calendar) {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	private static int getDayOfTheWeek(Calendar calendar) {
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek == Calendar.SUNDAY) { //workaround for Calendar's stupid setting that sunday is the start of the week
			dayOfWeek = 7;
		} else {
			dayOfWeek--;
		}
		return dayOfWeek;
	}
	
	private static int[][] createDateMatrix(int numberOfRows, Calendar calendar) {
		int[][] matrix = new int[numberOfRows][7];
		int counter = 0;
		int daysInMonth = getDaysInCurrentMonth(calendar);
		for(int j = getDayOfTheWeek(calendar)-1; j < 7; j++) {
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
	
	//public static int[] getWeekDayDates

}
