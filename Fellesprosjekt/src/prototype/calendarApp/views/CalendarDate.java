package prototype.calendarApp.views;

public class CalendarDate {
	public boolean isCurrentMonth;
	public int dateDayNumber;

	public CalendarDate(int dateDayNumber, boolean isCurrentMonth) {
		this.dateDayNumber = dateDayNumber;
		this.isCurrentMonth = isCurrentMonth;
	}
}
