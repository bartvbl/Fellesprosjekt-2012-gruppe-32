package fp.messageHandlers;

import java.awt.TrayIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import nu.xom.Element;

import fp.dataObjects.CalendarDate;
import fp.dataObjects.DayMeetingList;
import fp.dataObjects.Meeting;
import fp.database.DatabaseConnection;
import fp.databaseReaders.MeetingReader;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;
import fp.util.CalendarDateConstructor;
import fp.xmlConverters.CalendarDateConverter;
import fp.xmlConverters.DayMeetingConverter;

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
		ArrayList<DayMeetingList> meetingLists = new ArrayList<DayMeetingList>();
		for(Element dayRequest : requestedDays) {	
			CalendarDate date = CalendarDateConverter.convertXMLToCalendarDate(dayRequest);
			String dateString = getFormattedDateString(date.year, date.week, date.dayInWeek);
			DayMeetingList meetingList = this.getDayMeetingList(date, dateString, clientContext);
			meetingLists.add(meetingList);
		}
		this.sendResponseMessage(meetingLists, clientContext);
	}

	//synchronized, as the Calendar and SimpleDateFormat classes are not thread safe
	private synchronized String getFormattedDateString(int year, int week, int dayInWeek) { 
		this.calendar.set(Calendar.YEAR, year);
		this.calendar.set(Calendar.WEEK_OF_YEAR, week);
		this.calendar.set(Calendar.DAY_OF_WEEK, dayInWeek);
		Date currentCalendarDate = this.calendar.getTime();
		return this.dateFormat.format(currentCalendarDate);
	}
	
	private DayMeetingList getDayMeetingList(CalendarDate date, String dateString, ServerClientContext clientContext) throws SQLException {
		ResultSet result =  DatabaseConnection.executeReadQuery("SELECT * FROM Meeting " +
																"LEFT JOIN Notifications ON (Meeting.MeetingID = Notifications.MeetingID) " +
																"WHERE (((" +//meeting is an appointment of the user
																		"(Meeting.MeetingType = 'appointment')" +
																		"AND (Meeting.CreatorID = "+clientContext.user.userID+")" +
																	") OR (" +//meeting is a meeting that the user is taking part in
																		"(Meeting.MeetingType = 'meeting')" +
																		"AND (Notifications.UserID = "+clientContext.user.userID+")" +
																		"AND (Notifications.AcceptedMeeting='Yes')" +
																")) AND (" +//meeting is on the specified day
																	"((Meeting.EndTime > '"+dateString+" 00:00:00')" +
																		"AND (Meeting.EndTime < '"+dateString+" 23:59:59'))" +
																	"OR ((Meeting.StartTime > '"+dateString+" 00:00:00')" +
																		"AND (Meeting.StartTime < '"+dateString+" 23:59:59'))" +
																") AND " +//meeting is active
																	"(Meeting.Status = 'Active')) ");
		DayMeetingList meetingList = new DayMeetingList(date);
		while(result.next()) {
			Meeting meeting = MeetingReader.readMeetingFromResultSet(result);
			meetingList.addMeeting(meeting);
		}
		return meetingList;
	}
	
	private void sendResponseMessage(ArrayList<DayMeetingList> meetingLists, ServerClientContext context) {
		Message responseMessage = new Message(MessageType.listMeetingsResponse);
		for(DayMeetingList meetingList : meetingLists) {
			Element dayMeetingElement = DayMeetingConverter.convertDayMeetingToXML(meetingList);
			responseMessage.addDataElement(dayMeetingElement);
		}
		context.connectionHandler.sendMessage(responseMessage);
	}

}
