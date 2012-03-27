package fp.dataObjects;

public class CalendarDate {
	public final int year;
	public final int week;
	public final int dayInWeek;

	public CalendarDate(int year, int week, int dayInWeek) {
		this.year = year;
		this.week = week;
		this.dayInWeek = dayInWeek;
	}
	
	public String toString(){
		return Integer.toString(dayInWeek)+"/"+Integer.toString(week)+"/"+Integer.toString(year);
	}
}
