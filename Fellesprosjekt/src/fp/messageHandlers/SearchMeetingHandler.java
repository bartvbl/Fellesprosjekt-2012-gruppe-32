package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import nu.xom.Element;

import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.UserConverter;

public class SearchMeetingHandler implements MessageHandler{

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public static Element searchUsers(String name) throws SQLException{

		int userID = 0;
		String userName = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		String phoneNumber = null;
		
		Element usersElement = new Element("Data");
		
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
}
