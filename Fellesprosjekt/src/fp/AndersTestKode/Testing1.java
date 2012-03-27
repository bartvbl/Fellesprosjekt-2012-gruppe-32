package fp.AndersTestKode;

import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import nu.xom.Element;

import com.mysql.jdbc.Connection;

import fp.dataObjects.Meeting;
import fp.dataObjects.Meeting.LocationType;
import fp.dataObjects.Meeting.MeetingStatus;
import fp.dataObjects.Meeting.MeetingType;
//import fp.dataObjects.Meeting.Status;
import fp.database.DatabaseConnection;
import fp.messageHandlers.AddMeetingHandler;
import fp.messageHandlers.GetMeetingHandler;
import fp.messageHandlers.GetMeetingsInWeekHandler;
import fp.messageHandlers.RemoveMeetingHandler;
import fp.messageHandlers.UpdateMeetingHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.xmlConverters.MeetingConverter;

public class Testing1 {



		private String mysqlDriver="com.mysql.jdbc.Driver"; 
		private String url="jdbc:mysql://mysql.stud.ntnu.no/tronboe_fellesprosjekt"; 
		private java.sql.Connection conn;
		private void initializeDB() throws ClassNotFoundException, SQLException{
	
		Class.forName(mysqlDriver); 
		Properties props = new Properties(); 
		props.setProperty("user","tronboe_fp"); 
		props.setProperty("password","password"); 
		
		try{
			conn = DriverManager.getConnection(url, props);
			System.out.println("huasdasdrra");
		}catch(Exception e){
			System.out.println(e);
			System.out.println("lolol");
		}
		}

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		// TODO Auto-generated method stub
		
		/*
		Meeting meeting = new Meeting(5, "Test", "Hjemme", LocationType.location, "2012-12-12 00:00:00", "2012-12-15 00:00:00", Status.active, 1, 0, MeetingType.appointment);
		Element element = MeetingConverter.convertMeetingToXML(meeting);
		Message message = new Message(MessageType.addMeeting, element);
		AddMeetingHandler amh = new AddMeetingHandler();
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://mysql.stud.ntnu.no/tronboe_fellesprosjekt";
		String user = "tronboe_fp";
		String pw = "password";
		try {
			System.out.println("Starter connection");
			java.sql.Connection con = DriverManager.getConnection(url,user,pw);
			System.out.println("Connection success!");
			//amh.handleMessage(message, null);
			System.out.println("Ferdig");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e)3
		}
			*/
		Meeting meeting = new Meeting(2, "lol", "ol", LocationType.Location, "1111-11-11 11:11:11", "1111-11-11 11:11:11", MeetingStatus.Active, 123, 123, MeetingType.appointment);
		Element xml2 = MeetingConverter.convertMeetingToXML(meeting);
		
		Element xml = new Element("data");	
		Element fromDate = new Element("fromDate");
		fromDate.appendChild("2012-04-01 00:00:00");
		Element toDate = new Element("toDate");
		toDate.appendChild("2012-04-30 00:00:00");
		
		xml.appendChild(fromDate);
		xml.appendChild(toDate);
	
		
		Message message = new Message(MessageType.removeMeeting);
		message.addDataElement(xml);
		
		GetMeetingsInWeekHandler asd = new GetMeetingsInWeekHandler();
		GetMeetingHandler dsa = new GetMeetingHandler();
		
		try {
			DatabaseConnection.connect();
			System.out.println("remove");
			asd.handleMessage(message, null);
			//dsa.handleMessage(message, null);
			System.out.println("ferdig");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
