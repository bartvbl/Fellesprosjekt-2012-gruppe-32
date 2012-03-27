package fp.dataObjects;

public class CalendarDate {
	public final int year;
	public final int week;
	public final int date;

	public CalendarDate(int year, int week, int date) {
		this.year = year;
		this.week = week;
		this.date = date;
	}
	
	public String toString(){
		return Integer.toString(date)+"/"+Integer.toString(week)+"/"+Integer.toString(year);
	}
}
