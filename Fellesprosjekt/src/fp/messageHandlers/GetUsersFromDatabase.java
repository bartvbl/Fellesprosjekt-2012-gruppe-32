package fp.messageHandlers;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.xmlConverters.UserConverter;

public class GetUsersFromDatabase {
	
	public static ArrayList<User> getUsers() throws SQLException{
		
		ArrayList<User> users;
		int userID = 0;
		String query;
		ResultSet rs;
		String userName = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		String phoneNumber = null;
		
		users = new ArrayList<User>();
		query = "Select * from Users";
		
		
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

}
