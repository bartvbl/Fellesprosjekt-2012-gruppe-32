package fp.messageHandlers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import nu.xom.Element;

import fp.components.smallCalendar.CalendarDateConstructor;
import fp.dataObjects.CalendarDate;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.CalendarDateConverter;

public class MeetingListRequestHandler implements MessageHandler {
	
	private static final String MYSQL_DATE_FORMAT = "yyyy-MM-dd";
	
	private SimpleDateFormat dateFormat;
	private Calendar calendar;

	public MeetingListRequestHandler() {
		this.dateFormat = new SimpleDateFormat(MYSQL_DATE_FORMAT);
		this.calendar = Calendar.getInstance();
		this.calendar.setFirstDayOfWeek(Calendar.MONDAY);
	}

	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		ArrayList<Element> requestedDays = message.getDataElements();
		for(Element dayRequest : requestedDays) {	
			CalendarDate date = CalendarDateConverter.convertXMLToCalendarDate(dayRequest);
			//System.out.println(getFormattedDateString(date.year, date.week, date.dayInWeek));
		}
	}
	
	//synchronized, as the Calendar and SimpleDateFormat classes are not thread safe
	private synchronized String getFormattedDateString(int year, int week, int dayInWeek) { 
		this.calendar.set(Calendar.YEAR, year);
		this.calendar.set(Calendar.WEEK_OF_YEAR, week);
		int dayNumber = CalendarDateConstructor.convertDayOfWeekIndexToCalendarDayIndex(dayInWeek);
		this.calendar.set(Calendar.DAY_OF_WEEK, dayNumber);
		
		Date currentCalendarDate = this.calendar.getTime();
		return this.dateFormat.format(currentCalendarDate);
	}

}
