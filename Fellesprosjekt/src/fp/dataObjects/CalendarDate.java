package fp.dataObjects;

public class CalendarDate {
	public final int year;
	public final int week;
	public final int dayInWeek;

	public CalendarDate(int year, int week, int date) {
		this.year = year;
		this.week = week;
		this.dayInWeek = date;
	}
	
	public String toString(){
		return Integer.toString(dayInWeek)+"/"+Integer.toString(week)+"/"+Integer.toString(year);
	}
}
