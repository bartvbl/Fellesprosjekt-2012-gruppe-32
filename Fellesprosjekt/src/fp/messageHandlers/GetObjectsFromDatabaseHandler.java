package fp.messageHandlers;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nu.xom.Element;

import fp.dataObjects.MeetingRoom;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.xmlConverters.MeetingRoomConverter;
import fp.xmlConverters.UserConverter;

public class GetObjectsFromDatabaseHandler {
	
	public static ArrayList<User> getUsers() throws SQLException{
		
		
		/*
		ArrayList<User> users = new ArrayList<User>();
		int userID = 0;
		ResultSet rs;
		String userName = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		String phoneNumber = null;
		
		String query = "Select * from Users";
		rs = DatabaseConnection.executeReadQuery(query);
		
		while(rs.next()){
			userID = rs.getInt("UserID");
			userName = rs.getString("UserName");
			password = rs.getString("Password");
			firstName = rs.getString("FirstName");
			lastName = rs.getString("LastName");
			email = rs.getString("Email");
			phoneNumber = rs.getString("PhoneNumber");
			User user = new User(userID, userName, password, firstName, lastName, email, phoneNumber);
			users.add(user);
		}
		return users;
	}
	
	*/
		
	
	//Returnerer et XML element med alle brukere som matcher s¿ket
	
	public static Element searchUsers(String name) throws SQLException{

		int userID = 0;
		String userName = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		String phoneNumber = null;
		
		Element usersElement = new Element("UserElement");
		
		String query = "SELECT * from User WHERE FirstName LIKE '" + name + "%' OR LastName LIKE '" + name + "%';";
		ResultSet rs = DatabaseConnection.executeReadQuery(query);
		while(rs.next()){
			userID = rs.getInt("UserID");
			userName = rs.getString("UserName");
			password = rs.getString("Password");
			firstName = rs.getString("FirstName");
			lastName = rs.getString("LastName");
			email = rs.getString("Email");
			phoneNumber = rs.getString("PhoneNumber");
			User user = new User(userID, userName, password, firstName, lastName, email, phoneNumber);
			Element element = UserConverter.convertUserToXML(user);
			
			usersElement.appendChild(element);
		}
		return usersElement;
	}
	
	
	
	//Returnerer et XML element med alle m¿terom som matcher s¿ket
	
	public static Element meetingRoomSearchResults(String capasity){
		
		Element meetingRoomElement = new Element("MeetingRoomElement");
		
		int meetingRoomID = 0;
		int size = 0;
		String name = null;
		
		String query = "SELECT * FROM MeetingRoom WHERE Size > =  '" + capasity + "';";
		ResultSet rs = DatabaseConnection.executeReadQuery(query);
		while(rs.next()){
			meetingRoomID = rs.getInt("RoomID");
			size = rs.getInt("Size");
			name = rs.getString("RoomName");
			
			MeetingRoom meetingRoom = new MeetingRoom(meetingRoomID, size, name);
			Element element = MeetingRoomConverter.convertMeetingRoomToXML(meetingRoom);
			meetingRoomElement.appendChild(element);
		}
		
		return meetingRoomElement; 
	}

}
